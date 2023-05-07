package lab;

import java.util.ArrayList;

public class Seguradora {
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	private ArrayList<Sinistro> listaSinistros;
	private ArrayList<Cliente> listaClientes;
	
	//Construtor
	public Seguradora(String nome, String telefone, String email, String endereco) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.listaClientes = new ArrayList<Cliente>();
		this.listaSinistros = new ArrayList<Sinistro>();
	}

	//Getters e setters
	public String getNome() {
		return nome;
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
	
	public boolean cadastrarCliente(Cliente cliente) {
		return this.listaClientes.add(cliente);
	}	
	
	public boolean removerCliente(String cliente) {
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
				listaClientes.remove(clienteAtual);
				System.out.println("Removido da lista de clientes!");
				this.removerSinistro(cliente);
				return true;
			}			
		}
		System.out.println("Não foi encontrado o cliente" + cliente);
		return false;
	}
	
	public void removerSinistro(String cliente) {
		String identificador = "";		
		ArrayList<Sinistro> listaReserva = new ArrayList<Sinistro>();
		
		for (Sinistro sinistroAtual : listaSinistros) {
			Cliente clienteAtual = sinistroAtual.getCliente();
			
			if (clienteAtual instanceof ClientePF) {
				ClientePF pf = (ClientePF) clienteAtual;
				identificador = pf.getCPF();				
			}
			if (clienteAtual instanceof ClientePJ) {
				ClientePJ pj = (ClientePJ) clienteAtual;
				identificador = pj.getCNPJ();
			}
			if (identificador.equals(cliente)) {
				listaReserva.add(sinistroAtual);
				System.out.println("Removido da lista de sinistros!");
			}			
		}
		
		for (Sinistro sinistroAtual : listaReserva) {
			listaSinistros.remove(sinistroAtual);
		}
	}
	
	public void listarClientes(String tipoCliente) {
		for (Cliente clienteAtual : listaClientes) {			
			if ((clienteAtual instanceof ClientePF) && tipoCliente == "CPF") {
				System.out.println(clienteAtual.toString());				
			}
			if (clienteAtual instanceof ClientePJ && tipoCliente == "CNPJ") {
				System.out.println(clienteAtual.toString());
			}		
		}
	}
	
	public boolean visualisarSinistro(String cliente) {
		String identificador = "";
		int cont = 0;
		for (Sinistro sinistroAtual : listaSinistros) {
			Cliente clienteAtual = sinistroAtual.getCliente();
			
			if (clienteAtual instanceof ClientePF) {
				ClientePF pf = (ClientePF) clienteAtual;
				identificador = pf.getCPF();
				
			}
			else if (clienteAtual instanceof ClientePJ) {
				ClientePJ pj = (ClientePJ) clienteAtual;
				identificador = pj.getCNPJ();
			}
			if (identificador.equals(cliente)) {
				System.out.println(sinistroAtual);
				cont++;
			}			
		}
		if (cont == 0) {
			System.out.println("Nao existem sinistros nesse CPF/CNPJ");
		}
		return cont > 0;
	}
	
	public int contarSinistroCliente(Cliente cliente) {
		int cont = 0;
		for (Sinistro sinistroAtual : listaSinistros) {
			Cliente clienteAtual = sinistroAtual.getCliente();			
			if (clienteAtual == cliente) {
				cont++;
			}						
		}
		return cont;
	}
	
	public void listarSinistros() {
		int cont = 0;
		for (Sinistro sinistroAtual : listaSinistros) {
			System.out.println(sinistroAtual.toString());
		}
		if (cont == 0) {
			System.out.println("Não existem Sinistros nessa seguradora!");
		}
	}
	
	public void listarVeiculos() {
		int cont = 0;
		for (Sinistro sinistroAtual : listaSinistros) {
			System.out.println(sinistroAtual.getVeiculo());
		}
		if (cont == 0) {System.out.println("Não existem veículos nessa seguradora!");}
	}
	
	public boolean gerarSinistro(String data, Cliente cliente, Veiculo veiculo, Seguradora seguradora) {
		Sinistro sin = new Sinistro(data, cliente.getEndereco(), cliente, veiculo, seguradora);
		return this.listaSinistros.add(sin);
	}
	
	public double calcularPrecoSeguroCliente(Cliente cliente) {
		double score = cliente.calculaScore();
		int qntSinistros = this.contarSinistroCliente(cliente);
		return score * (1 + qntSinistros);
	}
	
	public double calcularReceita() {
		double soma = 0.0;
		for (Cliente clienteAtual : listaClientes) { 
			soma += this.calcularPrecoSeguroCliente(clienteAtual);
		}
		return soma;
	}
	
	public void transferenciaSeguro(Cliente fonte, Cliente alvo) {
		for(Sinistro sinistro : this.listaSinistros) {
			
			if(sinistro.getCliente() == fonte) {
				
				//ALTERA A POSSE
				fonte.removerVeiculo(sinistro.getVeiculo().getPlaca());
				alvo.adicionarVeiculo(sinistro.getVeiculo());
				//ALTERAR SINISTRO
				sinistro.setCliente(alvo);
			}
			
		}
		//NOVO CALCULO DE SEGUROS
		System.out.println("Novo score do cliente fonte:");
		System.out.println(fonte.calculaScore());
		System.out.println("Novo score do cliente alvo:");
		System.out.println(alvo.calculaScore());
		
		
	}
	
	public boolean removerVeiculoSeguradora(String placaVeiculo) {
		for(Sinistro sinistro : this.listaSinistros) {			
			if(sinistro.getVeiculo().getPlaca().equals(placaVeiculo)) { //quando se remove um veiculo, se remove o sinistro ligado a ele
				Cliente cliente = sinistro.getCliente();
				if (cliente instanceof ClientePF) {
					ClientePF pf = (ClientePF) cliente;
					this.removerSinistro(pf.getCPF());
				}
				if (cliente instanceof ClientePJ) {
					ClientePJ pj = (ClientePJ) cliente;
					this.removerSinistro(pj.getCNPJ());					
				}
				System.out.println("Veiculo removido da Seguradora!");
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		return "Seguradora [nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", endereco=" + endereco
				+ ", listaSinistros=" + listaSinistros + ", listaClientes=" + listaClientes + "]";
	}
	
	
	
}
