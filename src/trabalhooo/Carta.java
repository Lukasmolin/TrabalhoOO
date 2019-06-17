/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhooo;

/**
 *
 * @author izabe
 */
public class Carta {
    
    
    private final String nome;
    private int pontuação;
    private int fileira;
    
    
    public Carta (String nome, int pontuação, int fileira){
        this.nome= nome;
        this.pontuação = pontuação;
        this.fileira = fileira;
    }
    
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the pontuação
     */
    public int getPontuação() {
        return pontuação;
    }

    /**
     * @param pontuação the pontuação to set
     */
    public void setPontuação(int pontuação) {
        this.pontuação = pontuação;
    }

    /**
     * @return the fileira
     */
    public int getFileira() {
        return fileira;
    }

    /**
     * @param fileira the fileira to set
     */
    public void setFileira(int fileira) {
        this.fileira = fileira;
    }
    
    
    

    
    
    
   
    
}
