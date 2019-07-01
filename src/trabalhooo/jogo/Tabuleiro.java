/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhooo.jogo;

/**
 *
 * @author Lucas Molin <lucasmolin@ice.ufjf.br>
 */
public class Tabuleiro {
    private final Jogador jogadorUm;
    private final Jogador jogadorDois;
    private final Campo campoUm;
    //CartaClima cartaClima;
    private final Campo campoDois;
    //CartaClima cartaClima;
    
    public Tabuleiro(Jogador jogadorUm, Jogador jogadorDois, Jogo jogo){
        this.jogadorUm = jogadorUm;
        this.jogadorDois = jogadorDois;
        campoUm = new Campo(jogo);
        campoDois = new Campo(jogo);
    }
    
    /**
     * Retorna o Campo do jogadorUm
     * @return Campo do jogadorUm
     */
    public Campo getCampoUm(){
        return campoUm;
    }
    
    /**
     * Retorna o Campo do jogadorDois
     * @return Campo do jogadorDois
     */
    public Campo getCampoDois(){
        return campoDois;
    }
    
    /**
     * Retorna o campo do Jogador passado
     * @param jogador Jogador dono do Campo
     * @return Campo do Jogador
     */
    public Campo getCampoDoJogador(Jogador jogador){
        if(jogador.equals(jogadorUm)){
            return campoUm;
        } else if (jogador.equals(jogadorDois)){
            return campoDois;
        }
        return null; 
    }
    
    /**
     * 
     */
    public void setLider(){
        campoUm.setLider(jogadorUm.getLider());
        campoDois.setLider(jogadorDois.getLider());
    }
    
    
    
}
