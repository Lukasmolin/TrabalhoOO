/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhooo;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author izabe
 */
public class Jogador {
    
    String nome;
    Random x = new Random();
    private ArrayList<Carta> fileira1 = new ArrayList<> ();
    private ArrayList<Carta> fileira2 = new ArrayList<> ();
    private ArrayList<Carta> fileira3 = new ArrayList<> ();
    private ArrayList<Carta> deck = new ArrayList<> ();
    private int pontuação;
    private int vidas = 3;
    
    public void MontaDeck( ){
        Baralho b = new Baralho();
        int y;
        for (int i=0; i<10; i++){
            y = x.nextInt(b.getMonstros().size());
            deck.add(b.getMonstros().get(y));
            b.getMonstros().remove(y);
        }
    }
    
    
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
    /**
     * @return the fileira1
     */
    public ArrayList<Carta> getFileira1() {
        return fileira1;
    }

    /**
     * @param fileira1 the fileira1 to set
     */
    public void setFileira1(ArrayList<Carta> fileira1) {
        this.fileira1 = fileira1;
    }

    /**
     * @return the fileira2
     */
    public ArrayList<Carta> getFileira2() {
        return fileira2;
    }

    /**
     * @param fileira2 the fileira2 to set
     */
    public void setFileira2(ArrayList<Carta> fileira2) {
        this.fileira2 = fileira2;
    }

    /**
     * @return the fileira3
     */
    public ArrayList<Carta> getFileira3() {
        return fileira3;
    }

    /**
     * @param fileira3 the fileira3 to set
     */
    public void setFileira3(ArrayList<Carta> fileira3) {
        this.fileira3 = fileira3;
    }

    /**
     * @return the deck
     */
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
