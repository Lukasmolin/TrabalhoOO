/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhooo.jogo;

import trabalhooo.jogo.cartas.*;

/**
 *
 * @author Lucas Molin <lucasmolin@ice.ufjf.br>
 */
public class Jogo {
    private boolean pronto = false;
    private Jogador jogadorUm, jogadorDois;
    private Tabuleiro tabuleiro;
    
    /**
     * 
     * @param nomeJogadorUm Nome do primeiro jogador
     * @param nomeJogadorDois Nome do segundo jogador
     */
    public Jogo(String nomeJogadorUm, String nomeJogadorDois){
        jogadorUm = new Jogador(nomeJogadorUm);
        jogadorDois = new Jogador(nomeJogadorDois);
        tabuleiro = new Tabuleiro(jogadorUm, jogadorDois);
    }
    
    /**
     * Retorna o nome do Jogador
     * @return Nome do jogador
     */
    public String getNomeJogadorUm(){
        return jogadorUm.getNome();
    }
    
    /**
     * Retorna o nome do Jogador
     * @return Nome do jogador
     */
    public String getNomeJogadorDois(){
        return jogadorDois.getNome();
    }
    
    /**
     * Escolhe a facção do Jogador Um
     * @param faccao Facção selecionada pelo jogador
     */
    public void setFaccaoJogadorUm(Faccao faccao){
        try {       
            jogadorUm.setBaralho(faccao);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Escolhe a facção do Jogador Dois
     * @param faccao Facção selecionada pelo jogador
     */
    public void setFaccaoJogadorDois(Faccao faccao){
        try {       
            jogadorDois.setBaralho(faccao);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Retorna um array de cartas na mão do Jogador um
     * @return Array de Carta na ão do jogador
     */
    public Carta[] getMaoJogadorUm(){
        try {
            return jogadorUm.getMao();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    /**
     * Retorna um array de cartas na mão do Jogador dois
     * @return Array de Carta na ão do jogador
     */
    public Carta[] getMaoJogadorDois(){
        try {
            return jogadorDois.getMao();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    /**
     * Retorna se ambos os jogadores estão prontos pra começar pelo metodo estaPronto
     * @return True se estaPronto for verdadeiro pra ambos Jogadores, false senão
     */
    public boolean estaPronto(){
        return this.jogadorUm.estaPronto() && this.jogadorDois.estaPronto();
    }
    
    
}
