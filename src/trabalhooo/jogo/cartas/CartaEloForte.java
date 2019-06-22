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
public class CartaEloForte extends CartaPontuada{
    
    private final String descricao; 
    public CartaEloForte(String nome, Faccao faccao, int pontuacao) {
        super(nome, faccao, pontuacao);
        this.descricao = "Dobra a pontuação de uma carta idêntica na fileira";
    }
    
    /**
     * Retorna descricao
     * @return 
     */
    public String getDescricao(){
        return this.descricao;
    }
    
    @Override
    public void getEfeito(Efeito efeito) {
       
       efeito.cartaEloForte(this);
    }
    
    
}
