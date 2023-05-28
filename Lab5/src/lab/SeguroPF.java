package lab;


import java.util.ArrayList;
import java.util.Date;

public class SeguroPF extends Seguro{
	private Veiculo veiculo;
	private ClientePF cliente;

	public SeguroPF(Date dataInicio, Date dataFim, Seguradora seguradora, Veiculo veiculo, ClientePF cliente) {
		super(dataInicio, dataFim, seguradora);
		this.veiculo = veiculo;
		this.cliente = cliente;
		calcularValor();
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

	private int getQntSinistrosPorCondutor() {
		int soma = 0;
		for (Condutor condutor : getListaCondutores()) {
			soma += condutor.getSinistrosPorSeguradora(getSeguradora()).size();
		}
		return soma;
	}

	@Override
	public void calcularValor() {
		double ValorBase = (int) CalcSeguro.VALOR_BASE.valor();
		double idade = cliente.calcularIdade();
		double fatorIdade = 1;
		if(idade >= 18 && idade <= 30 ) {fatorIdade = CalcSeguro.FATOR_18_30.valor();}
		else if(idade >= 30 && idade <=60) {fatorIdade = CalcSeguro.FATOR_30_60.valor();}
		else if(idade >=60 && idade <= 90) {fatorIdade = CalcSeguro.FATOR_60_90.valor();}
		double qntVeiculos = this.getSeguradora().getVeiculosPorCliente(this.getCliente().getCPF()).size(); //qnt de veiculos q o cliente tem assegurados na seguradora
		double qntSinistrosCliente = this.getSeguradora().getSinistroPorCliente(this.cliente.getCPF()).size(); //qnt de sinistros q o cliente tem na seguradora
		double qntSinistrosCondutor = getQntSinistrosPorCondutor(); //qnt de sinistros que o condutor tem na seguradora
		double score =  ( ValorBase * fatorIdade * (1 + 1/( qntVeiculos +2) ) *
				(2 + qntSinistrosCliente /10) *
				(5 + qntSinistrosCondutor /10) );
		this.setValorMensal(score);
	}


	@Override
	public String toString() {
		return "SeguroPF"+ super.toString() + "[veiculo=" + veiculo + ", cliente=" + cliente + "]";
	}

	@Override
	public void gerarSinistro(String CPF, Date data, String end) {
		Condutor condutor = this.encontrarCondutor(CPF);
		Sinistro sin = new Sinistro(data, end, condutor, this);
		condutor.adicionarSinistro(sin);
		ArrayList <Sinistro> listaNovaSinistros = this.getListaSinistros();
		listaNovaSinistros.add(sin);
		this.setListaSinistros(listaNovaSinistros);
		this.calcularValor();
	}



}
