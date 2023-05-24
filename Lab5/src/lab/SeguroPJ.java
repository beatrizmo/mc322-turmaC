package lab;

import java.util.ArrayList;
import java.util.Date;

public class SeguroPJ extends Seguro{
	private Frota frota;
	private ClientePJ ciente;
	public SeguroPJ(int iD, Date dataInicio, Date dataFim, Seguradora seguradora, ArrayList<Sinistro> listaSinistros,
			ArrayList<Condutor> listaCondutores, int valorMensal, Frota frota, ClientePJ ciente) {
		super(iD, dataInicio, dataFim, seguradora, listaSinistros, listaCondutores, valorMensal);
		this.frota = frota;
		this.ciente = ciente;
	}
	public Frota getFrota() {
		return frota;
	}
	public void setFrota(Frota frota) {
		this.frota = frota;
	}
	public ClientePJ getCiente() {
		return ciente;
	}
	public void setCiente(ClientePJ ciente) {
		this.ciente = ciente;
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

	}

	@Override
	public void gerarSinistro() {

	}
}
