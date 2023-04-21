package lab;
import java.util.Date;

public class lab {

	public static void main(String[] args) {
		//instanciando
		Seguradora seg = new Seguradora("Seguro", "38421910", "v12345@dac.unicamp.br", "Germano Casellatto");
		//System.out.println(seg.toString());
		
		Date today = new Date();
		Date then = new Date(117, 05, 21);
		
		ClientePF pessoa = new ClientePF("LUIZ INACIO LULA DA SILVA", "Rua Londres", "070.680.938-68", 
				"masculino" , today, "Superior Completo", then, "Alta");
		//System.out.println(pessoa.toString());
		
		ClientePJ empresa = new ClientePJ("Cereais Ltda", "Bosque Agua Branca" , 
				"56.419.013/0001-54", then);
		//System.out.println(empresa.toString());
		
		seg.cadastrarCliente(pessoa);
		//System.out.println(seg.toString());
		seg.cadastrarCliente(empresa);
		seg.listarClientes("CPF");
		seg.listarClientes("CNPJ");
		seg.removerCliente("");
		seg.removerCliente("070.680.938-68");
		seg.listarClientes("CPF");
		seg.listarClientes("CNPJ");
		
		
		
		
		/*Veiculo carro = new Veiculo("PUT6620", "Ford", "Ka");
		Cliente pessoa = new Cliente("LUIZ INACIO LULA DA SILVA", "070.680.938-68", "06/10/1945", "Rua Londres", 77);
		Sinistro sin = new Sinistro("10/02/2015", "Unicamp");
		
		//testando getters
		System.out.println(seg.toString());
		System.out.println(carro.toString());
		System.out.println(sin.toString());
		System.out.println(pessoa.toString());	
		
		System.out.println("---#---#---");
		
		//testando setters
		seg.setEmail("a234567@dac.unicamp.br");
		seg.setEndereco("Minas Gerais");
		seg.setNome("Menos Seguro");
		seg.setTelefone("38413438");
		
		carro.setMarca("Jeep");
		carro.setModelo("Compass");
		carro.setPlaca("RUN1234");
		
		pessoa.setCpf("453.178.287-91");
		pessoa.setDataNascimento("21/03/1955");
		pessoa.setEndereco("Marte");
		pessoa.setIdade(68);
		pessoa.setNome("JAIR MESSIAS BOLSONARO");
		
		sin.setData("11/02/2015");
		sin.setEndereco("Campinas");
		
		System.out.println(seg.toString());
		System.out.println(carro.toString());
		System.out.println(sin.toString());
		System.out.println(pessoa.toString());	*/
		
	}

}
