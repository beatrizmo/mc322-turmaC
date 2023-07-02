package lab;

import java.util.Date;
import java.util.Random;

public class Sinistro {
	final private int id;
	private Date data;
	private String endereco;
	private Condutor condutor;
	private Seguro seguro;
	
	//Constructor	
	public Sinistro(Date data, String endereco, Condutor condutor, Seguro seguro) {
		this.id = gerarIdRandom();
		this.data = data;
		this.endereco = endereco;
		this.condutor = condutor;
		this.seguro = seguro;
	}
	
	//Getters e setters
	public int getID() {
		return id;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public Seguro getSeguro() {
		return seguro;
	}

	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}

	public Condutor getCondutor() {
		return condutor;
	}

	public void setCondutor(Condutor condutor) {
		this.condutor = condutor;
	}

	public String toString() {
		return "Sinistro [id=" + id + ", data=" + data + ", endereco=" + endereco + ", condutor=" + condutor.getCPF()
				+ ", seguro=" + seguro.getID() + "]";
	}

	//Função gerar id aleatório	
	private int gerarIdRandom() {
		Random random =  new Random();
		return Math.abs(random.nextInt());
	}
}
