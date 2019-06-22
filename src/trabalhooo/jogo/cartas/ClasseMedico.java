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
public class ClasseMedico extends CartaPontuada{
    
    private final String descricao;
    public ClasseMedico(String nome, Faccao faccao, int pontuacao) {
        super(nome, faccao, pontuacao);
        this.descricao = "Traz de volta de uma carta de unidade a sua escolha da pilha de descarte. ";
    }

    @Override
    public void getEfeito(Efeito efeito) {
       efeito.CartaMedico(this);
    }
    
}
