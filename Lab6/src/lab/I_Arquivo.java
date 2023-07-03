package lab;

import java.io.IOException;
import java.util.ArrayList;

//Interface que define os métodos para gravar e ler arquivos
public interface I_Arquivo {
    boolean gravarArquivo(String conteudo) throws IOException;
    ArrayList<String> lerArquivo() throws IOException;
}

