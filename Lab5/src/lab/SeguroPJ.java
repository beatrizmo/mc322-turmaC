package lab;

import java.util.ArrayList;
import java.util.Date;

public class SeguroPJ extends Seguro{
	private Frota frota;
	private ClientePJ cliente;
	public SeguroPJ(Date dataInicio, Date dataFim, Seguradora seguradora, Frota frota, ClientePJ cliente) {
		super(dataInicio, dataFim, seguradora);
		this.frota = frota;
		this.cliente = cliente;
		calcularValor();
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
	
	
	public boolean autorizarCondutor() {
		return true;
	}

	
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
		double ValorBase = CalcSeguro.VALOR_BASE.valor();
		double qntFunc = this.cliente.getQntFunc();
		double qntVeiculos = this.frota.getListaVeiculos().size();
		double AnosPosFundacao = this.cliente.calcularAnoPosFund();
		double qntSinistrosCondutor = getQntSinistrosPorCondutor();
		double qntSinistroCliente = this.getSeguradora().getSinistroPorCliente(this.cliente.getCNPJ()).size();
		//System.out.println(ValorBase + "," + qntFunc + "," + qntVeiculos + "," + AnosPosFundacao + "," + qntSinistrosCondutor + "," + qntSinistroCliente);
		double score = ( ValorBase * (10 + ( qntFunc ) /10) *
				  (1 + 1/( qntVeiculos +2) ) *
				  (1 + 1/( AnosPosFundacao +2) ) *
				  (2 + qntSinistroCliente /10) *
				  (5 + qntSinistrosCondutor /10));
		this.setValorMensal(score);
	}
	@Override
	public String toString() {
		return "SeguroPJ:" + super.toString() + ", [frota=" + frota + ", cliente=" + cliente + "]";
	}
	@Override
	public boolean gerarSinistro(String CNPJ, Date data, String end) {
		Condutor condutor = this.encontrarCondutor(CNPJ);
		Sinistro sin = new Sinistro(data, end, condutor, this);
		condutor.adicionarSinistro(sin);
		ArrayList <Sinistro> listaNovaSinistros = this.getListaSinistros();
		boolean gerado = listaNovaSinistros.add(sin);
		this.setListaSinistros(listaNovaSinistros);	
		this.calcularValor();
		return gerado;
	}	
}
