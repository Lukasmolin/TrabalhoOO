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

        try {
            Jogador p1 = new Jogador("Jose");
            Jogador p2 = new Jogador("Maria");
            
            Jogo novoJogo = new Jogo (p1,p2);
            
            novoJogo.setFaccaoJogadorUm(Faccao.MONSTROS);
            novoJogo.setFaccaoJogadorDois(Faccao.NILFGAARD);
            
            novoJogo.jogadorInicial();
            
            novoJogo.Jogo(novoJogo);
            
            System.out.println("Vencedor é "+novoJogo.getVencedor());
        } catch (Exception ex) {
            Logger.getLogger(TrabalhoOO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }
       
    }


