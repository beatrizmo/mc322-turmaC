package lab;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

public class Seguradora {
	private final String CNPJ;
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	private ArrayList<Seguro> listaSeguros;
	private ArrayList<Cliente> listaClientes;

	//Construtor
	public Seguradora(String CNPJ, String nome, String telefone, String email, String endereco) {		
		this.CNPJ = gerarCNPJ(CNPJ);
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.listaClientes = new ArrayList<Cliente>();
		this.listaSeguros = new ArrayList<Seguro>();
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

	public boolean gerarSeguro(String cliente, Date dataInicio, Date dataFim, Veiculo veiculo) {	
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
					return true;
				}
			}

		}			
		System.out.println("Não foi encontrado o cliente" + cliente);
		return false;
	}

	public boolean gerarSeguro(String cliente, Date dataInicio, Date dataFim, Frota frota) {
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

	
	
	public String toString() {
		return "Seguradora [nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", endereco=" + endereco
				+ ", listaSeguros=" + listaSeguros + ", listaClientes=" + listarClientesPorID("CPF") + " " +listarClientesPorID("CNPJ") + "]";
	}



}
