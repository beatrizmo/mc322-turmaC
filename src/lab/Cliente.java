package lab;

public class Cliente {
	private String nome;
	private String cpf;
	private String dataNascimento;
	private String endereco;
	private int idade;
	
	//Construtor
	public Cliente(String nome, String cpf, String dataNascimento, String endereco, int idade) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.idade = idade;
	}
	
	//Getters e setters
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}	
	
	public boolean validarCPF(String cpf) {
		String newCPF = this.cpf.replaceAll("-", "");
		newCPF = newCPF.replaceAll("\\.","");
		int n = newCPF.length();
		
		if (n != 11) { //verificar se tem 11 dígitos
			System.out.println("!");
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
	
	public String toString() {
		//testando a validação do cpf
		String c;
		if (validarCPF(getCpf())) {
			c = " CPF valido";
		}
		else {
			c = " CPF invalido";
		}
		String s = "*Dados do Cliente*\nNome: " + getNome()  + "\nData de Nascimento: " + getDataNascimento() + "\nEndereco: " + getEndereco() + "\nIdade: " + getIdade() + "\nCPF: " + getCpf();
		return s + c;
	}
}
