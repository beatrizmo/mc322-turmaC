package lab;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;

public class Seguradora {
	private final String CNPJ;
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	private ArrayList<Seguro> listaSeguros;
	private ArrayList<Cliente> listaClientes;
	private ArquivoClientePF arquivoClientePF;
	private ArquivoClientePJ arquivoClientePJ;
	private ArquivoVeiculo arquivoVeiculo;
	private ArquivoFrota arquivoFrota;
	private ArquivoCondutor arquivoCondutor;
	private ArquivoSeguro arquivoSeguro;
	private ArquivoSinistro arquivoSinistro;

	//Construtor
	public Seguradora(String CNPJ, String nome, String telefone, String email, String endereco) {		
		this.CNPJ = gerarCNPJ(CNPJ);
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.listaClientes = new ArrayList<Cliente>();
		this.listaSeguros = new ArrayList<Seguro>();
		this.arquivoVeiculo = new ArquivoVeiculo();
		this.arquivoClientePF = new ArquivoClientePF();
		this.arquivoClientePJ = new ArquivoClientePJ();
		this.arquivoFrota = new ArquivoFrota();
		this.arquivoCondutor = new ArquivoCondutor();
		this.arquivoSeguro = new ArquivoSeguro();
		this.arquivoSinistro = new ArquivoSinistro();
	}

	//Getters e setters
	public String getNome() {
		return nome;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	private String gerarCNPJ(String CNPJ) {
		if (Validacao.validarCNPJ(CNPJ)) {
			return CNPJ;
		}
		return "CNPJ invalido";
	}

	public ArrayList<Seguro> getListaSeguros() {
		return listaSeguros;
	}

	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}

	public boolean cadastrarCliente(Cliente cliente) {
		return this.listaClientes.add(cliente);
	}	

	public Cliente getClientePorID(String cliente) {
		String identificador = "";
		for (Cliente clienteAtual : listaClientes) {			
			if (clienteAtual instanceof ClientePF) {
				ClientePF pf = (ClientePF) clienteAtual;
				identificador = pf.getCPF();				
			}
			if (clienteAtual instanceof ClientePJ) {
				ClientePJ pj = (ClientePJ) clienteAtual;
				identificador = pj.getCNPJ();
			}
			if (identificador.equals(cliente)) {
				return clienteAtual;
			}			
		}
		return null;
	}
	
	public boolean removerCliente(String cliente) {
		Cliente clienteAtual = getClientePorID(cliente);
		if (clienteAtual == null) {
			System.out.println("Não foi encontrado o cliente" + cliente);
			return false;
		}
		else {
			listaClientes.remove(clienteAtual);
			this.cancelarSeguro(cliente);
			return true;
		}
		
	}

	public boolean gerarSeguro(String cliente, LocalDate dataInicio, LocalDate dataFim, Veiculo veiculo) {	
		String identificador = "";
		for (Cliente clienteAtual : listaClientes) {			
			if (clienteAtual instanceof ClientePF) {
				ClientePF pf = (ClientePF) clienteAtual;
				identificador = pf.getCPF();
				if (identificador.equals(cliente)) {
					Seguro seguro = new SeguroPF(dataInicio,dataFim,this,veiculo,pf);
					listaSeguros.add(seguro);
					seguro.calcularValor();
					String valorFormatado = String.format("%.2f", seguro.getValorMensal());
					System.out.println("Valor Mensal: R$"+ valorFormatado);
					gravarDados(seguro);
					return true;
				}
			}

		}			
		System.out.println("Não foi encontrado o cliente" + cliente);
		return false;
	}

	public boolean gerarSeguro(String cliente, LocalDate dataInicio, LocalDate dataFim, Frota frota) {
		String identificador = "";
		for (Cliente clienteAtual : listaClientes) {			
			if (clienteAtual instanceof ClientePJ) {
				ClientePJ pj = (ClientePJ) clienteAtual;
				identificador = pj.getCNPJ();
				if (identificador.equals(cliente)) {
					Seguro seguro = new SeguroPJ(dataInicio,dataFim,this,frota,pj);
					listaSeguros.add(seguro);
					seguro.calcularValor();
					String valorFormatado = String.format("%.2f", seguro.getValorMensal());
					System.out.println("Valor Mensal: R$" + valorFormatado);
					gravarDados(seguro);
					return true;
				}
			}
		}			
		System.out.println("Não foi encontrado o cliente" + cliente);
		return false;
	}

	public boolean cancelarSeguro(String cliente) {
		String identificador = "";		
		ArrayList<Seguro> listaReserva = new ArrayList<Seguro>();
		for (Seguro seguroAtual : listaSeguros) {			
			if (seguroAtual instanceof SeguroPF) {
				SeguroPF spf = (SeguroPF) seguroAtual;
				identificador = spf.getCliente().getCPF();				
			}
			if (seguroAtual instanceof SeguroPJ) {
				SeguroPJ spj = (SeguroPJ) seguroAtual;
				identificador = spj.getCliente().getCNPJ();
			}
			if (identificador.equals(cliente)) {
				listaReserva.add(seguroAtual);
			}			
		}
		int cont = 0;
		for (Seguro seguroAtual : listaReserva) {
			cont++;
			listaSeguros.remove(seguroAtual);
		}
		return (cont>0);
	}

	public ArrayList <Cliente> listarClientes(String tipoCliente) {
		ArrayList <Cliente> listaReserva = new ArrayList<Cliente>();
		for (Cliente clienteAtual : listaClientes) {			
			if ((clienteAtual instanceof ClientePF) && tipoCliente == "CPF") {
				listaReserva.add(clienteAtual);				
			}
			if ((clienteAtual instanceof ClientePJ) && tipoCliente == "CNPJ") {
				listaReserva.add(clienteAtual);
			}		
		}
		return listaReserva;
	}

	public double calcularReceita() {
		double soma = 0.0;
		for (Seguro seguroAtual : listaSeguros) { 
			seguroAtual.calcularValor();
			soma += seguroAtual.getValorMensal();
		}
		return soma;
	}	

	public ArrayList<Seguro> getSegurosPorCliente(String cliente) {
		String identificador = "";
		ArrayList<Seguro> segurosCliente = new ArrayList<Seguro>() ;
		for (Seguro seguro : listaSeguros) {
			if (seguro instanceof SeguroPF) {
				SeguroPF spf = (SeguroPF) seguro;
				identificador = spf.getCliente().getCPF();
			}
			if (seguro instanceof SeguroPJ) {
				SeguroPJ spj = (SeguroPJ) seguro;
				identificador = spj.getCliente().getCNPJ();
			}
			if (identificador.equals(cliente)) {
				segurosCliente.add(seguro);
			}
		}
		return segurosCliente;
	}

	public ArrayList<Sinistro> getSinistroPorCliente(String cliente) {
		ArrayList<Seguro> seguroCliente = new ArrayList<Seguro>();
		ArrayList<Sinistro> sinistroCliente = new ArrayList<Sinistro>();
		seguroCliente = getSegurosPorCliente(cliente);		
		for (Seguro seguro : seguroCliente) {
			for (Sinistro sinistro : seguro.getListaSinistros()) {
				sinistroCliente.add(sinistro);
			}			
		}
		return sinistroCliente;
	}

	public ArrayList<Veiculo> getVeiculosPorCliente(String cliente) {
		String identificador = "";
		ArrayList<Veiculo> veiculosCliente = new ArrayList<Veiculo>() ;
		for (Seguro seguro : listaSeguros) {			
			if (seguro instanceof SeguroPF) {				
				SeguroPF spf = (SeguroPF) seguro;
				identificador = spf.getCliente().getCPF();
				if (identificador.equals(cliente)) {
					veiculosCliente.add(spf.getVeiculo());
				}
			}
			if (seguro instanceof SeguroPJ) {
				SeguroPJ spj = (SeguroPJ) seguro;
				identificador = spj.getCliente().getCNPJ();
				if (identificador.equals(cliente)) {
					for(Veiculo veiculo : spj.getFrota().getListaVeiculos())
						veiculosCliente.add(veiculo);
				}
			}
		}
		HashSet<Veiculo> segurosCliente = new HashSet<Veiculo>(veiculosCliente); //removendo possiveis duplicatas de veiculos        
		veiculosCliente.clear();
        veiculosCliente.addAll(segurosCliente);        
		return veiculosCliente;
	}
	
	public ArrayList<Frota> getFrotasPorCliente(String cliente) {
		String identificador = "";
		ArrayList<Frota> frotasCliente = new ArrayList<Frota>() ;
		for (Seguro seguro : listaSeguros) {
			if (seguro instanceof SeguroPJ) {
				SeguroPJ spj = (SeguroPJ) seguro;
				identificador = spj.getCliente().getCNPJ();
				if (identificador.equals(cliente)) {
					frotasCliente.add(spj.getFrota());
				}
			}
		}
		HashSet<Frota> segurosCliente = new HashSet<Frota>(frotasCliente); //removendo possiveis duplicatas de frotas       
		frotasCliente.clear();
        frotasCliente.addAll(segurosCliente);        
		return frotasCliente;
	}
	
	public String listarClientesPorID(String tipoCliente) {
		String listaReserva = "";
		for (Cliente clienteAtual : listaClientes) {			
			if ((clienteAtual instanceof ClientePF) && tipoCliente == "CPF") {
				ClientePF pf = (ClientePF) clienteAtual;
				listaReserva +=  pf.getCPF();		
				listaReserva += " ";
			}
			if ((clienteAtual instanceof ClientePJ) && tipoCliente == "CNPJ") {
				ClientePJ pj = (ClientePJ) clienteAtual;
				listaReserva += pj.getCNPJ();
				listaReserva += " ";
			}			
		}
		return listaReserva;
	}

	public void gravarDados(Seguro seguro) {
		ArrayList<String> listaSinistros = seguro.getIDsSinistros();
		ArrayList<String> listaCondutores = seguro.getCPFCondutores();
		String valor = String.format("%.2f",seguro.getValorMensal());
		
		String conteudo = (seguro.getID() + "," + seguro.getDataInicio() + "," + seguro.getDataFim() + "," + seguro.getSeguradora().getNome() + ","
                + String.join(",", listaSinistros) + "," + String.join(",", listaCondutores) + "," + valor);
		try {
			arquivoSeguro.gravarArquivo(conteudo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void gravarDados(Sinistro sinistro) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dataFormatada = sinistro.getData().format(formato);
        
		String conteudo = (sinistro.getID() + "," + dataFormatada + "," + sinistro.getEndereco() + "," + 
                sinistro.getCondutor().getCPF() + "," + sinistro.getSeguro().getID());
		try {
			arquivoSinistro.gravarArquivo(conteudo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Veiculo> lerVeiculo(ArrayList<Veiculo> listaVeiculos) throws NumberFormatException, IOException {
		for (String veiculo : arquivoVeiculo.lerArquivo()) {
			String[] campos = veiculo.split(",");
            String placa = campos[0].trim();
            String marca = campos[1].trim();
            String modelo = campos[2].trim();
            int anoFabr = Integer.parseInt(campos[3].trim());
            Veiculo veiculoNovo = new Veiculo(placa,marca,modelo,anoFabr);
            listaVeiculos.add(veiculoNovo);           
		}
		return listaVeiculos;
	}
	
	public ArrayList<Frota> lerFrota(ArrayList<Frota> listaFrota, ArrayList<Veiculo> listaVeiculos) throws NumberFormatException, IOException {
		for (String frota : arquivoFrota.lerArquivo()) {
			String[] campos = frota.split(",");
            String code = campos[0].trim();
            String placa1 = campos[1].trim();
            String placa2 = campos[2].trim();
            String placa3 = campos[3].trim();
            Frota frotaNova = new Frota(code);
            for (Veiculo veiculo : listaVeiculos) {
            	if (veiculo.getPlaca().equals(placa1) || veiculo.getPlaca().equals(placa2) 
            			|| veiculo.getPlaca().equals(placa3)) {
            		frotaNova.addVeiculo(veiculo);
            	}
            }
            listaFrota.add(frotaNova);    
		}
		return listaFrota;
	}
	
	public ArrayList<ClientePF> lerClientePF(ArrayList<ClientePF> listaClientesPF, ArrayList<Veiculo> listaVeiculos) throws IOException {
		for (String clientePF : arquivoClientePF.lerArquivo()) {
			String[] campos = clientePF.split(",");
            String CPF = campos[0].trim();
            String nome = campos[1].trim();
            String telefone = campos[2].trim();
            String endereco = campos[3].trim();
            String email = campos[4].trim();
            String genero = campos[5].trim();
            String educacao = campos[6].trim();
            String date = campos[7].trim();
            String placa = campos[8].trim();
            //formatando a data
            LocalDate dataNasc = LocalDate.parse(date);	
            ClientePF clientePFNovo = new ClientePF(nome, telefone, endereco, email, CPF, genero, educacao, dataNasc);
            for (Veiculo veiculo : listaVeiculos) {
            	if (veiculo.getPlaca().equals(placa)) {
            		clientePFNovo.cadastrarVeiculo(veiculo);
            	}
            }
            listaClientesPF.add(clientePFNovo);
		}
		return listaClientesPF;
	}
	
	public ArrayList<Condutor> lerCondutor(ArrayList<Condutor> listaCondutores) throws IOException {
		for (String condutor : arquivoCondutor.lerArquivo()) {
			String[] campos = condutor.split(",");
            String CPF = campos[0].trim();
            String nome = campos[1].trim();
            String telefone = campos[2].trim();
            String endereco = campos[3].trim();
            String email = campos[4].trim();
            String date = campos[5].trim();
            //formatando a data
            LocalDate dataNasc = LocalDate.parse(date);   		
            Condutor condutorNovo = new Condutor(CPF,nome,telefone,endereco,email,dataNasc);
            listaCondutores.add(condutorNovo);
		}
		return listaCondutores;
	}
	
	public ArrayList<ClientePJ> lerClientePJ(ArrayList<ClientePJ> listaClientesPJ, ArrayList<Frota> listaFrota) throws IOException {
		for (String clientePJ : arquivoClientePJ.lerArquivo()) {
			String[] campos = clientePJ.split(",");
            String CNPJ = campos[0].trim();
            String nome = campos[1].trim();
            String telefone = campos[2].trim();
            String endereco = campos[3].trim();
            String email = campos[4].trim();
            String date = campos[5].trim();
            String code = campos[6].trim();
            //formatando a data
            LocalDate dataFund = LocalDate.parse(date);   		
            ClientePJ clientePJNovo = new ClientePJ(nome, telefone, endereco, email, CNPJ, 20, dataFund);
            for (Frota frota : listaFrota) {
            	if (frota.getCode().equals(code)) {
            		clientePJNovo.cadastrarFrota(frota);
            	}
            }
            listaClientesPJ.add(clientePJNovo);
		}
		return listaClientesPJ;
	}
	
	public void lerDados() throws IOException {
		ArrayList<Veiculo> listaVeiculos = new ArrayList<>();	
		ArrayList<Frota> listaFrota = new ArrayList<>();
		ArrayList<Condutor> listaCondutores = new ArrayList<>();
		ArrayList<ClientePF> listaClientesPF = new ArrayList<>();
		ArrayList<ClientePJ> listaClientesPJ = new ArrayList<>();
		
		//ler e instanciar veiculos
		listaVeiculos = lerVeiculo(listaVeiculos);
		//ler e instanciar frotas
		listaFrota = lerFrota(listaFrota, listaVeiculos);
		//ler e instanciar clientesPF
		listaClientesPF = lerClientePF(listaClientesPF, listaVeiculos);
		//ler e instanciar condutor
		listaCondutores = lerCondutor(listaCondutores);		
		//ler e instanciar clientesPJ
		listaClientesPJ = lerClientePJ(listaClientesPJ, listaFrota);
	}
	
	
	public String toString() {
		return "Seguradora [nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", endereco=" + endereco
				+ ", listaSeguros=" + listaSeguros + ", listaClientes=" + listarClientesPorID("CPF") + " " +listarClientesPorID("CNPJ") + "]";
	}



}
