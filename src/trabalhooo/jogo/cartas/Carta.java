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
/*
Essa classe vai se tornar abstrata no futuro
*/
public abstract class Carta {
    
    private final String nome;
    private Faccao faccao;
    
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
     * Retorna se a carta é igual a comparada
     * @param carta Carta a ser comparada
     * @return True se for a mesma, False se diferente
     */
    public boolean eIgual(Carta carta){
        return this.nome.equals(carta.nome);
    }
    
    /**
     * Retorna o efeito da carta
     * @return o efeito da carta
     */
     public abstract Efeito getEfeito();
    
    
    

    
    
    
   
    
}
