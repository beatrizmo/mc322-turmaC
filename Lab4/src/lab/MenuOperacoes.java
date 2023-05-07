package lab;

public enum MenuOperacoes {
	MENUINICIAL("INICIO","MENU PRINCIPAL"),
    CADASTROS("1", "Cadastros"),
    CADASTRAR_CLIENTE_PF_PJ("1", "Cadastrar Cliente PF/PJ"),
    CADASTRAR_VEICULO("2", "Cadastrar Veiculo"),
    CADASTRAR_SEGURADORA("3", "Cadastrar Seguradora"),
    VOLTAR_CADASTROS("4", "Voltar"),
    LISTAR("2", "Listar"),
    LISTAR_CLIENTE_POR_SEG("1", "Listar Cliente (PF/PJ) por Seg."),
    LISTAR_SINISTROS_POR_SEG("2", "Listar Sinistros por Seguradora"),
    LISTAR_SINISTRO_POR_CLIENTE("3", "Listar Sinistro por Cliente"),
    LISTAR_VEICULO_POR_CLIENTE("4", "Listar Veiculo por Cliente"),
    LISTAR_VEICULO_POR_SEG("5", "Listar Veiculo por Seguradora"),
    VOLTAR_LISTAR("6", "Voltar"),
    EXCLUIR("3", "Excluir"),
    EXCLUIR_CLIENTE("1", "Excluir Cliente"),
    EXCLUIR_VEICULO("2", "Excluir Veiculo"),
    EXCLUIR_SINISTRO("3", "Excluir Sinistro"),
    VOLTAR_EXCLUIR("4", "Voltar"),
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
    
    public String getAll() {
    	return chave + "-" + descricao;
    }
    
    public String getMenuOpcoes() {
    	if (this.getDescricao().equals("MENU PRINCIPAL")) {
    		return this.getDescricao() + "\n" + CADASTROS.getAll() + "\n" + LISTAR.getAll() + "\n" + EXCLUIR.getAll() + "\n" + GERAR_SINISTRO.getAll() + "\n" + TRANSFERIR_SEGURO.getAll() + "\n" + CALCULAR_RECEITA_SEGURADORA.getAll() + "\n" + SAIR.getAll();
    	}
    	else if (this.getDescricao().equals("Cadastros")) {
    		return this.getDescricao() + "\n" + CADASTRAR_CLIENTE_PF_PJ.getAll() + "\n" +CADASTRAR_VEICULO.getAll() + "\n" + CADASTRAR_SEGURADORA.getAll() + "\n" + VOLTAR_CADASTROS.getAll();
    	}
    	else if (this.getDescricao().equals("Listar")) {
    		return this.getDescricao() + "\n" + LISTAR_CLIENTE_POR_SEG.getAll() + "\n" + LISTAR_SINISTROS_POR_SEG.getAll() + "\n" + LISTAR_SINISTRO_POR_CLIENTE.getAll() + "\n" + LISTAR_VEICULO_POR_CLIENTE.getAll() + "\n" + LISTAR_VEICULO_POR_SEG.getAll() + "\n" + VOLTAR_LISTAR.getAll();
    	}
    	else if (this.getDescricao().equals("Excluir")) {
    		return this.getDescricao() + "\n" + EXCLUIR_CLIENTE.getAll() + "\n" + EXCLUIR_VEICULO.getAll() + "\n" + EXCLUIR_SINISTRO.getAll() + "\n" + VOLTAR_EXCLUIR.getAll();
    	}
    	else return this.getDescricao();
    }
    
    
    public String MenuPrincipal() {
    	return CADASTROS.getAll() + "\n" + LISTAR.getAll() + "\n" + EXCLUIR.getAll() + "\n" + GERAR_SINISTRO.getAll() + "\n" + TRANSFERIR_SEGURO.getAll() + "\n" + CALCULAR_RECEITA_SEGURADORA.getAll() + "\n" + SAIR.getAll();
    }
}
