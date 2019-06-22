/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhooo.jogo.cartas;
import trabalhooo.jogo.Tabuleiro;
import trabalhooo.jogo.Jogo;
import java.util.List;

/**
 *
 * @author Lucas Molin <lucasmolin@ice.ufjf.br>
 */
public class Efeito {
    
    private Tabuleiro tab;
    private Jogo j;
    
   /**
    * Implementa efeito da Classe CartaEloForte
    * @param carta carta a ser jogada
    */
    public void cartaEloForte(Carta carta){
        
        tab.getCampoDoJogador(j.getJogadorAtual()).addCarta(carta);
        if (carta.getFileira()==1){
             Carta[] c = tab.getCampoDoJogador(j.getJogadorAtual()).getFileiraEspadachins();
             for (int i=0; i<c.length; i++){
                if(c[i].eIgual(carta)){
                 c[i].setPontuacao(c[i].getPontuacao()*2);
                }
             }
        }
        else if(carta.getFileira()==2){
            Carta[] c = tab.getCampoDoJogador(j.getJogadorAtual()).getFileiraArqueiros();
            
            for (int i=0; i<c.length; i++){
                if(c[i].eIgual(carta)){
                 c[i].setPontuacao(c[i].getPontuacao()*2);
                }
             }
        }
        else if(carta.getFileira()==3){
            Carta[] c = tab.getCampoDoJogador(j.getJogadorAtual()).getFileiraBalistas();
            
            for (int i=0; i<c.length; i++){
                if(c[i].eIgual(carta)){
                 c[i].setPontuacao(c[i].getPontuacao()*2);
                }
             }
            
        }
    }
    
    /**
     * Implementa efeito da Carta Espião
     * @param carta 
     */
    public void CartaEspiao(Carta carta){
        
        tab.getCampoDoJogador(j.getJogadorEmEspera()).addCarta(carta);
        int cont=0;
        boolean escolhe = false;
        List<Carta> b = j.getJogadorAtual().getBaralho().getBaralho();
        
        do{
            for (int i=0; i<b.size();i++){
                b.get(i);
                if( escolhe==true){
                    cont++;
                }
                tab.getCampoDoJogador(j.getJogadorAtual()).addCarta(b.get(i));
            }
        } while (cont<3);
    }
    
    /**
     * Implemeta efeito da Carta Médico
     */
    public void CartaMedico(Carta carta){
       tab.getCampoDoJogador(j.getJogadorAtual()).addCarta(carta);
       
       List<Carta> c = tab.getCampoDoJogador(j.getJogadorAtual()).getCemiterio();
       boolean escolhe=false;
       for (int i=0; i<c.size(); i++){
           c.get(i);
           if (escolhe==true){
               tab.getCampoDoJogador(j.getJogadorAtual()).addCarta(c.get(i));
           }
       }
    }
}

    
