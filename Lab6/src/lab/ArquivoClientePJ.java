package lab;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ArquivoClientePJ implements I_Arquivo {
	private final String NOME_ARQUIVO = "lab06-seguradora_arquivos_v2/clientesPJ.csv";

	@Override
	public boolean gravarArquivo(String conteudo) throws IOException {
		return false;
	}

	@Override
	public ArrayList<String> lerArquivo() throws IOException {
		ArrayList<String> condutores = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(NOME_ARQUIVO))) {
			String linha;
			boolean primeiraLinha = true;

			while ((linha = br.readLine()) != null) {
				if (primeiraLinha) {  // Ignora o cabeçalho do arquivo CSV
					primeiraLinha = false;
					continue;
				}
				condutores.add(linha);
			}
		} catch (IOException e) {
			System.out.println("Erro ao ler o arquivo CSV: " + e.getMessage());
		}
		return condutores;
	} 

}
