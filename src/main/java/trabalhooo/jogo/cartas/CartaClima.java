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
public class CartaClima extends Carta{

    public CartaClima(String nome, Faccao faccao, int fileira, String tipo) {
        super(nome, faccao, fileira, tipo);
        if (this.getFileira()==1){
            super.setDescricao("Muda a pontuação de todas a cartas da Fileira Espadachins para 1. Funciona para amobos jogadores");
        } else if (this.getFileira()==2){
            super.setDescricao("Muda a pontuação de todas a cartas da Fileira Arqueiros para 1. Funciona para amobos jogadores");
        } else if(this.getFileira()==3){
            super.setDescricao("Muda a pontuação de todas a cartas da Fileira Balistas para 1. Funciona para amobos jogadores");
        } else if (this.getFileira()==4){
            super.setDescricao("Remove todas as cartas de clima.");
        }
        else 
            super.setDescricao("");
    }
   
    

    @Override
    public void getEfeito(Efeito efeito) {
        efeito.CartaClima(this);
    }
    
}
