package lab;

public class Veiculo {
	private String placa;
	private String marca;
	private String modelo;
	private int anoFabricado;
	
	public Veiculo(String placa, String marca, String modelo, int anoFabricado) {
		this.placa = placa;
		this.marca= marca;
		this.modelo = modelo;
		this.anoFabricado = anoFabricado;
	}
	
	//Getters e setters
	public String getPlaca() {
		return placa;
	}
	
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public int getAnoFabricado() {
		return anoFabricado;
	}

	public void setAnoFabricado(int anoFabricado) {
		this.anoFabricado = anoFabricado;
	}

	public String toString() {
		return "Veiculo [placa=" + placa + ", marca=" + marca + ", modelo=" + modelo + ", anoFabricado=" + anoFabricado
				+ "]";
	}
}
