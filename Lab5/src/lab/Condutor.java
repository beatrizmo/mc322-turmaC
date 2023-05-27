package lab;

import java.util.ArrayList;
import java.util.Date;

public class Condutor {
	private String CPF;
	private String nome;
	private String telefone;
	private String endereco;
	private String email;
	private Date dataNasc;
	private ArrayList<Sinistro> listaSinistros;
	
	public Condutor(String cPF, String nome, String telefone, String endereco, String email, Date dataNasc) {
		CPF = cPF;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.email = email;
		this.dataNasc = dataNasc;
		this.listaSinistros = new ArrayList<Sinistro>();
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public ArrayList<Sinistro> getListaSinistros() {
		return listaSinistros;
	}
	
	public boolean adicionarSinistro(Sinistro sinistro) {
		return this.listaSinistros.add(sinistro);
	}

	public ArrayList<Sinistro> getSinistrosPorSeguradora(Seguradora seguradora) {
		ArrayList<Sinistro> sinistrosSeguradora = new ArrayList<Sinistro>();
		for (Sinistro sinistro : listaSinistros) {
			if (sinistro.getSeguro().getSeguradora().equals(seguradora)) {
				sinistrosSeguradora.add(sinistro);
			}
		}
		return sinistrosSeguradora;
	}
	
	
	public String toString() {
		return "Condutor [CPF=" + CPF + ", nome=" + nome + ", telefone=" + telefone + ", endereco=" + endereco
				+ ", email=" + email + ", dataNasc=" + dataNasc + ", listaSinistros=" + listaSinistros + "]";
	}
	
	
	
	
	
}
