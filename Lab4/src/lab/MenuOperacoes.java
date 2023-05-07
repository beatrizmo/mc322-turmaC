package lab;

public enum MenuOperacoes {
    CADASTROS("1", "Cadastros"),
    CADASTRAR_CLIENTE_PF_PJ("1.1", "Cadastrar Cliente PF/PJ"),
    CADASTRAR_VEICULO("1.2", "Cadastrar Veiculo"),
    CADASTRAR_SEGURADORA("1.3", "Cadastrar Seguradora"),
    VOLTAR_CADASTROS("1.4", "Voltar"),
    LISTAR("2", "Listar"),
    LISTAR_CLIENTE_POR_SEG("2.1", "Listar Cliente (PF/PJ) por Seg."),
    LISTAR_SINISTROS_POR_SEGURADORA("2.2", "Listar Sinistros por Seguradora"),
    LISTAR_SINISTRO_POR_CLIENTE("2.3", "Listar Sinistro por Cliente"),
    LISTAR_VEICULO_POR_CLIENTE("2.4", "Listar Veiculo por Cliente"),
    LISTAR_VEICULO_POR_SEGURADORA("2.5", "Listar Veiculo por Seguradora"),
    VOLTAR_LISTAR("2.6", "Voltar"),
    EXCLUIR("3", "Excluir"),
    EXCLUIR_CLIENTE("3.1", "Excluir Cliente"),
    EXCLUIR_VEICULO("3.2", "Excluir Veiculo"),
    EXCLUIR_SINISTRO("3.3", "Excluir Sinistro"),
    VOLTAR_EXCLUIR("3.4", "Voltar"),
    GERAR_SINISTRO("4", "Gerar Sinistro"),
    TRANSFERIR_SEGURO("5", "Transferir Seguro"),
    CALCULAR_RECEITA_SEGURADORA("6", "Calcular Receita Seguradora"),
    SAIR("0", "Sair");

    private final String chave;
    private final String descricao;

    
    
    MenuOperacoes(String chave, String descricao) {
        this.chave = chave;
        this.descricao = descricao;
    }

    public String getChave() {
        return chave;
    }

    public String getDescricao() {
        return descricao;
    }
}
