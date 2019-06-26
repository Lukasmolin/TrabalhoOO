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
    
    private final String descricao;

    public CartaClima(String nome, Faccao faccao, int fileira, String tipo) {
        super(nome, faccao, fileira, tipo);
        if (this.getFileira()==1){
            this.descricao = "Muda a pontuação de todas a cartas da Fileira Espadachins para 1. Funciona para amobos jogadores";
        } else if (this.getFileira()==2){
            this.descricao = "Muda a pontuação de todas a cartas da Fileira Arqueiros para 1. Funciona para amobos jogadores";
        } else if(this.getFileira()==3){
            this.descricao = "Muda a pontuação de todas a cartas da Fileira Balistas para 1. Funciona para amobos jogadores";
        } else if (this.getFileira()==4){
            this.descricao = "Remove todas as cartas de clima.";
        }
        else 
            this.descricao = "";
    }
   
    

    @Override
    public void getEfeito(Efeito efeito) {
        efeito.CartaClima(this);
    }
    
}
