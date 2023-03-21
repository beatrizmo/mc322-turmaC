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
		String newCPF = this.cpf.replaceAll(".","");
		newCPF = this.cpf.replaceAll("-","");
		int n = newCPF.length();
		
		if (n != 11) { //verificar se tem 11 dígitos
			return false;
		}
		
		int iguais = 0; //verificar se todos os dígitos são iguais
		for (int i = 1; i < n; i++) {
			if (newCPF.charAt(0) != newCPF.charAt(i)) {
					iguais = 1;			
			}
			if (iguais == 1) {
				break;
			}
		}
		if (iguais == 0) {
			return false;
		}
		
		//calcular os dígitos verificadores
		
		//verificar se os dígitos calculados são iguais aos informados
		return true;
	}
}
