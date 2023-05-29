package lab;

public enum MenuOperacoes {
	MENUINICIAL("INICIO","MENU PRINCIPAL"),
    CADASTROS("1", "Cadastros"),
    CADASTRAR_CLIENTE_PF_PJ("1", "Cadastrar Cliente PF/PJ"),
    CADASTRAR_VEICULO("2", "Cadastrar Veiculo em PF"),
    CADASTRAR_SEGURADORA("3", "Cadastrar Seguradora"),
    CADASTRAR_FROTA("4", "Cadastrar Frota em PJ"),
    VOLTAR_CADASTROS("5", "Voltar"),
    LISTAR("2", "Listar"),
    LISTAR_CLIENTE_POR_SEG("1", "Listar Cliente (PF/PJ) por Seg."),
    LISTAR_SEGUROS_POR_SEG("2", "Listar Seguros por Seguradora"),
    LISTAR_SINISTRO_POR_CLIENTE("3", "Listar Sinistro por Cliente"),
    LISTAR_VEICULO_POR_CLIENTE("4", "Listar Veiculo por Cliente"),
    LISTAR_FROTA_POR_PJ("5", "Listar Frota por PJ"),
    LISTAR_SEGURO_POR_CLIENTE("6", "Listar Seguro por Cliente"),
    VOLTAR_LISTAR("7", "Voltar"),
    EXCLUIR("3", "Excluir"),
    EXCLUIR_CLIENTE("1", "Excluir Cliente"),
    EXCLUIR_SEGURO("2", "Excluir Seguro"),
    VOLTAR_EXCLUIR("3", "Voltar"),
    GERAR_SINISTRO("4", "Gerar Sinistro"),
    GERAR_SEGURO("5", "Gerar Seguro"),
    CALCULAR_RECEITA_SEGURADORA("6", "Calcular Receita Seguradora"),
    AUTORIZAR_CONDUTOR("7", "Autorizar Condutor"),
    DESAUTORIZAR_CONDUTOR("8", "Desautorizar Condutor"),
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
    		return this.getDescricao() + "\n" + CADASTROS.getAll() + "\n" + LISTAR.getAll() + "\n" + EXCLUIR.getAll() + "\n" + GERAR_SINISTRO.getAll() + "\n" + GERAR_SEGURO.getAll() + "\n" + CALCULAR_RECEITA_SEGURADORA.getAll() + "\n" + AUTORIZAR_CONDUTOR.getAll() + "\n" + DESAUTORIZAR_CONDUTOR.getAll() + "\n" + SAIR.getAll();
    	}
    	else if (this.getDescricao().equals("Cadastros")) {
    		return this.getDescricao() + "\n" + CADASTRAR_CLIENTE_PF_PJ.getAll() + "\n" +CADASTRAR_VEICULO.getAll() + "\n" + CADASTRAR_SEGURADORA.getAll() + "\n" +CADASTRAR_FROTA.getAll() + "\n" + VOLTAR_CADASTROS.getAll();
    	}
    	else if (this.getDescricao().equals("Listar")) {
    		return this.getDescricao() + "\n" + LISTAR_CLIENTE_POR_SEG.getAll() + "\n" + LISTAR_SEGUROS_POR_SEG.getAll() + "\n" + LISTAR_SINISTRO_POR_CLIENTE.getAll() + "\n" + LISTAR_VEICULO_POR_CLIENTE.getAll() + "\n" + LISTAR_FROTA_POR_PJ.getAll() + "\n" +  LISTAR_SEGURO_POR_CLIENTE.getAll() + "\n" +VOLTAR_LISTAR.getAll();
    	}
    	else if (this.getDescricao().equals("Excluir")) {
    		return this.getDescricao() + "\n" + EXCLUIR_CLIENTE.getAll() + "\n" + EXCLUIR_SEGURO.getAll() + "\n" + VOLTAR_EXCLUIR.getAll();
    	}
    	else return this.getDescricao();
    }
    
    
    public String MenuPrincipal() {
    	return CADASTROS.getAll() + "\n" + LISTAR.getAll() + "\n" + EXCLUIR.getAll() + "\n" + GERAR_SINISTRO.getAll() + "\n" + GERAR_SEGURO.getAll() + "\n" + CALCULAR_RECEITA_SEGURADORA.getAll() + "\n" + AUTORIZAR_CONDUTOR.getAll() + "\n" + DESAUTORIZAR_CONDUTOR.getAll() + "\n" + SAIR.getAll();
    }
}
