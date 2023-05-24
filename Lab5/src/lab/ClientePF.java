package lab;

import java.util.Date;

public class ClientePF extends Cliente{
	final private String CPF;
	private String genero;
	private Date dataLicenca;
	private String educacao;
	private Date dataNascimento;
	private String classeEconomica;

	public ClientePF(String nome, String endereco, String CPF, String genero, Date dataLicenca, String educacao,
			Date dataNascimento, String classeEconomica) {
		super(nome, endereco);	
		this.CPF = gerarCPF(CPF);
		this.genero = genero;
		this.dataLicenca = dataLicenca;
		this.educacao = educacao;
		this.dataNascimento = dataNascimento;
		this.classeEconomica = classeEconomica;
			
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

	public Date getDataLicenca() {
		return dataLicenca;
	}

	public void setDataLicenca(Date dataLicenca) {
		this.dataLicenca = dataLicenca;
	}

	public String getEducacao() {
		return educacao;
	}

	public void setEducacao(String educacao) {
		this.educacao = educacao;
	}

	public String getClasseEconomica() {
		return classeEconomica;
	}

	public void setClasseEconomica(String classeEconomica) {
		this.classeEconomica = classeEconomica;
	}
	
	public int calcularIdade() {
	    long diferencaMillis = new Date().getTime() - this.dataNascimento.getTime();
	    long diferencaAnos = (long) (diferencaMillis / 1000 / 60 / 60 / 24 / 365.25);
	    return (int) diferencaAnos;
	}
	
	@Override
	public double calculaScore() {
		int idade = calcularIdade();
		double fatorIdade = 1;
		if(idade >= 18 && idade <= 30 ) {fatorIdade = CalcSeguro.FATOR_18_30.valor();}
		else if(idade >= 30 && idade <=60) {fatorIdade = CalcSeguro.FATOR_30_60.valor();}
		else if(idade >=60 && idade <= 90) {fatorIdade = CalcSeguro.FATOR_60_90.valor();}
		return CalcSeguro.VALOR_BASE.valor() *  fatorIdade * this.getListaVeiculos().size();
	}

	@Override
	public String toString() {
		return "ClientePF [CPF=" + CPF + ", genero=" + genero + ", dataLicenca=" + dataLicenca + ", educacao="
				+ educacao + ", dataNascimento=" + dataNascimento + ", classeEconomica=" + classeEconomica + super.toString();
	}
	
	
	
}
