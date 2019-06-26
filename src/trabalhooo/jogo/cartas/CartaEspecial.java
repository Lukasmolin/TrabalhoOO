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
public class CartaEspecial extends Carta{
    
    private int id;
    private String descricao;
    public CartaEspecial(String nome, Faccao faccao, int fileira, String tipo,int id) {
        super(nome, faccao, fileira, tipo);
        if (this.id==004){
            this.descricao = "Substitui uma carta no campo que retorna para a mao do jogador.";
        }
        if (this.id==005){
            this.descricao = "Dobra a pontuacao de todas as cartas da fileira.";
        }
        else {
            this.descricao = "Destroi a carta mais forte no campo inimigo."; 
        }
    }
    
    public int getId(){
        return this.id;
    }

    @Override
    public void getEfeito(Efeito efeito) {
        efeito.CartaEspecial(this);
    }
    
}
