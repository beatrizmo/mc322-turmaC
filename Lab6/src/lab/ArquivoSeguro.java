package lab;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ArquivoSeguro implements I_Arquivo {
	private final String NOME_ARQUIVO = "lab06-seguradora_arquivos_v2/seguros.csv";

	@Override
	public boolean gravarArquivo(String conteudo) throws IOException {
		File file = new File(NOME_ARQUIVO);
		boolean novo = false;
		// Verifica se o arquivo já existe
		if (!file.exists()) {
			try {
				// Cria o arquivo se ele não existir
				file.createNewFile();
				novo = true;
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}			
		try (PrintWriter writer = new PrintWriter(new FileWriter(NOME_ARQUIVO, true))) {
            // Escreve o cabeçalho no arquivo CSV, se estiver vazio
            if (novo) {
            	writer.println("ID,Data Inicio,Data Fim,Seguradora,Sinistros,Condutores,Valor Mensal");                
            }
            // Escreve os dados no arquivo CSV
            writer.println(conteudo);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }	
		return false;
	}

	@Override
	public ArrayList<String> lerArquivo() throws IOException {
		return null;
	}

}
