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
public class CartaEspiao extends CartaPontuada{
    
    private final String descricao;
    
    public CartaEspiao(String nome, Faccao faccao, int pontuacao) {
        super(nome, faccao, pontuacao);
        this.descricao = "Permite comprar duas cartas do baralho, mas deve ser posicionada nas fileiras adversárias, ou seja, sua pontuação vai somar para o inimigo. ";
    }
    
    /**
     * Retorna a descricao
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
        efeito.CartaEspiao(this);
        
    }
    
}
