package lab;

import java.util.ArrayList;
import java.util.Date;

public class SeguroPF extends Seguro{
	private Veiculo veiculo;
	private ClientePF cliente;

	public SeguroPF(int iD, Date dataInicio, Date dataFim, Seguradora seguradora, ArrayList<Sinistro> listaSinistros,
			ArrayList<Condutor> listaCondutores, int valorMensal, Veiculo veiculo, ClientePF cliente) {
		super(iD, dataInicio, dataFim, seguradora, listaSinistros, listaCondutores, valorMensal);
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

	}

	@Override
	public void gerarSinistro() {

	}

}
