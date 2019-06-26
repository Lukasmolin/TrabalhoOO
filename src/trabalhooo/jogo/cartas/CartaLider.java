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
public class CartaLider extends Carta{
    
    private final int id;
    private boolean foiusada = false;
    
    public CartaLider(String nome, Faccao faccao, int fileira,String tipo,int id) {
        super(nome, faccao, fileira,tipo);
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    
    public void setUsada(boolean b){
        this.foiusada = b;
    }
    
    public boolean getUsada(){
        return this.foiusada;
    }

    @Override
    public void getEfeito(Efeito efeito) {
       efeito.CartaLider(this);
    }
    
}
