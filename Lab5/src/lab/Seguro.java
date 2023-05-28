package lab;

import java.util.Date;
import java.util.Random;
import java.util.ArrayList;

public abstract class Seguro {
	private final int ID;
	private Date dataInicio;
	private Date dataFim;
	private Seguradora seguradora;
	private ArrayList<Sinistro> listaSinistros;
	private ArrayList<Condutor> listaCondutores;
	private double valorMensal;
	
	public Seguro(Date dataInicio, Date dataFim, Seguradora seguradora) {
		this.ID = gerarIdRandom();
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.seguradora = seguradora;
		this.listaSinistros = new ArrayList<Sinistro>();
		this.listaCondutores = new ArrayList<Condutor>();
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Seguradora getSeguradora() {
		return seguradora;
	}

	public void setSeguradora(Seguradora seguradora) {
		this.seguradora = seguradora;
	}

	public ArrayList<Sinistro> getListaSinistros() {
		return listaSinistros;
	}

	public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
		this.listaSinistros = listaSinistros;
	}

	public ArrayList<Condutor> getListaCondutores() {
		return listaCondutores;
	}

	public void setListaCondutores(ArrayList<Condutor> listaCondutores) {
		this.listaCondutores = listaCondutores;
	}

	public double getValorMensal() {
		return valorMensal;
	}

	public void setValorMensal(double valorMensal) {
		this.valorMensal = valorMensal;
	}
	
	public int getID() {
		return ID;
	}

	private int gerarIdRandom() {
		Random random =  new Random();
		return Math.abs(random.nextInt());
	}
	
	public Condutor encontrarCondutor(String condutor) {
		for (Condutor condutorAtual : listaCondutores) {
			if (condutorAtual.getCPF().equals(condutor)) {
				return condutorAtual;
			}
		}
		return null;
	}
	
	public boolean desautorizarCondutor(String condutor) {
		Condutor newCondutor = encontrarCondutor(condutor);
		return this.listaCondutores.remove(newCondutor);
	}
	
	public boolean autorizarCondutor(Condutor condutor) {
		return listaCondutores.add(condutor);		
	}
	
	public abstract void calcularValor();
			
	public abstract void gerarSinistro(String condutor, Date data, String end);
	
	public String toString() {
		return "[ID=" + ID + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + ", seguradora=" + seguradora.getNome()
				+ ", listaSinistros=" + listaSinistros + ", listaCondutores=" + listaCondutores + ", valorMensal="
				+ valorMensal;
	}
	
}
