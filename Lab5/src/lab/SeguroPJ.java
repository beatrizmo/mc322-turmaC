package lab;

import java.util.Date;

public class SeguroPJ extends Seguro{
	private Frota frota;
	private ClientePJ cliente;
	public SeguroPJ(Date dataInicio, Date dataFim, Seguradora seguradora, Frota frota, ClientePJ cliente) {
		super(dataInicio, dataFim, seguradora);
		this.frota = frota;
		this.cliente = cliente;
	}
	public Frota getFrota() {
		return frota;
	}
	public void setFrota(Frota frota) {
		this.frota = frota;
	}
	public ClientePJ getCliente() {
		return cliente;
	}
	public void setCliente(ClientePJ cliente) {
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
	
	private int getQntSinistrosPorCondutor() {
		int soma = 0;
		for (Condutor condutor : getListaCondutores()) {
			soma += condutor.getSinistrosPorSeguradora(getSeguradora()).size();
		}
		return soma;
	}

	@Override
	public void calcularValor() {
		int ValorBase = (int) CalcSeguro.VALOR_BASE.valor();
		int qntFunc = this.cliente.getQntFunc();
		int qntVeiculos = this.cliente.getQntVeiculos();
		int AnosPosFundacao = this.cliente.calcularAnoPosFund();
		int qntSinistrosCondutor = getQntSinistrosPorCondutor();
		int qntSinistroCliente = getListaSinistros().size();
		int score = (ValorBase * (10 + (qntFunc)/10) * (1 + 1/(qntVeiculos + 2)) * (1 + 1/(AnosPosFundacao +2)) * (2 + qntSinistroCliente/10) * (5 + qntSinistrosCondutor/10));
		this.setValorMensal((int)score);
	}
	@Override
	public String toString() {
		return "SeguroPJ:" + super.toString() + "[frota=" + frota + ", cliente=" + cliente + "]";
	}	
}
