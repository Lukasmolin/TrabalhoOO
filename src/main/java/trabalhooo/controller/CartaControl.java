package trabalhooo.controller;

import trabalhooo.gui.CartaInfo;

/**
 * Classe usada pelo controller para passar informações de carta para a GUI
 */
public class CartaControl implements CartaInfo{

    private String nome, descricao, pontuacao;

    public CartaControl(String nome, String descricao, String pontuacao){
        inicializa(nome, descricao, pontuacao);
    }

    private void inicializa(String nome, String descricao, String pontuacao){
        this.nome = nome;
        this.descricao = descricao;
        this.pontuacao = pontuacao;
    }


    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    @Override
    public String getPontuacao() {
        return pontuacao;
    }
    
}