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
		if (this.validarCPF(CPF)) {
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
	
	public boolean validarCPF(String CPF) {
		String newCPF = CPF.replaceAll("-", "");
		newCPF = newCPF.replaceAll("\\.","");
		int n = newCPF.length();
		
		if (n != 11) { //verificar se tem 11 dígitos
			return false;
		}
		
		int iguais = 0; //verificar se todos os dígitos são iguais
		for (int i = 1; i < n; i++) {
			if (newCPF.charAt(0) != newCPF.charAt(i)) {
					iguais = 1;	
					break;
			}
		}
		if (iguais == 0) {
			System.out.println("@");
			return false;
		}
		
		//calcular os dígitos verificadores
		int soma = 0; 
		for (int i=0; i < 9; i++) { //primeiro dígito
			soma += Character.getNumericValue(newCPF.charAt(i)) * (10-i);
		}	
		int primeiroVerificador = 11 - (soma % 11);
		if (primeiroVerificador == 10 || primeiroVerificador == 11) {
			primeiroVerificador = 0;
		}
		soma = 0;
		for (int i=0; i < 10; i++) { //segundo dígito
			soma += Character.getNumericValue(newCPF.charAt(i)) * (11-i);
		}
		int segundoVerificador = 11 - (soma % 11);
		if (segundoVerificador == 10 || segundoVerificador == 11) {
			segundoVerificador = 0;
		}
				
		//verificar se os dígitos calculados são iguais aos informados
		if (primeiroVerificador != Character.getNumericValue(newCPF.charAt(9))) {
			System.out.println("Primeiro digito verificador não é valido");
			return false;
		}
		if (segundoVerificador != Character.getNumericValue(newCPF.charAt(10))) {
			System.out.println("Segundo digito verificador não é valido");
			return false;
		}
		
		return true;
	}

	@Override
	public String toString() {
		return "ClientePF [CPF=" + CPF + ", genero=" + genero + ", dataLicenca=" + dataLicenca + ", educacao="
				+ educacao + ", dataNascimento=" + dataNascimento + ", classeEconomica=" + classeEconomica + super.toString();
	}
	
	
	
}
