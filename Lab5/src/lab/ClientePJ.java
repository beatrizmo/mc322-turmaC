package lab;

import java.util.Date;

public class ClientePJ extends Cliente{
	final private String CNPJ;
	private Date dataFundacao;
	private int qtdeFuncionarios;
	
	public ClientePJ(String nome, String endereco, String CNPJ, Date dataFundacao, int qtdeFuncionarios) {
		super(nome, endereco);
		this.CNPJ = gerarCNPJ(CNPJ);
		this.dataFundacao = dataFundacao;
		this.qtdeFuncionarios = qtdeFuncionarios;
	}
	

	public int getQtdeFuncionarios() {
		return qtdeFuncionarios;
	}

	public void setQtdeFuncionarios(int qtdeFuncionarios) {
		this.qtdeFuncionarios = qtdeFuncionarios;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public String gerarCNPJ(String CNPJ) {
		if (Validacao.validarCNPJ(CNPJ)) {
			return CNPJ;
		}
		return "CNPJ invalido";
	}

	public Date getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	
	@Override
	public double calculaScore() {
		return CalcSeguro.VALOR_BASE.valor() * (1 + (this.qtdeFuncionarios)/100) * this.getListaVeiculos().size();
	}
	
	@Override
	public String toString() {
		return "ClientePJ [CNPJ=" + CNPJ + ", dataFundacao=" + dataFundacao + super.toString();
	}

	
}
