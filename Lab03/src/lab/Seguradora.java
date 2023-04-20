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
		for (int i=0; i< this.listaClientes.size(); i++) {
			if (this.listaClientes.get(i).getNome() == cliente) {
				return this.listaClientes.remove(this.listaClientes.get(i));
			}
		}
		return false;
	}
	
	public void listarClientes() {
		for (int i=0; i < this.listaClientes.size(); i++) {
			System.out.println(this.listaClientes.toString());
		}
	}
	
	
	public boolean gerarSinistro() {
		
	}
	
	public boolean visualisarSinistro(String cliente) {
		
	}
	
	public void listarSinistros() {
		for (int i=0; i < this.listaSinistros.size(); i++) {
			System.out.println(this.listaSinistros.toString());
		}
	}
	
	public String toString() {
		return "Seguradora [nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", endereco=" + endereco
				+ ", listaSinistros=" + listaSinistros + ", listaClientes=" + listaClientes + "]";
	}
	
	
	
	
}
