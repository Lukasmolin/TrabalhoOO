/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhooo;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import trabalhooo.jogo.*;
import trabalhooo.jogo.cartas.Carta;
import trabalhooo.jogo.Tabuleiro;
import trabalhooo.jogo.cartas.Faccao;

/**
 *
 * @author izabe
 */
public class TrabalhoOO {
    
    
    
    public static void main(String[] args) {
       Jogador p1 = new Jogador("Jose");
       Jogador p2 = new Jogador("Maria"); 

       Jogo novoJogo = new Jogo (p1,p2);
       
       novoJogo.jogadorInicial();
       
       novoJogo.Jogo(novoJogo);
       
       System.out.println(novoJogo.jogadorInicial().getNome());
       
       novoJogo.setFaccaoJogadorUm(Faccao.MONSTROS);
       novoJogo.setFaccaoJogadorDois(Faccao.NILFGAARD);
       
       System.out.println(p1.getNome());
       
       for(int i=0; i<p1.getMao().length;i++){
           System.out.println("");
           System.out.println("| "+p1.getMao()[i].getNome()+" |");
       }
       
    }

}
