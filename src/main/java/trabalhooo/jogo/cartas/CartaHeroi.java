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
public class CartaHeroi extends CartaPontuada{
    
    private final String descricao;

    public CartaHeroi(String nome, Faccao faccao, int fileira, String tipo, int pontuacao) {
        super(nome, faccao, fileira, tipo, pontuacao);
        this.descricao = "Herói, não é afetada por nenhuma carta especial ou de habilidade";
    }
    
    public String getDescricao(){
        return this.descricao;
    }
    

    @Override
    public void getEfeito(Efeito efeito) {
        ;
    }
    
}
