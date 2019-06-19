/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhooo.jogo;

import trabalhooo.jogo.cartas.Carta;

/**
 *
 * @author Lucas Molin <lucasmolin@ice.ufjf.br>
 */
public class Tabuleiro {
    private Jogador jogadorUm, jogadorDois;
    private Campo campoUm, campoDois;
    //CartaClima cartaClima;
    
    public Tabuleiro(Jogador jogadorUm, Jogador jogadorDois){
        this.jogadorUm = jogadorUm;
        this.jogadorDois = jogadorDois;
        campoUm = new Campo();
        campoDois = new Campo();
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
     * @throws Exception se o Jogador não for igual a nenhum dos dois jogadores
     */
    public Campo getCampoDoJogador(Jogador jogador) throws Exception{
        if(jogador.equals(jogadorUm)){
            return campoUm;
        } else if (jogador.equals(jogadorDois)){
            return campoDois;
        }
        throw new Exception("Jogador Inválido!!!");
    }
}
