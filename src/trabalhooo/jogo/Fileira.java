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
//import trabalhooo.jogo.cartas.Efeito;

/**
 *
 * @author Lucas Molin <lucasmolin@ice.ufjf.br>
 */
public class Fileira {
    /**
     *Lista de Cartas na fileira
     */
    private List<Carta> fileira = new ArrayList<>();
    private int pontuacao = 0;
    private boolean temClima = false;
    private Jogo jogo;

    public Fileira(Jogo jogo){
        this.jogo = jogo;
    }
    
    /**
     * Adiciona carta a esta fileira
     * @param carta a ser adicionada
     */
    public void add(Carta carta){
        //carta.getEfeito(new Efeito(jogo));
        fileira.add(carta);
        atualizaPontuacao();
    }
    
    /**
     * Retorna uma cópia das cartas contidas na fileir
     * @return array cópia de Carta contida na fileira
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
        if (this.temClima==true){
            return this.fileira.size();
        }
        System.out.println("Pontuacao:");
        return this.pontuacao;
    }
    
    /**
     * Queima uma carta na fileira
     * @param carta Carta a ser queimada
     * @return Carta que foi queimada
     * @throws Exception se a carta não existir ou se a carta for null
     */
    public Carta queimaCarta(Carta carta) throws Exception{
        if(carta == null) { throw new Exception("Carta inválida: Null!"); }
        if(!fileira.remove(carta)) { throw new Exception("Carta não existente na fileira!"); }
        atualizaPontuacao();
        return carta;
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
    
    /**
     * Mata todas as cartas da fileira e as retorna. A Fileira ficará vazia.
     * @return Array de carta com as cartas mortas retiradas da fileira
     */
    public Carta[] finalizaRodada(){
        Carta[] mortas = getCartas();
        fileira.clear();
        return mortas;
    }
    
    /**
     * Retorna o metodo size() da List interna que representa a fileira
     * @return Quantidade de carta na fileira, zero se vazia
     */
    public int quantidadeCartas(){
        return fileira.size();
    }
    
    /**
     * Coloca carta especiais, como cartas de Clima e Commander's Horn ao lado da fileira;
     * @param carta 
     */
    public void setEspecial(Carta carta){
        //this.especial = carta;
    }
    
    public void setClima(boolean b){
        this.temClima = b;
    }
}
