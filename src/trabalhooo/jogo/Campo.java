/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhooo.jogo;

import java.util.ArrayList;
import java.util.List;
import trabalhooo.jogo.cartas.Carta;

/**
 *
 * @author Lucas Molin <lucasmolin@ice.ufjf.br>
 */
public class Campo {
    /*
        Constantes usadas para acessar o array de Fileiras
     */
    private static final byte FILEIRA_ESPADACHINS = 0;
    private static final byte FILEIRA_ARQUEIROS = 1;
    private static final byte FILEIRA_BALISTAS = 2;
    
    private Fileira[] campo;
    private List<Carta> cemiterio;    
    
    public Campo(){
        inicializaFileiras();
    }
    
    /**
     * Metodo que instancia as fileiras contidas no array campo
     */
    private void inicializaFileiras(){
        cemiterio = new ArrayList<>();
        campo = new Fileira[3];
        for(Fileira f : campo){
            f = new Fileira();
        }
    }
    
    /**
     * Retorna uma cópia das cartas contidas na fileira
     * @return array cópia das cartas contidas na fileira
     */
    public Carta[] getFileiraEspadachins(){
        return campo[FILEIRA_ESPADACHINS].getCartas();
    }
    
    /**
     * Retorna uma cópia das cartas contidas na fileira
     * @return array cópia das cartas contidas na fileira
     */
    public Carta[] getFileiraArqueiros(){
        return campo[FILEIRA_ARQUEIROS].getCartas();
    }
    
    /**
     * Retorna uma cópia das cartas contidas na fileira
     * @return array cópia das cartas contidas na fileira
     */
    public Carta[] getFileiraBalistas(){
        return campo[FILEIRA_BALISTAS].getCartas();
    }
    
    /**
     * Retorna a pontuação geral do jogador do campo
     * @return Soma da pontuação das fileiras
     */
    public int getPontuacaoGeral(){
        int pontuacao = 0;
        for(Fileira f : campo){
            pontuacao += f.getPontuacao();
        }
        return pontuacao;
    }
}
