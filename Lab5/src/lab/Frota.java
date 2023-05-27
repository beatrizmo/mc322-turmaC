package lab;

import java.util.ArrayList;
import java.util.Scanner;

public class Frota {
	private String code;
	private ArrayList<Veiculo> listaVeiculos;
	
	public Frota(String code) {
		super();
		this.code = code;
		this.listaVeiculos = new ArrayList<Veiculo>();
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public ArrayList<Veiculo> getListaVeiculos() {
		return listaVeiculos;
	}
	
	private Veiculo obterVeiculo() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite a placa do veiculo:");
		String placa = entrada.nextLine();
		
		System.out.println("Digite a marca do veiculo:");
		String marca = entrada.nextLine();

		System.out.println("Digite a modelo do veiculo:");
		String modelo = entrada.nextLine();
		
		System.out.println("Digite o ano de fabricacao do veiculo:");
		String ano = entrada.nextLine();
		int anoFabricado = Integer.parseInt(ano);								
		
		Veiculo veiculo = new Veiculo(placa, marca, modelo, anoFabricado);
		entrada.close();
		return veiculo;
	}
	
	public boolean addVeiculo() {
		System.out.println("Dados para o veiculo a ser adicionado:");
		Veiculo veiculo = this.obterVeiculo();
		return this.listaVeiculos.add(veiculo);
	}
	
	public boolean removeVeiculo() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite o numero do veiculo que se deseja remover:");
		for (Veiculo veiculoAtual : this.listaVeiculos) {
			int index = 1 + this.listaVeiculos.indexOf(veiculoAtual);
			System.out.println(index + "- Placa: " + veiculoAtual.getPlaca());
		}		
		String S = entrada.nextLine();
		int s = Integer.parseInt(S);
		Veiculo veiculo = listaVeiculos.get(s-1);
		entrada.close();
		return listaVeiculos.remove(veiculo);
	}
	
	public String toString() {
		return "Frota [code=" + code + ", listaVeiculos=" + listaVeiculos + "]";
	}
	
	
	
}
