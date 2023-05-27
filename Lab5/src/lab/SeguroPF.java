package lab;


import java.util.Date;

public class SeguroPF extends Seguro{
	private Veiculo veiculo;
	private ClientePF cliente;

	public SeguroPF(Date dataInicio, Date dataFim, Seguradora seguradora, Veiculo veiculo, ClientePF cliente) {
		super(dataInicio, dataFim, seguradora);
		this.veiculo = veiculo;
		this.cliente = cliente;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public ClientePF getCliente() {
		return cliente;
	}

	public void setCliente(ClientePF cliente) {
		this.cliente = cliente;
	}

	@Override
	public boolean autorizarCondutor() {
		return true;
	}

	@Override
	public boolean desautorizarCondutor() {
		return false;
	}

	@Override
	public void calcularValor() {
		int ValorBase = (int) CalcSeguro.VALOR_BASE.valor();
		int idade = cliente.calcularIdade();
		double fatorIdade = 1;
		if(idade >= 18 && idade <= 30 ) {fatorIdade = CalcSeguro.FATOR_18_30.valor();}
		else if(idade >= 30 && idade <=60) {fatorIdade = CalcSeguro.FATOR_30_60.valor();}
		else if(idade >=60 && idade <= 90) {fatorIdade = CalcSeguro.FATOR_60_90.valor();}
		int qntVeiculos = cliente.getListaVeiculos().size();
		int qntSinistrosCliente = 0;
		int qntSinistrosCondutor = 0;
		double score = (ValorBase * fatorIdade * (1 + 1/(qntVeiculos + 2)) * (2 + qntSinistrosCliente/10) * (5 + qntSinistrosCondutor/10));
		this.setValorMensal((int)score);
	}

	@Override
	public String toString() {
		return "SeguroPF"+ super.toString() + "[veiculo=" + veiculo + ", cliente=" + cliente + "]";
	}

	
}
