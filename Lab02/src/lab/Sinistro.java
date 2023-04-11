package lab;

import java.util.Random;

public class Sinistro {
	private int id;
	private String data;
	private String endereco;
	
	//Construtor	
	public Sinistro(String data, String endereco) {
		this.id = gerarIdRandom();
		this.data = data;
		this.endereco = endereco;		
	}
	
	//Getters e setters
	public int getID() {
		return id;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}	
	
	public String toString() {
		String s = "*Dados do Sinistro*\nID: " + getID() + "\nData: " + getData() + "\nEndereco: " + getEndereco();
		return s;
	}
	
	//Função gerar id aleatório	
	private int gerarIdRandom() {
		Random random =  new Random();
		return Math.abs(random.nextInt());
	}
}
