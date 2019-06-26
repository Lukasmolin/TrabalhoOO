/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhooo.jogo.cartas;

/**
 *
 * @author izabe
 */
public class CartaCoragem extends CartaPontuada{
    
    private final String descricao;

    public CartaCoragem(String nome, Faccao faccao, int fileira, String tipo, int pontuacao) {
        super(nome, faccao, fileira, tipo, pontuacao);
        this.descricao = "Invoca de uma vez todas as outras cartas de mesmo tipo.";
    }
    
    /**
     * Construtor da classe CartaCoragem
     * @param nome
     * @param faccao
     * @param pontuacao 
     */
    
    
    
    
    
    /**
     * Retorna descrição
     * @return 
     */
    public String getDescricao(){
        return this.descricao;
    }
    /**
     * 
     * @param efeito 
     */
    @Override
    public void getEfeito(Efeito efeito) {
        efeito.CartaCoragem(this);
    }
    
}
