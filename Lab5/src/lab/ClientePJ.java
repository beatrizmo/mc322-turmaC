package lab;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ClientePJ extends Cliente{
	private final String CNPJ;
	private int qntFunc;
	private Date dataFundacao;
	private ArrayList<Frota> listaFrota;
	
	public ClientePJ(String nome, String telefone, String endereco, String email, String CNPJ, int qntFunc, Date dataFundacao) {
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
	
	public boolean cadastrarFrota() {		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite o code da Frota que sera cadastrada:");
		String code = entrada.nextLine();
		Frota newFrota = new Frota(code);
		System.out.println("Quantos Veiculos essa frota possui?");
		int qnt = entrada.nextInt();
		for (int i=0;i<qnt;i++) {
			this.adicionarVeiculoFrota(newFrota);		
		}
		entrada.close();
		return this.listaFrota.add(newFrota);
	}
	
	private boolean adicionarVeiculoFrota(Frota frota) {
		Scanner entrada = new Scanner(System.in);
		String qa = entrada.nextLine();
		int qntAdicionada = Integer.parseInt(qa);
		for (int i=0; i<qntAdicionada; i++) {
			frota.addVeiculo();
		}
		entrada.close();
		return true;
	}
	
	private boolean removerVeiculoFrota(Frota frota) {
		Scanner entrada = new Scanner(System.in);
		String qr = entrada.nextLine();
		int qntRemovida = Integer.parseInt(qr);
		for (int i=0; i<qntRemovida; i++) {
			frota.removeVeiculo();
		}
		entrada.close();
		return true;
	}
	
	public boolean atualizarFrota() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite o code da Frota que sera atualizada:");
		String code = entrada.nextLine();
		for (Frota frotaAtual : listaFrota) {
			if (frotaAtual.getCode().equals(code)) {
				entrada.close();
				return atualizarFrota(frotaAtual);
			}
		}
		entrada.close();
		return false;
	}			

	
	private boolean atualizarFrota(Frota frota) {
		System.out.println("1-Adicionar Veiculos\n 2-Remover Veiculos\n 3-Remover Frota");
		Scanner entrada = new Scanner(System.in);
		String es = entrada.nextLine();
		int escolha = Integer.parseInt(es);
		switch (escolha) {
			case(1): //adicionar veiculo a frota 
				System.out.println("Quantos veiculos deseja adicionar?");
				entrada.close();
				return adicionarVeiculoFrota(frota);			
			case(2): //remover veiculo da frota
				System.out.println("Quantos veiculos deseja remover?");
				entrada.close();
				return removerVeiculoFrota(frota);
			case(3): //remover frota
				entrada.close();
				return this.listaFrota.remove(frota);
		}		
		entrada.close();
		return false;		
	}
	
	public ArrayList<Veiculo> getVeiculosPorFrota() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite o code da Frota:");
		String code = entrada.nextLine();		
		entrada.close();
		return getVeiculosPorFrota(code);
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
	
	public int getQntVeiculos() {
		int soma = 0;
		for (Frota frota : listaFrota) {
			soma += this.getVeiculosPorFrota(frota.getCode()).size();
		}
		return soma;
	}
	
	public int calcularAnoPosFund() {
	    long diferencaMillis = new Date().getTime() - this.dataFundacao.getTime();
	    long diferencaAnos = (long) (diferencaMillis / 1000 / 60 / 60 / 24 / 365.25);
	    return (int) diferencaAnos;
	}
	
	@Override
	public String toString() {
		return "ClientePJ [CNPJ=" + CNPJ + ", dataFundacao=" + dataFundacao + ", listaFrota=" + listaFrota + "]";
	}	
}
