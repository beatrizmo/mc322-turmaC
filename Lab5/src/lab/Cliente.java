package lab;

import java.util.ArrayList;

public abstract class Cliente {
	private String nome;
	private String telefone;
	private String endereco;
	private String email;
		
	//Constructor
	public Cliente(String nome, String telefone, String endereco, String email) {
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.email = email;
	}
	
	//Getters e setters
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}	
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String toString() {
		return "Cliente [nome=" + nome + ", telefone=" + telefone + ", endereco=" + endereco + ", email=" + email + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/*public ArrayList<Veiculo> getListaVeiculos() {
		return listaVeiculos;
	}

	public boolean adicionarVeiculo(Veiculo veiculo) {
		return this.listaVeiculos.add(veiculo);
	}
	
	public boolean removerVeiculo(String placaVeiculo) {
		for(Veiculo veiculo : this.listaVeiculos) {			
			if(veiculo.getPlaca() == placaVeiculo) {
				System.out.println("Veículo removido de cliente!");
				return this.listaVeiculos.remove(veiculo); 				
			}
		}
		return false;
	}*/
	/*
	public double getValorSeguro() {
		return valorSeguro;
	}	
	
	public void setValorSeguro(double valorSeguro) {
		this.valorSeguro = valorSeguro;
	}

	public double calculaScore() {
		return 1;
	}*/

	
	
	
}
