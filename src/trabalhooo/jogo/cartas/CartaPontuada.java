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
public abstract class CartaPontuada extends Carta{
    private int pontuacao;

    public CartaPontuada(String nome, Faccao faccao, int fileira, String tipo, int pontuacao) {
        super(nome, faccao, fileira, tipo);
        this.pontuacao = pontuacao;
    }
    
    
    
    /**
     * Retorna a pontuação
     * @return a pontuação da CartaPontuada
     */
    @Override
    public int getPontuacao(){
        return pontuacao;
    }
    
    /**
     * Altera a pontuação da carta pelo valor passado, adicionando/subtraindo o valor dependendo se positivo ou negativo
     */
    @Override
    public void setPontuacao(int novaPontuacao){
        this.pontuacao = novaPontuacao;
    }
}
