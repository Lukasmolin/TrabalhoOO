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
    
    protected CartaPontuada(String nome, Faccao faccao, int pontuacao){
        super(nome, faccao);
        this.pontuacao = pontuacao;
    }
    
    /**
     * Retorna a pontuação
     * @return a pontuação da CartaPontuada
     */
    public int getPontuacao(){
        return pontuacao;
    }
    
    /**
     * Altera a pontuação da carta pelo valor passado, adicionando/subtraindo o valor dependendo se positivo ou negativo
     * @param mudanca Valores negativos para subtrair e positivos para adicionar
     */
    public void alteraPpontuacao(int mudanca){
        this.pontuacao += mudanca;
    }
}
