package lab;

import java.util.ArrayList;

public class Cliente {
	private String nome;
	private String endereco;
	private ArrayList<Veiculo> listaVeiculos;
	private double valorSeguro;
		
	//Constructor
	public Cliente(String nome, String endereco) {
		this.nome = nome;
		this.endereco = endereco;
		this.listaVeiculos = new ArrayList<Veiculo>();
		
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

	public String toString() {
		return ", nome=" + nome + ", endereco=" + endereco + ", listaVeiculos=" + listaVeiculos + "]";
	}

	public ArrayList<Veiculo> getListaVeiculos() {
		return listaVeiculos;
	}

	public boolean adicionarVeiculo(Veiculo veiculo) {
		return this.listaVeiculos.add(veiculo);
	}
	
	public boolean removerVeiculo(Veiculo veiculo) {
		return this.listaVeiculos.remove(veiculo);
	}

	public double getValorSeguro() {
		return valorSeguro;
	}

	public void setValorSeguro(double valorSeguro) {
		this.valorSeguro = valorSeguro;
	}	
	
	public double calculaScore() {
		return 1;
	};
	
	
}
