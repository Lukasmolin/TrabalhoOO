/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhooo.jogo;

import java.util.ArrayList;
import java.util.List;
import trabalhooo.jogo.cartas.Carta;
import trabalhooo.jogo.cartas.CartaPontuada;

/**
 *
 * @author Lucas Molin <lucasmolin@ice.ufjf.br>
 */
public class Fileira {
    /**
     *Lista de Cartas na fileira
     */
    private List<Carta> fileira;
    private int pontuacao;
    
    public Fileira(){
        fileira = new ArrayList<>();
    }
    
    /**
     * Adiciona carta a esta fileira
     * @param carta a ser adicionada
     */
    public void add(Carta carta){
        fileira.add(carta);
        atualizaPontuacao();
    }
    
    /**
     * Retorna as cartas contidas na fileira
     * @return array de Carta contida na fileira
     */
    public Carta[] getCartas(){
        Carta[] c = new Carta[fileira.size()];
        return fileira.toArray(c);
    }
    
    /**
     * Retorna a pontuação da fileira
     * @return pontuação total da fileira
     */
    public int getPontuacao(){
        return this.pontuacao;
    }
    
    /**
     * Itera pelas cartas e se for CartaPontuada soma a pontuacao
     */
    private void atualizaPontuacao(){
        pontuacao = 0;
        for(Carta c : fileira){
            if(c instanceof CartaPontuada){
                pontuacao += ((CartaPontuada)c).getPontuacao();
            }
        }
    }
}
