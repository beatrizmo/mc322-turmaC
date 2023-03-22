package lab;

import java.util.Random;

public class Sinistro {
	private int id;
	private String data;
	private String endereco;
	
	public Sinistro(String data, String endereco) {
		Random random =  new Random();
		this.id = Math.abs(random.nextInt());
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
}
