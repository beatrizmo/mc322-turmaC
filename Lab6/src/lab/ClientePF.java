package lab;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class ClientePF extends Cliente{
	private final String CPF;
	private String genero;
	private String educacao;	
	private LocalDate dataNascimento;
	private ArrayList<Veiculo> listaVeiculos;

	public ClientePF(String nome, String telefone, String endereco, String email, String CPF, String genero,  String educacao,
			LocalDate dataNascimento) {
		super(nome, telefone, endereco, email);	
		this.CPF = gerarCPF(CPF);
		this.genero = genero;
		this.educacao = educacao;
		this.dataNascimento = dataNascimento;
		this.listaVeiculos = new ArrayList<Veiculo>();
			
	}

	public String getCPF() {
		return CPF;
	}
	
	private String gerarCPF(String CPF) {
		if (Validacao.validarCPF(CPF)) {
			CPF = CPF.replaceAll("[^0-9]", "");
			return CPF;
		}
		return "CPF inválido";
	}	

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEducacao() {
		return educacao;
	}

	public void setEducacao(String educacao) {
		this.educacao = educacao;
	}
	
	public ArrayList<Veiculo> getListaVeiculos() {
		return listaVeiculos;
	}
	
	public int calcularIdade() {
		LocalDate dataAtual = LocalDate.now();
		Period periodo = Period.between(this.dataNascimento, dataAtual);
	    int idade = periodo.getYears();
	    return (int) idade;
	}

	
	@Override
	public String toString() {
		return "ClientePF" + super.toString() + ", CPF=" + CPF + ", genero=" + genero + ", educacao=" + educacao + ", dataNascimento="
				+ dataNascimento + ", listaVeiculos=" + listaVeiculos + "]";
	}
	
	public boolean cadastrarVeiculo(Veiculo veiculo) {
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
	}
}
