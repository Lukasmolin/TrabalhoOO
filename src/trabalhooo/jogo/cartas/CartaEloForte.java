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

    public CartaEloForte(String nome, Faccao faccao, int fileira, String tipo, int pontuacao) {
        super(nome, faccao, fileira, tipo, pontuacao);
        super.setDescricao("Dobra a pontuação de uma carta idêntica na fileira");
    }
    
    @Override
    public void getEfeito(Efeito efeito) {
       
       efeito.cartaEloForte(this);
    }
    
    
}
