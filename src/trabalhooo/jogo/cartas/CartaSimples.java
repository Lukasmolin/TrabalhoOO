/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhooo.jogo.cartas;

/**
 *
 * @author Lucas Molin <lucasmolin@ice.ufjf.br>
 */


public class CartaSimples extends CartaPontuada{
    
    /**
     * Contrutor da CartaSimples
     * @param nome Nome da carta
     * @param faccao Faccao da carta
     * @param pontuacao pontuacao inicial da carta
     */
    public CartaSimples(String nome, Faccao faccao, int pontuacao){
        super(nome, faccao, pontuacao);
    }
    
    @Override
    public Efeito getEfeito(){
        return new Efeito();
    }
}