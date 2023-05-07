package lab;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class lab {
	
	public static Seguradora selecionarSeguradora(ArrayList<Seguradora> listaSeguradoras) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite o numero da Seguradora que deseja fazer a operacao:");
		for (Seguradora seguradoraAtual : listaSeguradoras) {
			int index = 1 + listaSeguradoras.indexOf(seguradoraAtual);
			System.out.println(index + "-" +seguradoraAtual.getNome());
		}		
		String S = entrada.nextLine();
		int s = Integer.parseInt(S);		
		return listaSeguradoras.get(s-1);
	}
	
	public static ClientePF obterClientePF(ArrayList<ClientePF> listaClientesPF) {
		Scanner entrada = new Scanner(System.in);
		SimpleDateFormat dateF = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Digite o nome:");
		String nome = entrada.nextLine();
		while (!Validacao.validarNome(nome)) {
			System.out.println("Nome inválido!");
			nome = entrada.nextLine();
		}
		
		System.out.println("Digite o endereco:");
		String end = entrada.nextLine();
		
		System.out.println("Digite o CPF:");
		String CPF = entrada.nextLine();
		while (!Validacao.validarCPF(CPF)) {
			System.out.println("CPF inválido!");
			CPF = entrada.nextLine();
		}
		
		System.out.println("Genero F ou M?");
		String genero = entrada.nextLine();
		
		System.out.println("Digite a data da licenca:");
		String date = entrada.nextLine();					
		Date dataLicenca = new Date();
		try {
			dataLicenca = dateF.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Digite a educacao:");
		String educacao = entrada.nextLine();
		
		System.out.println("Digite a data de nascimento:");
		String date1 = entrada.nextLine();					
		Date dataNascimento = new Date();
		try {
			dataNascimento = dateF.parse(date1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Digite a classe economica:");
		String classeEconomica = entrada.nextLine();
		
		ClientePF newCliente = new ClientePF(nome,end,CPF,genero, dataLicenca, educacao, dataNascimento, classeEconomica);
		listaClientesPF.add(newCliente);
		return newCliente;
	}
	
	public static ClientePJ obterClientePJ(ArrayList<ClientePJ> listaClientesPJ) {
		Scanner entrada = new Scanner(System.in);
		SimpleDateFormat dateF = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Digite o nome:");
		String nome = entrada.nextLine();
								
		System.out.println("Digite o endereco:");
		String end = entrada.nextLine();
		
		System.out.println("Digite o CNPJ:");
		String CNPJ = entrada.nextLine();
		while (!Validacao.validarCNPJ(CNPJ)) {
			System.out.println("CNPJ inválido!");
			CNPJ = entrada.nextLine();
		}
		
		System.out.println("Digite a data de fundacao:");
		String date = entrada.nextLine();					
		Date dataFundacao = new Date();
		try {
			dataFundacao = dateF.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Digite a quantidade de funcionarios:");
		String q = entrada.nextLine();
		int qntFuncionarios = Integer.parseInt(q);		
		
		ClientePJ newCliente = new ClientePJ(nome,end,CNPJ,dataFundacao, qntFuncionarios);
		listaClientesPJ.add(newCliente);
		return newCliente;
	}	

	public static Cliente selecionarCliente(ArrayList<ClientePJ> listaClientesPJ, ArrayList<ClientePF> listaClientesPF, String op ) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("1-PF\n2-PJ");						
		String tipoCliente = entrada.nextLine();
		while (!tipoCliente.equals("1") && !tipoCliente.equals("2")) {
			System.out.println("Entrada inválida!");
			tipoCliente = entrada.nextLine();
		}
		if (tipoCliente.equals("1")) {
			Cliente c = selecionarClientePF(listaClientesPF, op);
			return c;
		}
		else {
			Cliente c = selecionarClientePJ(listaClientesPJ, op);
			return c;
		}
	}
	
	public static ClientePF selecionarClientePF(ArrayList<ClientePF> listaClientesPF, String op) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite o numero da Cliente que deseja " + op + ":");
		for (ClientePF clienteAtual : listaClientesPF) {
			int index = 1 + listaClientesPF.indexOf(clienteAtual);
			System.out.println(index + "-" +clienteAtual.getNome());
		}
		
		String S = entrada.nextLine();
		int s = Integer.parseInt(S);		
		return listaClientesPF.get(s-1);
	}

	public static ClientePJ selecionarClientePJ(ArrayList<ClientePJ> listaClientesPJ, String op) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite o numero da Cliente que deseja " + op + ":");
		for (ClientePJ clienteAtual : listaClientesPJ) {
			int index = 1 + listaClientesPJ.indexOf(clienteAtual);
			System.out.println(index + "-" +clienteAtual.getNome());
		}
		
		String S = entrada.nextLine();
		int s = Integer.parseInt(S);		
		return listaClientesPJ.get(s-1);
	}
	
	
	public static Veiculo obterVeiculo() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite a placa do veiculo:");
		String placa = entrada.nextLine();
		
		System.out.println("Digite a marca do veiculo:");
		String marca = entrada.nextLine();

		System.out.println("Digite a modelo do veiculo:");
		String modelo = entrada.nextLine();
		
		System.out.println("Digite o ano de fabricacao do veiculo:");
		String ano = entrada.nextLine();
		int anoFabricado = Integer.parseInt(ano);								
		
		Veiculo veiculo = new Veiculo(placa, marca, modelo, anoFabricado);
		return veiculo;
	}
	
	public static void main(String[] args) {
		ArrayList<Seguradora> listaSeguradoras = new ArrayList<Seguradora>();
		ArrayList<ClientePF> listaClientesPF = new ArrayList<ClientePF>();
		ArrayList<ClientePJ> listaClientesPJ = new ArrayList<ClientePJ>();
		
		//Criação da Seguradora
		Seguradora seg = new Seguradora("Seguro", "38421910", "v12345@dac.unicamp.br", "Germano Casellatto");
		listaSeguradoras.add(seg);
		System.out.println("Criação de " + seg.toString());
		System.out.println("-------######-------");
		
		Date today = new Date();
		Date then = new Date(117, 05, 21);
		
		//Criação do Cliente Físico e Jurídico		
		ClientePF pessoa = new ClientePF("LUIZ INACIO LULA DA SILVA", "Rua Londres", "070.680.938-68", 
				"masculino" , today, "Superior Completo", then, "Alta");
		listaClientesPF.add(pessoa);
		System.out.println("Criação de " + pessoa.toString());
		System.out.println("-------######-------");
		
		ClientePJ empresa = new ClientePJ("Cereais Ltda", "Bosque Agua Branca" , 
				"56.419.013/0001-54", then, 5);
		listaClientesPJ.add(empresa);
		System.out.println("Criação de " + empresa.toString());
		System.out.println("-------######-------");
		
		ClientePF pessoa2 = new ClientePF("JAIR MESSIAS BOLSONARO", "Marte", "453.178.287-91", 
				"masculino", today, "Superior Completo", then, "Alta");
		listaClientesPF.add(pessoa2);
		System.out.println("Criação de " + pessoa2.toString());
		System.out.println("-------######-------");
		
		//Validação do CPF e do CNPJ
		System.out.println("Validação de CPF:");
		if (Validacao.validarCPF(pessoa.getCPF())) {
			System.out.println("CPF válido!");
		}
		else {
			System.out.println("CPF inválido!");
		}
		System.out.println("-------######-------");
		
		System.out.println("Validação de CNPJ:");
		if (Validacao.validarCNPJ(empresa.getCNPJ())) {
			System.out.println("CNPJ válido!");
		}
		else {
			System.out.println("CNPJ inválido!");
		}
		System.out.println("-------######-------");
		
		//Cadastro dos clientes na seguradora
		seg.cadastrarCliente(pessoa);
		seg.cadastrarCliente(empresa);
		seg.cadastrarCliente(pessoa2);
		//System.out.println(seg.toString());
		System.out.println("Pessoas Físicas cadastradas na Seguradora:");
		seg.listarClientes("CPF");
		System.out.println("-------######-------");
		System.out.println("Pessoas Jurídicas cadastradas na Seguradora:");
		seg.listarClientes("CNPJ");
		System.out.println("-------######-------");
		
		//Adicionando veiculo para cada cliente
		Veiculo carro = new Veiculo("HFH2230", "Ford", "Ka", 2017);
		Veiculo moto = new Veiculo("PUT5540", "Yamaha", "Lander 250", 2020);
		Veiculo patinete = new Veiculo("AAS5443", "Honda", "Fit", 2001);
		System.out.println("Criação de veículos:");
		System.out.println(carro.toString());
		System.out.println(moto.toString());
		System.out.println(patinete.toString());
		System.out.println("-------######-------");
		pessoa.adicionarVeiculo(carro);
		empresa.adicionarVeiculo(moto);
		pessoa2.adicionarVeiculo(patinete);
		System.out.println("Adição de Veículos:");
		System.out.println(pessoa.toString());
		System.out.println(empresa.toString());
		System.out.println(pessoa2.toString());
		System.out.println("-------######-------");
		
		//Criação de um Sinistro e utilização do seu metodo toString()
		Sinistro sinistro = new Sinistro("20/10/1999", "lugar nenhum", pessoa2, patinete, seg);
		System.out.println("Teste do metodo toString do Sinistro:");
		System.out.println(sinistro.toString());
		System.out.println("-------######-------");
		
		//Gerando Sinistro
		System.out.println("Lista de Sinistros:");
		seg.gerarSinistro("20/04/2023", empresa, moto, seg);
		seg.gerarSinistro("19/07/2022", pessoa, carro, seg);
		seg.gerarSinistro("18/09/2020", pessoa, carro, seg);	
		seg.gerarSinistro("30/01/2018", pessoa2, patinete, seg);
		seg.listarSinistros();
		System.out.println("-------######-------");
		
		//Visualizar Sinistro
		System.out.println("Visualizar Sinistros:");
		seg.visualisarSinistro("070.680.938-68");
		seg.visualisarSinistro("56.419.013/0001-54");
		System.out.println("-------######-------");
		
		Scanner entrada = new Scanner(System.in);
		MenuOperacoes estado = MenuOperacoes.MENUINICIAL;
		boolean isRunning = true;
		//System.out.println(estado.MenuPrincipal());
		while (isRunning) {
			//System.out.println(estado.getDescricao());
			System.out.println(estado.getMenuOpcoes());
			
			String es = entrada.nextLine();
			int escolha = Integer.parseInt(es);
			
			Scanner entrada1 = new Scanner(System.in);
			
			if(estado == MenuOperacoes.CADASTROS) {					
				switch(escolha) {
					case(1):
						//CADASTRAR CLIENTE
						Seguradora seguradoraAtual = selecionarSeguradora(listaSeguradoras);
						System.out.println("Cliente a ser cadastrado é:");
						System.out.println("1-PF\n2-PJ");
						
						String tipo = entrada1.nextLine();
						int tipoCliente = Integer.parseInt(tipo);
						
						if (tipoCliente == 1) {
							Cliente newCliente = obterClientePF(listaClientesPF);
							seguradoraAtual.cadastrarCliente(newCliente);
							System.out.println("Cliente PF cadastrado!");
							
						}
						else if (tipoCliente == 2) {
							Cliente newCliente = obterClientePJ(listaClientesPJ);
							seguradoraAtual.cadastrarCliente(newCliente);
							System.out.println("Cliente PJ cadastrado!");
						}
						break;
					case(2):
						//CADASTRAR VEICULO
						Veiculo veiculo = obterVeiculo();
						
						System.out.println("Digite o CPF/CNPJ do cliente a qual o veiculo sera cadastrado:");
						String id = entrada1.nextLine();
						
						while (!Validacao.validarCNPJ(id) && !Validacao.validarCPF(id)) {
							System.out.println("CPF/CNPJ inválido!");
							id = entrada1.nextLine();
						}
						if (Validacao.validarCPF(id)) {
							for (ClientePF clienteAtual : listaClientesPF) {
								if(clienteAtual.getCPF().equals(id)) {
									clienteAtual.adicionarVeiculo(veiculo);
									System.out.println("Veiculo adicionado!");
									break;
								}
							}
						}
						else {
							for (ClientePJ clienteAtual : listaClientesPJ) {
								if(clienteAtual.getCNPJ().equals(id)) {
									clienteAtual.adicionarVeiculo(veiculo);
									System.out.println("Veiculo adicionado!");
									break;
								}
							}
						}	
						break;
					case(3):
						//CADASTRAR SEGURADORA
						System.out.println("Digite o nome da Seguradora:");
						String nome = entrada1.nextLine();
						
						System.out.println("Digite o telefone:");
						String tel = entrada1.nextLine();
						
						System.out.println("Digite o email:");
						String email = entrada1.nextLine();
						
						System.out.println("Digite o endereco:");
						String end = entrada1.nextLine();
											
						Seguradora novaSeg = new Seguradora(nome, tel, email, end);
						listaSeguradoras.add(novaSeg);
						System.out.println("Seguradora cadastrada!");
						break;
					case(4):
						estado = MenuOperacoes.MENUINICIAL;
						break;	
				}	
			}
			
			else if(estado == MenuOperacoes.LISTAR) {			
				switch(escolha) {
					case(1):
						//LISTAR CLIENTES POR SEGURADORA
						Seguradora seguradoraAtual = selecionarSeguradora(listaSeguradoras);						
						seguradoraAtual.listarClientes("CPF");
						seguradoraAtual.listarClientes("CNPJ");		
						break;
						
					case(2):
						//LISTAR SINISTRO POR SEG						
						Seguradora seguradoraAtual1 = selecionarSeguradora(listaSeguradoras);
						seguradoraAtual1.listarSinistros();		
						break;
					case(3):
						//LISTAR SINISTRO POR CLIENTE
						System.out.println("Digite o CPF/CNPJ do cliente a qual se deseja listar os sinistros:");
						String id = entrada1.nextLine();
						while (!Validacao.validarCNPJ(id) && !Validacao.validarCPF(id)) {
							System.out.println("CPF/CNPJ inválido!");
							id = entrada1.nextLine();
						}						
						for (Seguradora seguradoraAtual2 : listaSeguradoras) {
							System.out.println("Sinistros da Seguradora "+seguradoraAtual2.getNome()+":");
							seguradoraAtual2.visualisarSinistro(id);
						}
						break;
					case(4):
						//LISTAR VEICULO POR CLIENTE
						System.out.println("Digite o CPF/CNPJ do cliente a qual os veiculos serao listados:");
						String id1 = entrada1.nextLine();
						
						while (!Validacao.validarCNPJ(id1) && !Validacao.validarCPF(id1)) {
							System.out.println("CPF/CNPJ inválido!");
							id1 = entrada1.nextLine();
						}
						if (Validacao.validarCPF(id1)) {
							for (ClientePF clienteAtual : listaClientesPF) {
								if(clienteAtual.getCPF().equals(id1)) {
									System.out.println(clienteAtual.getListaVeiculos());
									break;
								}
							}
						}
						else {
							for (ClientePJ clienteAtual : listaClientesPJ) {
								if(clienteAtual.getCNPJ().equals(id1)) {
									System.out.println(clienteAtual.getListaVeiculos());
									break;
								}
							}
						}	
						break;
					case(5):
						//LISTAR VEICULO POR SEGURADORA
						Seguradora seguradoraAtual2 = selecionarSeguradora(listaSeguradoras);
						seguradoraAtual2.listarVeiculos();	
						break;
					case(6):
						estado = MenuOperacoes.MENUINICIAL;
						break;
				}				
			}
			
			else if(estado == MenuOperacoes.EXCLUIR) {				
				switch(escolha) {
					case(1):
						//EXCLUIR CLIENTE					
						Seguradora seguradoraAtual = selecionarSeguradora(listaSeguradoras);						
						System.out.println("Escreva CPF/CNPJ do cliente a ser removido:");					
						String ID = entrada1.nextLine();						
						while (!Validacao.validarCNPJ(ID) && !Validacao.validarCPF(ID)) {
							System.out.println("CPF/CNPJ inválido!");
							ID = entrada1.nextLine();
						}
						seguradoraAtual.removerCliente(ID);
						break;
					case(2):
						//EXCLUIR VEICULO DA SEGURADORA					
						Seguradora seguradoraAtual1 = selecionarSeguradora(listaSeguradoras);						
						System.out.println("Escreva a placa do veículo a ser removido:");
						String placa = entrada1.nextLine();						
						seguradoraAtual1.removerVeiculoSeguradora(placa);
						break;
					case(3):
						//EXCLUIR SINISTRO					
						Seguradora seguradoraAtual2 = selecionarSeguradora(listaSeguradoras);						
						System.out.println("Escreva CPF/CNPJ do cliente cujo sinistro deve ser removido:");
						String ID1 = entrada1.nextLine();
						seguradoraAtual2.removerSinistro(ID1);
						break;
					case(4):
						estado = MenuOperacoes.MENUINICIAL;
						break;	
				}				
			}			
			else if(estado == MenuOperacoes.MENUINICIAL) {
						
				switch(escolha) {
					case(1):
						estado = MenuOperacoes.CADASTROS;
						break;
					case(2):
						estado = MenuOperacoes.LISTAR;
						break;
					case(3):
						estado = MenuOperacoes.EXCLUIR;
						break;
					case(4):
						//GERAR SINISTRO	
						System.out.println("Digite a data");						
						String data = entrada1.nextLine();
						
						Seguradora seguradoraAtual = selecionarSeguradora(listaSeguradoras);
						Veiculo veiculo = obterVeiculo();
						
						System.out.println("Cliente a gerar sinistro é:");
						Cliente c = selecionarCliente(listaClientesPJ, listaClientesPF, "gerar sinistro");
						seguradoraAtual.gerarSinistro(data, c, veiculo, seguradoraAtual);		
						System.out.println("Sinistro gerado");			
						break;
					case(5):
						//TRANSFERIR SEGURO
						Seguradora seguradoraAtual1 = selecionarSeguradora(listaSeguradoras);
						System.out.println("O cliente que irá transferir o seguro é:");	
						Cliente fonte = selecionarCliente(listaClientesPJ, listaClientesPF, "transferir o seguro");						
						
						System.out.println("O cliente que receberá o seguro é:");
						Cliente alvo = selecionarCliente(listaClientesPJ, listaClientesPF, "receber o seguro");
						seguradoraAtual1.transferenciaSeguro(fonte, alvo);				
						break;
					case(6):
						//CALCULAR RECEITA
						Seguradora seguradoraAtual2 = selecionarSeguradora(listaSeguradoras);
						System.out.println(seguradoraAtual2.calcularReceita());
						break;
					case(0):
						isRunning = false;
						System.out.println("Saindo!");
						break;
					
				}
				
				
			}
			
		}
		
		entrada.close();
	}
	
}
