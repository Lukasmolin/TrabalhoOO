/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhooo.jogo;

import java.util.ArrayList;
import java.util.Random;
import trabalhooo.jogo.cartas.Baralho;
import trabalhooo.jogo.cartas.Carta;

/**
 *
 * @author izabe
 */
public class Jogador {
    
    String nome;
    Random x = new Random();
    private Baralho baralho;
    private ArrayList<Carta> deck = new ArrayList<> ();
    private int pontuação;
    private int vidas = 3;    
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public int GetVidas(){
        return this.vidas;
    }
    
    public void setVidas (int v){
        this.vidas = v;
    }
   
    public ArrayList<Carta> getDeck() {
        return deck;
    }

    /**
     * @param deck the deck to set
     */
    public void setDeck(ArrayList<Carta> deck) {
        this.deck = deck;
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
    
    
    
}
