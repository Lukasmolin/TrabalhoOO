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
public class CartaAumentoMoral extends CartaPontuada{
    
    private final String descricao;

    public CartaAumentoMoral(String nome, Faccao faccao, int fileira, String tipo, int pontuacao) {
        super(nome, faccao, fileira, tipo, pontuacao);
        this.descricao = "Aumenta um ponto de cada carta da mesma fileira.";
    }
    
    
    
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
        efeito.CartaAumentoMoral(this);
    }
    
}
