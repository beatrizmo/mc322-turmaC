package lab;

import java.util.ArrayList;
import java.util.Date;

public class ClientePF extends Cliente{
	private final String CPF;
	private String genero;
	private String educacao;	
	private Date dataNascimento;
	private ArrayList<Veiculo> listaVeiculos;

	public ClientePF(String nome, String telefone, String endereco, String email, String CPF, String genero,  String educacao,
			Date dataNascimento) {
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
			return CPF;
		}
		return "CPF inválido";
	}	

	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(Date dataNascimento) {
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
	    long diferencaMillis = new Date().getTime() - this.dataNascimento.getTime();
	    long diferencaAnos = (long) (diferencaMillis / 1000 / 60 / 60 / 24 / 365.25);
	    return (int) diferencaAnos;
	}

	
	@Override
	public String toString() {
		return "ClientePF" + super.toString() + " CPF=" + CPF + ", genero=" + genero + ", educacao=" + educacao + ", dataNascimento="
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
