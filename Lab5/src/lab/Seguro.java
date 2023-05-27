package lab;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public abstract class Seguro {
	private final int ID;
	private Date dataInicio;
	private Date dataFim;
	private Seguradora seguradora;
	private ArrayList<Sinistro> listaSinistros;
	private ArrayList<Condutor> listaCondutores;
	private int valorMensal;
	
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

	public int getValorMensal() {
		return valorMensal;
	}

	public void setValorMensal(int valorMensal) {
		this.valorMensal = valorMensal;
	}
	
	private int gerarIdRandom() {
		Random random =  new Random();
		return Math.abs(random.nextInt());
	}
	
	protected Condutor selecionarCondutor() {
		Scanner entrada = new Scanner(System.in);
		for (Condutor condutorAtual : listaCondutores) {
			int index = 1 + listaCondutores.indexOf(condutorAtual);
			System.out.println(index + "-" + condutorAtual.getNome());
		}		
		String S = entrada.nextLine();
		int s = Integer.parseInt(S);
		entrada.close();
		return listaCondutores.get(s-1);
	}
	
	protected Condutor obterCondutor() {
		Scanner entrada = new Scanner(System.in);
		SimpleDateFormat dateF = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Digite o CPF:");
		String CPF = entrada.nextLine();
		while (!Validacao.validarCPF(CPF)) {
			System.out.println("CPF inválido!");
			CPF = entrada.nextLine();
		}
		System.out.println("Digite o nome:");
		String nome = entrada.nextLine();
		while (!Validacao.validarNome(nome)) {
			System.out.println("Nome inválido!");
			nome = entrada.nextLine();
		}
		System.out.println("Digite o telefone:");
		String tel = entrada.nextLine();		
		System.out.println("Digite o endereco:");
		String end = entrada.nextLine();
		System.out.println("Digite o email:");
		String email = entrada.nextLine();
		System.out.println("Digite a data de nascimento:");
		String date = entrada.nextLine();					
		Date dataNasc = new Date();
		try {
			dataNasc = dateF.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Condutor condutor = new Condutor(CPF,nome,tel,end,email,dataNasc);
		entrada.close();
		return condutor;
	}
	
	public boolean desautorizarCondutor() {
		System.out.println("Digite o numero do Condutor que deseja desautorizar:");
		return this.listaCondutores.remove(this.selecionarCondutor());
	}
	
	public boolean autorizarCondutor() {
		return false;		
	}
	
	public void calcularValor() {};
		
	public boolean gerarSinistro() {
		Scanner entrada = new Scanner(System.in);
		SimpleDateFormat dateF = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Digite a data");						
		String date = entrada.nextLine();					
		Date data = new Date();
		try {
			data = dateF.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Digite o endereco");						
		String end = entrada.nextLine();
		System.out.println("Digite o numero do Condutor que deseja gerar sinistro:");
		Condutor condutor = this.selecionarCondutor();
		Sinistro sin = new Sinistro(data, end, condutor, this);
		entrada.close();
		condutor.adicionarSinistro(sin);
		return this.listaSinistros.add(sin);
	}

	public String toString() {
		return "[ID=" + ID + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + ", seguradora=" + seguradora
				+ ", listaSinistros=" + listaSinistros + ", listaCondutores=" + listaCondutores + ", valorMensal="
				+ valorMensal;
	}
	
}
