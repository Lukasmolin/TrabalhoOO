/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhooo.jogo.cartas;

import trabalhooo.jogo.Tabuleiro;
import trabalhooo.jogo.Fileira;
import trabalhooo.jogo.Jogador;
import trabalhooo.jogo.Campo;

/**
 *
 * @author izabe
 */
/*
Essa classe vai se tornar abstrata no futuro
*/
public abstract class Carta {
    
    private final String nome;
    private String descricao;
    private Faccao faccao;
    private Tabuleiro tab;
    private int fileira;
    private int pontuacao;
    
    
    /**
     * @deprecated Contrutor com fileira
     * @param nome Nome da carta
     * @param pontuacao Pontuação inicial da carta
     * @param fileira  Fileira da carta
     */
    public Carta (String nome, int pontuacao, int fileira){
        this.nome = nome;
    }
    
    /**
     * Cria um objeto carta com os parametros passados
     * @param nome Nome da carta
     * @param faccao Faccao da carta
     */
    protected Carta(String nome, Faccao faccao){
        this.nome = nome;
        this.faccao = faccao;
    }
    
    /**
     * Retorna o nome da carta
     * @return Nome da carta 
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Retorna o atributo fileira
     * @return o atributo fileira
     */
    public int getFileira(){
        return this.fileira;
    }
    
    /**
     * Modifica o atributo fileira
     * @param novaFileira nova identificação de fileira da carta
     */
    public void setFileira(int novaFileira){
        this.fileira = novaFileira;
    }
    
    /**
     * Modifica pontuação da carta
     * @param novaPontuacao
     */
    public void setPontuacao(int novaPontuacao){
        this.pontuacao = novaPontuacao;
    }
    
    /**
     * retorna a pontuação
     * @return a pontuação da carta
     */
    public int getPontuacao(){
        return this.pontuacao;
    }
    
    /**
     * Adiciona uma descricao a carta
     */
    public void setDescricao(String descricao){
       this.descricao = descricao; 
    }
    
    /**
     * Retorna se a carta é igual a comparada
     * @param carta Carta a ser comparada
     * @return True se for a mesma, False se diferente
     */
    public boolean eIgual(Carta carta){
        return this.nome.equals(carta.nome);
    }
    
    
    
    /**
     * Retorna o efeito da carta
     */
     public abstract void getEfeito(Efeito efeito);
    
    
    

    
    
    
   
    
}
