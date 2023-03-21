package lab;

public class Sinistro {
	private int id;
	private String data;
	private String endereco;
	
	public Sinistro(int id, String data, String endereco) {
		this.id = id;
		this.data = data;
		this.endereco = endereco;		
	}
	
	//Getters e setters
	public int getID() {
		return id;
	}
	
	public void setID(int id) {
		this.id = id;
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
}
