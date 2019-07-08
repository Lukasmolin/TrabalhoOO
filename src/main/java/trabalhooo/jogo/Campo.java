/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhooo.jogo;

import java.util.ArrayList;
import java.util.List;
import trabalhooo.jogo.cartas.Carta;
import trabalhooo.jogo.cartas.CartaLider;

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
    
    private Jogo jogo;
    private Fileira[] campo;
    private List<Carta> cemiterio;
    private CartaLider lider;
    
    public Campo(Jogo jogo){
        this.jogo = jogo;
        inicializaFileiras();
    }
    
    /**
     * Metodo que instancia as fileiras contidas no array campo
     */
    private void inicializaFileiras(){
        cemiterio = new ArrayList<>();
        campo = new Fileira[3];
        for(int i = 0; i < campo.length; i++){
            campo[i] = new Fileira(jogo);
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
    
    
    /**
     * Adiciona carta
     * @param carta 
     */
    public void addCarta(Carta carta){
        
        switch (carta.getFileira()){
            case 1:
                campo[FILEIRA_ESPADACHINS].add(carta);
            break;
            
            case 2:
                campo[FILEIRA_ARQUEIROS].add(carta);
            break;
            
            case 3:
                campo[FILEIRA_BALISTAS].add(carta);
            break;
        }
    }
    
    /**
     * Retorna o cemiterio
     * @return cemiterio
     */
    public List<Carta> getCemiterio(){
        return this.cemiterio;
    }
    
    /**
     * Seta a carta lider
     * @param carta
     */
    public void setLider (Carta carta){
        if(carta instanceof CartaLider){
            this.lider = (CartaLider)carta;
        }        
    }
    
    /**
     * Retorna as fileiras do campo
     * @param fileira desejada
     * @return fileira escolhida ou null caso não exista
     */
    public Fileira getFileira(int fileira){        
        if (fileira==1){
            return this.campo[0];
        } else if (fileira==2){
            return this.campo[1];
        } else if (fileira==3){
            return this.campo[2];
        }
        return null;
    }
    
    /**
     * Verifica se CartaLider foi usada
     * @param carta
     * @return 
     */
    public boolean verificaUsoLider(CartaLider carta){
        return carta.getUsada();
    }

    public Fileira getFileiraParaTestes(int fileira){
        return campo[fileira];
    }

    /**
     * Limpa todas as cartas de um campo
     * @throws Exception se a carta não existir ou se a carta for null
     */
    public void limpaCampo() throws Exception{
        for(Fileira f : campo){
            for(Carta c : f.getCartas()){
                cemiterio.add(f.queimaCarta(c));
            }
        }
    }

    public int getPontuacaoEspadachins(){
        return campo[FILEIRA_ESPADACHINS].getPontuacao();
    }
    
    public int getPontuacaoArqueiros(){
        return campo[FILEIRA_ARQUEIROS].getPontuacao();
    }
    
    public int getPontuacaoBalistas(){
        return campo[FILEIRA_BALISTAS].getPontuacao();
    }
}
