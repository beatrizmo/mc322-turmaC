package lab;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class ClientePJ extends Cliente{
	private final String CNPJ;
	private int qntFunc;
	private LocalDate dataFundacao;
	private ArrayList<Frota> listaFrota;
	
	public ClientePJ(String nome, String telefone, String endereco, String email, String CNPJ, int qntFunc, LocalDate dataFundacao) {
		super(nome,telefone, endereco,email);
		this.CNPJ = gerarCNPJ(CNPJ);
		this.qntFunc = qntFunc;
		this.dataFundacao = dataFundacao;
		this.listaFrota = new ArrayList<Frota>();
	}

	public int getQntFunc() {
		return qntFunc;
	}

	public void setQntFunc(int qntFunc) {
		this.qntFunc = qntFunc;
	}

	public ArrayList<Frota> getListaFrota() {
		return listaFrota;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	private String gerarCNPJ(String CNPJ) {
		if (Validacao.validarCNPJ(CNPJ)) {
			CNPJ = CNPJ.replaceAll("[^0-9]", "");
			return CNPJ;
		}
		return "CNPJ invalido";
	}

	public LocalDate getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(LocalDate dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	
	public boolean cadastrarFrota(Frota frota) {
		return this.listaFrota.add(frota);
	}
	
	public boolean atualizarFrota(String code, int escolha) {
		Frota frota = null;
		for (Frota frotaAtual : listaFrota) {
			if (frotaAtual.getCode() == code) {
				frota = frotaAtual;
			}
		} //selecionando a frota que a operação sera feita
		if (escolha == 3) { //remover a frota
			return listaFrota.remove(frota);
		}
		return false;
	}	
	
	public boolean atualizarFrota(String code, int escolha, ArrayList<Veiculo> veiculos) { //passa a lista de veiculos a ser adicionada/removida
		Frota frota = null;
		for (Frota frotaAtual : listaFrota) {
			if (frotaAtual.getCode() == code) {
				frota = frotaAtual;
			}
		} //selecionando a frota que a operação sera feita
		switch (escolha) {
			case(1): //adicionar veiculo a frota 
				for (Veiculo veiculo : veiculos) {
					frota.addVeiculo(veiculo);
				}
				return true;
			case(2): //remover veiculo da frota
				for (Veiculo veiculo : veiculos) {
					frota.removeVeiculo(veiculo);
				}
				return true;
		}
		return false;		
	}
	
	public ArrayList<Veiculo> getVeiculosPorFrota(String code) {
		ArrayList<Veiculo> veiculosFrota = new ArrayList<Veiculo>();
		for (Frota frota : this.listaFrota) {
			if (frota.getCode().equals(code)) {
				veiculosFrota = frota.getListaVeiculos();
			}
		}
		return veiculosFrota;
	}
	
	public int calcularAnoPosFund() {
		LocalDate dataAtual = LocalDate.now();
		Period periodo = Period.between(this.dataFundacao, dataAtual);
	    int idade = periodo.getYears();
	    return (int) idade;
	}
	
	@Override
	public String toString() {
		return "ClientePJ" + super.toString() + " CNPJ=" + CNPJ + ", dataFundacao=" + dataFundacao + ", listaFrota=" + listaFrota + "]";
	}	
}
