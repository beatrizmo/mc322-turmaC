package lab;

import java.time.LocalDate;
import java.util.Random;

public class Sinistro {
	final private int id;
	private LocalDate data;
	private String endereco;
	private Condutor condutor;
	private Seguro seguro;
	
	//Constructor	
	public Sinistro(LocalDate data, String endereco, Condutor condutor, Seguro seguro) {
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
	
	public LocalDate getData() {
		return data;
	}
	
	public void setData(LocalDate data) {
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
