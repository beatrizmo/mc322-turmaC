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
		System.out.println("Digite o telefone:");
		String tel = entrada.nextLine();
		System.out.println("Digite o endereco:");
		String end = entrada.nextLine();
		System.out.println("Digite o email:");
		String email = entrada.nextLine();
		System.out.println("Digite o CPF:");
		String CPF = entrada.nextLine();
		while (!Validacao.validarCPF(CPF)) {
			System.out.println("CPF inválido!");
			CPF = entrada.nextLine();
		}
		CPF = CPF.replaceAll("[^0-9]", "");
		System.out.println("Genero?");
		String genero = entrada.nextLine();
		System.out.println("Digite a educacao:");
		String educacao = entrada.nextLine();
		System.out.println("Digite a data de nascimento [dd/MM/yyyy]:");
		String date = entrada.nextLine();					
		Date dataNascimento = new Date();
		try {
			dataNascimento = dateF.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ClientePF newCliente = new ClientePF(nome,tel,end,email,CPF,genero,educacao, dataNascimento);
		listaClientesPF.add(newCliente);
		return newCliente;
	}

	public static ClientePJ obterClientePJ(ArrayList<ClientePJ> listaClientesPJ) {
		Scanner entrada = new Scanner(System.in);
		SimpleDateFormat dateF = new SimpleDateFormat("dd/MM/yyyy");
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
		System.out.println("Digite o CNPJ:");
		String CNPJ = entrada.nextLine();
		while (!Validacao.validarCNPJ(CNPJ)) {
			System.out.println("CNPJ inválido!");
			CNPJ = entrada.nextLine();
		}
		CNPJ = CNPJ.replaceAll("[^0-9]", "");
		System.out.println("Digite a quantidade de funcionarios:");
		String q = entrada.nextLine();
		int qntFuncionarios = Integer.parseInt(q);
		System.out.println("Digite a data de fundacao [dd/MM/yyyy]:");
		String date = entrada.nextLine();					
		Date dataFundacao = new Date();
		try {
			dataFundacao = dateF.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ClientePJ newCliente = new ClientePJ(nome,tel,end,email,CNPJ,qntFuncionarios,dataFundacao);
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

	public static Condutor selecionarCondutor(ArrayList<Condutor> listaCondutores) {
		System.out.println("Selecione o condutor desejado por seu CPF:");
		Scanner entrada = new Scanner(System.in);
		for (Condutor condutorAtual : listaCondutores) {
			int index = 1 + listaCondutores.indexOf(condutorAtual);
			System.out.println(index + "-" + condutorAtual.getCPF());
		}		
		String S = entrada.nextLine();
		int s = Integer.parseInt(S);
		return listaCondutores.get(s-1);
	}

	public static Condutor obterCondutor() {
		Scanner entrada = new Scanner(System.in);
		SimpleDateFormat dateF = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Digite o CPF do condutor:");
		String CPF = entrada.nextLine();
		while (!Validacao.validarCPF(CPF)) {
			System.out.println("CPF inválido!");
			CPF = entrada.nextLine();
		}
		CPF = CPF.replaceAll("[^0-9]", "");
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
		System.out.println("Digite a data de nascimento [dd/MM/yyyy]:");
		String date = entrada.nextLine();					
		Date dataNasc = new Date();
		try {
			dataNasc = dateF.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Condutor condutor = new Condutor(CPF,nome,tel,end,email,dataNasc);
		return condutor;
	}

	public static Frota obterFrota() {		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite o code da Frota que sera cadastrada:");
		String code = entrada.nextLine();
		Frota newFrota = new Frota(code);
		System.out.println("Quantos Veiculos essa frota possui?");
		int qnt = entrada.nextInt();
		for (int i=0;i<qnt;i++) {
			Veiculo veiculo = obterVeiculo();
			newFrota.addVeiculo(veiculo);		
		}
		return newFrota;
	}

	public static Seguro selecionarSeguro(ArrayList<Seguro> listaSeguros) {
		System.out.println("Selecione o seguro desejado por sua ID:");
		Scanner entrada = new Scanner(System.in);
		for (Seguro seguroAtual : listaSeguros) {
			int index = 1 + listaSeguros.indexOf(seguroAtual);
			System.out.println(index + "-" + seguroAtual.getID());
		}		
		String S = entrada.nextLine();
		int s = Integer.parseInt(S);
		return listaSeguros.get(s-1);
	}
	
	public static Veiculo selecionarVeiculo(ArrayList<Veiculo> listaVeiculos) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite o numero do Veiculo que fara a operacao:");
		for (Veiculo veiculoAtual : listaVeiculos) {
			int index = 1 + listaVeiculos.indexOf(veiculoAtual);
			System.out.println(index + "- Placa: " +veiculoAtual.getPlaca());
		}
		String S = entrada.nextLine();
		int s = Integer.parseInt(S);		
		return listaVeiculos.get(s-1);
	}
	
	public static Frota selecionarFrota(ArrayList<Frota> listaFrota) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite o code da Frota que fara a operacao:");
		for (Frota frotaAtual : listaFrota) {
			int index = 1 + listaFrota.indexOf(frotaAtual);
			System.out.println(index + "-" +frotaAtual.getCode());
		}
		String S = entrada.nextLine();
		int s = Integer.parseInt(S);		
		return listaFrota.get(s-1);
	}
	
	public static void main(String[] args) {
		Date today = new Date();
		Date then = new Date(60, 05, 21);
		ArrayList<Seguradora> listaSeguradoras = new ArrayList<Seguradora>();
		ArrayList<ClientePF> listaClientesPF = new ArrayList<ClientePF>();
		ArrayList<ClientePJ> listaClientesPJ = new ArrayList<ClientePJ>();
		ArrayList<Condutor> listaCondutor = new ArrayList<Condutor>();
		ArrayList<Veiculo> listaVeiculo = new ArrayList<Veiculo>();

		Veiculo carro = new Veiculo("HFH2230", "Ford", "Ka", 2017);
		listaVeiculo.add(carro);
		Veiculo moto = new Veiculo("PUT5540", "Yamaha", "Lander 250", 2020);
		listaVeiculo.add(moto);
		ClientePF pessoa = new ClientePF("LUIZ INACIO LULA DA SILVA","38421910", "Rua Londres","b166623@gmail.com" ,"070.680.938-68", 
				"M" , "Superior Completo" , then);
		listaClientesPF.add(pessoa);	
		ClientePJ empresa = new ClientePJ("Cereais Ltda","38413438" ,"Bosque Agua Branca" , "cereais@gmail.com",
				"56.419.013/0001-54", 200,then);
		listaClientesPJ.add(empresa);
		Seguradora seg1 = new Seguradora("90.400.888/0001-42","Bradesco", "38465678", "v12345@dac.unicamp.br", "Germano Casellatto");
		listaSeguradoras.add(seg1);
		//Seguradora seg2 = new Seguradora("92.754.738/0001-62","", "Allianz", "qualquerum@gmail.com", "Roxo Moreira");
		//listaSeguradoras.add(seg2);
		Condutor cond1 = new Condutor("070.680.938-68", "LUIZ INACIO LULA DA SILVA","38421910", "Rua Londres", "b166623@gmail.com", then);
		listaCondutor.add(cond1);
		Condutor cond2 = new Condutor("453.178.287-91", "Bolsonaro","6666-6666", "SLA", "bolsonaro@gmail.com", then);
		listaCondutor.add(cond2);
		Frota frota = new Frota("12rde");

		//TESTANDO TOSTRING
		System.out.println(carro.toString());
		System.out.println(pessoa.toString());
		System.out.println(empresa.toString());
		System.out.println(seg1.toString());
		System.out.println(cond1.toString());
		System.out.println(frota.toString());

		System.out.println("----#----#-----#-----");
		System.out.println("CADASTRANDO VEICULO, ADICIONANDO VEICULO EM FROTA E CADASTRANDO FROTA...");
		if (pessoa.cadastrarVeiculo(carro)) {
			System.out.println("Veiculo adicionado a pessoa.");
			System.out.println(pessoa.toString());
		}
		if (frota.addVeiculo(moto)) {
			System.out.println("Veiculo adicionado a frota.");
			System.out.println(frota.toString());
		}
		if (empresa.cadastrarFrota(frota)) {
			System.out.println("Frota adicionada a empresa.");
			System.out.println(empresa.toString());
		}

		System.out.println("----#----#-----#-----");
		System.out.println("CADASTRANDO CLIENTES...");
		if (seg1.cadastrarCliente(pessoa)) {System.out.println("Cliente cadastrado!");}
		if (seg1.cadastrarCliente(empresa)) {System.out.println("Cliente cadastrado!");}
		System.out.println(seg1.toString());

		System.out.println("----#----#-----#-----");		
		System.out.println("GERANDO SEGUROS...");			
		if (seg1.gerarSeguro(empresa.getCNPJ(),then,today,frota)) {System.out.println("Seguro gerado!");}
		if (seg1.gerarSeguro(pessoa.getCPF(),then,today,carro)) {System.out.println("Seguro gerado!");}

		System.out.println("----#----#-----#-----");		
		System.out.println("LISTANDO CLIENTES...");			
		System.out.println(seg1.listarClientes("CPF"));
		System.out.println(seg1.listarClientes("CNPJ"));

		System.out.println("----#----#-----#-----");		
		System.out.println("CALCULAR RECEITA...");
		System.out.println("Receita Total: "+seg1.calcularReceita());

		System.out.println("----#----#-----#-----");		
		System.out.println("CANCELAR SEGURO...");
		if (seg1.cancelarSeguro(pessoa.getCPF())) {System.out.println("Seguro cancelado!");}		
		System.out.println(seg1.getSegurosPorCliente(empresa.getCNPJ()));

		System.out.println("----#----#-----#-----");		
		System.out.println("REMOVER CLIENTE...");
		if (seg1.removerCliente(pessoa.getCPF())) {System.out.println("Cliente removido!");}		
		System.out.println(seg1.getListaClientes().size());

		System.out.println("----#----#-----#-----");		
		System.out.println("ATUALIZANDO FROTA DA EMPRESA...");
		ArrayList<Veiculo> listaAdicionar = new ArrayList<Veiculo>();
		listaAdicionar.add(carro);
		if (empresa.atualizarFrota("12rde", 1, listaAdicionar)) {
			System.out.println("Adicionado um veiculo!" + empresa.getVeiculosPorFrota("12rde"));		
			System.out.println("Receita Total: "+seg1.calcularReceita());
		}
		ArrayList<Veiculo> listaRemover = new ArrayList<Veiculo>();
		listaRemover.add(carro);
		if (empresa.atualizarFrota("12rde", 2, listaRemover)) {
			System.out.println("Removido um veiculo!" + empresa.getVeiculosPorFrota("12rde"));		
			System.out.println("Receita Total: "+seg1.calcularReceita());
		}
		if (empresa.atualizarFrota("12rde", 3)) {
			System.out.println("Frota Removida!");
			seg1.cancelarSeguro(empresa.getCNPJ());
			System.out.println("Receita Total: "+seg1.calcularReceita());
		}
		System.out.println("----#----#-----#-----");		
		System.out.println("RESETANDO A SEGURADORA...");
		seg1.removerCliente(empresa.getCNPJ());
		empresa.cadastrarFrota(frota);
		seg1.cadastrarCliente(pessoa); seg1.cadastrarCliente(empresa); //voltando ao começo para gerar sisnistro
		seg1.gerarSeguro(empresa.getCNPJ(),then,today,frota); seg1.gerarSeguro(pessoa.getCPF(),then,today,carro); 
		System.out.println("Receita Total: "+seg1.calcularReceita());

		System.out.println("----#----#-----#-----");		
		System.out.println("GERANDO SINISTRO...");
		for (Seguro seguro : seg1.getSegurosPorCliente(empresa.getCNPJ())) {
			if(seguro.autorizarCondutor(cond2)) {
				System.out.println("Condutor autorizado!");
				seguro.gerarSinistro(cond2.getCPF(), then, cond2.getEndereco());
			}
		}
		System.out.println(seg1.getSinistroPorCliente(empresa.getCNPJ()));
		System.out.println("Receita Total: "+seg1.calcularReceita());
		for (Seguro seguro : seg1.getSegurosPorCliente(pessoa.getCPF())) {
			if(seguro.autorizarCondutor(cond1)) {
				System.out.println("Condutor autorizado!");
				seguro.gerarSinistro(cond1.getCPF(), then, cond1.getEndereco());
				System.out.println(seg1.getSinistroPorCliente(pessoa.getCPF()));
				System.out.println("Receita Total: "+seg1.calcularReceita());
				if (seguro.desautorizarCondutor(cond1.getCPF())) {System.out.println("Condutor desautorizado!");}
				seguro.autorizarCondutor(cond1);
			}
		}
		System.out.println(seg1.getSinistroPorCliente(pessoa.getCPF()));
		System.out.println("Receita Total: "+seg1.calcularReceita());


		Scanner entrada = new Scanner(System.in);
		Scanner entrada1 = new Scanner(System.in);
		MenuOperacoes estado = MenuOperacoes.MENUINICIAL;
		boolean isRunning = true;
		while (isRunning) {
			System.out.println(estado.getMenuOpcoes());			
			String es = entrada.nextLine();
			int escolha = Integer.parseInt(es);						
			if(estado == MenuOperacoes.CADASTROS) {					
				switch(escolha) {
				case(1):
					//CADASTRAR CLIENTE
					Seguradora seguradoraAtual = selecionarSeguradora(listaSeguradoras);
					System.out.println("Cliente a ser cadastrado é:");
					System.out.println("1-PF\n2-PJ");						
					String tipo = entrada1.nextLine();
					int tipoCliente = Integer.parseInt(tipo);
					while (tipoCliente != 1 && tipoCliente != 2) {
						System.out.println("Entrada inválida!");
						tipo = entrada1.nextLine();
						tipoCliente = Integer.parseInt(tipo);
					}
					if (tipoCliente == 1) {
						Cliente newCliente = obterClientePF(listaClientesPF);
						seguradoraAtual.cadastrarCliente(newCliente);
						System.out.println("Cliente PF cadastrado!");							
					}
					else {
						Cliente newCliente = obterClientePJ(listaClientesPJ);
						seguradoraAtual.cadastrarCliente(newCliente);
						System.out.println("Cliente PJ cadastrado!");
					}
					break;
				case(2):
					//CADASTRAR VEICULO EM PF
					Veiculo veiculo = obterVeiculo();						
					System.out.println("Digite o CPF/CNPJ do cliente a qual o veiculo sera cadastrado:");
					String id = entrada1.nextLine();						
					while (!Validacao.validarCNPJ(id) && !Validacao.validarCPF(id)) {
						System.out.println("CPF/CNPJ inválido!");
						id = entrada1.nextLine();
					}
					id = id.replaceAll("[^0-9]", "");
					for (ClientePF clienteAtual : listaClientesPF) {
						if(clienteAtual.getCPF().equals(id)) {
							clienteAtual.cadastrarVeiculo(veiculo);
							System.out.println("Veiculo adicionado!");
							break;
						}
					}	
					break;
				case(3):
					//CADASTRAR SEGURADORA
					System.out.println("Digite o CNPJ:");
					String CNPJ = entrada.nextLine();
					while (!Validacao.validarCNPJ(CNPJ)) {
						System.out.println("CNPJ inválido!");
						CNPJ = entrada.nextLine();
					}
					System.out.println("Digite o nome da Seguradora:");
					String nome = entrada1.nextLine();						
					System.out.println("Digite o telefone:");
					String tel = entrada1.nextLine();						
					System.out.println("Digite o email:");
					String email = entrada1.nextLine();						
					System.out.println("Digite o endereco:");
					String end = entrada1.nextLine();											
					Seguradora novaSeg = new Seguradora(CNPJ,nome, tel, email, end);
					listaSeguradoras.add(novaSeg);
					System.out.println("Seguradora cadastrada!");
					break;
				case(4):
					//CADASTRAR FROTA EM PJ
					Frota frota1 = obterFrota();						
					System.out.println("Digite o CNPJ do cliente a qual a frota sera cadastrado:");
					String id1 = entrada1.nextLine();			
					while (!Validacao.validarCNPJ(id1)) {
						System.out.println("CNPJ inválido!");
						id1 = entrada1.nextLine();
					}
					id1 = id1.replaceAll("[^0-9]", "");
					for (ClientePJ clienteAtual : listaClientesPJ) {
						if(clienteAtual.getCNPJ().equals(id1)) {
							clienteAtual.cadastrarFrota(frota1);
							System.out.println("Frota cadastrada!");
							break;
						}
					}
					break;
				case(5):
					estado = MenuOperacoes.MENUINICIAL;
				break;	
				}	
			}			
			else if(estado == MenuOperacoes.LISTAR) {			
				switch(escolha) {
				case(1):
					//LISTAR CLIENTES POR SEGURADORA
					Seguradora seguradoraAtual = selecionarSeguradora(listaSeguradoras);						
					System.out.println(seguradoraAtual.listarClientes("CPF"));
					System.out.println(seguradoraAtual.listarClientes("CNPJ"));		
					break;						
				case(2):
					//LISTAR SEGUROS POR SEG						
					Seguradora seguradoraAtual1 = selecionarSeguradora(listaSeguradoras);
					System.out.println(seguradoraAtual1.getListaSeguros());		
					break;
				case(3):
					//LISTAR SINISTROS POR CLIENTE
					System.out.println("Digite o CPF/CNPJ do cliente a qual se deseja listar os sinistros:");
					String id = entrada1.nextLine();
					while (!Validacao.validarCNPJ(id) && !Validacao.validarCPF(id)) {
						System.out.println("CPF/CNPJ inválido!");
						id = entrada1.nextLine();
					}					
					id = id.replaceAll("[^0-9]", "");
					for (Seguradora seguradoraAtual2 : listaSeguradoras) {
						System.out.println("Sinistros da Seguradora "+seguradoraAtual2.getNome()+":");
						System.out.println(seguradoraAtual2.getSinistroPorCliente(id));
					}
					break;
				case(4):
					//LISTAR VEICULO POR CLIENTE PF
					System.out.println("Digite o CPF do cliente a qual os veiculos serao listados:");
					String id1 = entrada1.nextLine();						
					while (!Validacao.validarCPF(id1)) {
						System.out.println("CPF inválido!");
						id1 = entrada1.nextLine();
					}
					id1 = id1.replaceAll("[^0-9]", "");
					for (ClientePF clienteAtual : listaClientesPF) {
						if(clienteAtual.getCPF().equals(id1)) {
							System.out.println(clienteAtual.getListaVeiculos());
							break;
						}
					}
					break;
				case(5):
					//LISTAR FROTA POR PJ
					System.out.println("Digite o CPF/CNPJ do cliente a qual as frotas serao listadas:");
					String id12 = entrada1.nextLine();						
					while (!Validacao.validarCNPJ(id12)) {
						System.out.println("CPF/CNPJ inválido!");
						id12 = entrada1.nextLine();
					}
					id12 = id12.replaceAll("[^0-9]", "");
					for (ClientePJ clienteAtual : listaClientesPJ) {
						if(clienteAtual.getCNPJ().equals(id12)) {
							System.out.println(clienteAtual.getListaFrota());
							break;
						}
					}						
					break;
				case(6):
					//LISTAR SEGUROS POR CLIENTE
					System.out.println("Digite o CPF/CNPJ do cliente a qual se deseja listar os sinistros:");
					String id11 = entrada1.nextLine();
					while (!Validacao.validarCNPJ(id11) && !Validacao.validarCPF(id11)) {
						System.out.println("CPF/CNPJ inválido!");
						id11 = entrada1.nextLine();
					}			
					id11 = id11.replaceAll("[^0-9]", "");
					for (Seguradora seguradoraAtual3 : listaSeguradoras) {
						System.out.println("Seguros da Seguradora "+seguradoraAtual3.getNome()+":");
						System.out.println(seguradoraAtual3.getSegurosPorCliente(id11));
					}
					break;
				case(7):
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
					ID = ID.replaceAll("[^0-9]", "");
					if (seguradoraAtual.removerCliente(ID)) {System.out.println("Cliente removido!");}
					break;
				case(2):
					//EXCLUIR SEGURO					
					Seguradora seguradoraAtual2 = selecionarSeguradora(listaSeguradoras);						
					System.out.println("Escreva CPF/CNPJ do cliente cujo seguro deve ser removido:");
					String ID1 = entrada1.nextLine();
					while (!Validacao.validarCNPJ(ID1) && !Validacao.validarCPF(ID1)) {
						System.out.println("CPF/CNPJ inválido!");
						ID1 = entrada1.nextLine();
					}
					ID1 = ID1.replaceAll("[^0-9]", "");
					if (seguradoraAtual2.cancelarSeguro(ID1)) {System.out.println("Seguro cancelado!");}
					break;
				case(3):
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
						Seguradora seguradoraAtual = selecionarSeguradora(listaSeguradoras);
						if (seguradoraAtual.getListaSeguros().size() == 0) {
							System.out.println("Erro! Seguradora não possui seguros!");
							break;
						}
						Seguro seguro = selecionarSeguro(seguradoraAtual.getListaSeguros());
						if (seguro.getListaCondutores().size() == 0) {
							System.out.println("Erro! Seguro não possui condutores!");
							break;
						}
						Condutor condutor = selecionarCondutor(seguro.getListaCondutores());
						SimpleDateFormat dateF = new SimpleDateFormat("dd/MM/yyyy");
						System.out.println("Digite a data [dd/MM/yyyy]:");
						String date = entrada.nextLine();					
						Date data = new Date();
						try {
							data = dateF.parse(date);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("Digite o endereco:");
						String end = entrada1.nextLine();
						if(seguro.gerarSinistro(condutor.getCPF(), data, end)) {System.out.println("Sinistro gerado!");}
						break;
					case(5):
						//GERAR SEGURO
						Seguradora seguradoraAtual1 = selecionarSeguradora(listaSeguradoras);
						SimpleDateFormat dateF1 = new SimpleDateFormat("dd/MM/yyyy");
						System.out.println("Digite a data de inicio [dd/MM/yyyy]:");
						String date1 = entrada.nextLine();					
						Date dataInicio = new Date();
						try {
							dataInicio = dateF1.parse(date1);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("Digite a data de fim [dd/MM/yyyy]:");
						date1 = entrada.nextLine();					
						Date dataFim = new Date();
						try {
							dataFim = dateF1.parse(date1);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}						
						System.out.println("Digite o CPF/CNPJ do cliente:");
						String ID = entrada1.nextLine();
						while (!Validacao.validarCNPJ(ID) && !Validacao.validarCPF(ID)) {
							System.out.println("CPF/CNPJ inválido!");
							ID = entrada1.nextLine();
						}
						ID = ID.replaceAll("[^0-9]", "");
						if (Validacao.validarCNPJ(ID)) {
							ArrayList<Frota> listaFrotas = seguradoraAtual1.getFrotasPorCliente(ID);
							Frota newFrota = selecionarFrota(listaFrotas);
							if(seguradoraAtual1.gerarSeguro(ID,dataInicio,dataFim,newFrota)) {System.out.println("Seguro gerado!");}
						}
						if (Validacao.validarCPF(ID)) {
							ArrayList<Veiculo> listaVeiculos = seguradoraAtual1.getVeiculosPorCliente(ID);
							Veiculo newVeiculo = selecionarVeiculo(listaVeiculos);
							if(seguradoraAtual1.gerarSeguro(ID,dataInicio,dataFim,newVeiculo)) {System.out.println("Seguro gerado!");}
						}				
						break;
					case(6):
						//CALCULAR RECEITA
						Seguradora seguradoraAtual2 = selecionarSeguradora(listaSeguradoras);
						String valorFormatado = String.format("%.2f", seguradoraAtual2.calcularReceita());
						System.out.println("Receita Total: R$" + valorFormatado);
						break;
					case(7):
						//AUTORIZAR CONDUTOR
						Seguradora seguradoraAtual3 = selecionarSeguradora(listaSeguradoras);
						Seguro seguroAtual = selecionarSeguro(seguradoraAtual3.getListaSeguros());
						Condutor condutor1 = obterCondutor();
						if(seguroAtual.autorizarCondutor(condutor1)) {System.out.println("Condutor autorizado!");}
						break;
					case(8):
						//DESAUTORIZAR CONDUTOR
						Seguradora seguradoraAtual4 = selecionarSeguradora(listaSeguradoras);
						Seguro seguroAtual1 = selecionarSeguro(seguradoraAtual4.getListaSeguros());
						System.out.println("Digite o CPF do condutor:");
						String cond5 = entrada1.nextLine();
						while (!Validacao.validarCPF(cond5)) {
							System.out.println("CPF inválido!");
							cond5 = entrada1.nextLine();
						}
						cond5 = cond5.replaceAll("[^0-9]", "");
						if(seguroAtual1.desautorizarCondutor(cond5)) {System.out.println("Condutor desautorizado!");}
						break;
					case(0):
						isRunning = false;
						System.out.println("Saindo!");
						break;
				}			
			}
		}
		entrada.close();
		entrada1.close();
	}
}