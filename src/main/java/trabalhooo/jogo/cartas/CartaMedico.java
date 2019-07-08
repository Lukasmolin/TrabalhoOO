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
public class CartaMedico extends CartaPontuada{
    
    private final String descricao;

    public CartaMedico(String nome, Faccao faccao, int fileira, String tipo, int pontuacao) {
        super(nome, faccao, fileira, tipo, pontuacao);
        this.descricao = "Traz de volta de uma carta de unidade a sua escolha da pilha de descarte. ";
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
       efeito.CartaMedico(this);
    }
    
}
