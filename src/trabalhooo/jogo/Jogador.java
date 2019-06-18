/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhooo.jogo;

import java.util.ArrayList;
import java.util.List;
import trabalhooo.jogo.cartas.Baralho;
import trabalhooo.jogo.cartas.Carta;
import trabalhooo.jogo.cartas.Faccao;

/**
 *
 * @author izabe
 * @author Lucas Molin <lucasmolin@ice.ufjf.br>
 */
public class Jogador {
    
    private String nome;
    private Baralho baralho;
    private List<Carta> mao;
    private int vidas = 3;
    
    /**
     * Contrutor do Jogador
     * @param nome Nome do jogador
     */
    public Jogador(String nome){
        this.nome = nome;
    }
    
    /**
     * Setar o nome do Jogador
     * @param nome nome a ser setado
     */
    public void setNome(String nome){
        this.nome = nome;
    }
    
    /**
     * Retorna o nome do Jogador
     * @return o nome do Jogador
     */
    public String getNome(){
        return this.nome;
    }
    
    /**
     * Retorna as vidas do Jogador
     * @return Quantidade de vidas
     */
    public int GetVidas(){
        return this.vidas;
    }
    
    /**
     * Inicia o baralho com a Faccção escolhida
     * @param faccao Facção escolhida
     * @throws Exception se já tiver pedido as cartas iniciais
     */
    public void setBaralho(Faccao faccao) throws Exception{
       //Inicia o baralho com a facção
       baralho = new Baralho(faccao);
       //Retira as 10 primeiras cartas e passa para mão
       mao = new ArrayList<>();
       mao.addAll(java.util.Arrays.asList(baralho.getCartasIniciais()));
    }
    
    /**
     * Reduz em 1 a vida do Jogador
     * @return true se o jogador ainda tiver vidas, false senão
     * @throws Exception se o jogador já tiver zero vidas
     */
    public boolean perdeVida() throws Exception{
        if(this.vidas == 0) {
            throw new Exception("Jogador não pode perder mais vidas pois já tem zero vidas.");
        }
        
        this.vidas--;
        return (vidas > 0);
    }
    
    /**
     * Retorna mão atual do jogador
     * @return Array de Cartas com as cartas na mão do jogador
     */
    public Carta[] getMao(){
        Carta[] retornoMao = new Carta[mao.size()];
        retornoMao = mao.toArray(retornoMao);
        return retornoMao;
    }
    
    /**
     * Joga uma carta especificada
     * @param carta Carta a ser jogada
     * @return a Carta se a jogada foi feita, null se o jogador nao possuir a carta na mao
     */
    public Carta jogaCarta(Carta carta){
        if(mao.remove(carta))
            return carta;
        else
            return null;
    }
}