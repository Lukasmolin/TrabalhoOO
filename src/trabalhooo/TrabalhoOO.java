/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhooo;

import java.util.ArrayList;
import java.util.List;
import trabalhooo.jogo.*;
import trabalhooo.jogo.cartas.Faccao;
import trabalhooo.jogo.cartas.Carta;

/**
 *
 * @author izabe
 */
public class TrabalhoOO {
    
    public static void main(String[] args) {
        Jogo j = new Jogo("Zé", "Maria");
        j.setFaccaoJogadorUm(Faccao.MONSTROS);
        j.setFaccaoJogadorDois(Faccao.MONSTROS);
        if(j.estaPronto()){
            imprimeMao(j.getMaoJogadorUm(), j.getNomeJogadorUm());
            imprimeMao(j.getMaoJogadorDois(), j.getNomeJogadorDois());
        }
    }
    
    public static void imprimeCampo(Carta[][] campo){
        System.out.println("################################");
        for(Carta[] fileira : campo){
            System.out.println("---------------------------");
            imprimeFileira(fileira);
            System.out.println("---------------------------");
        }
        System.out.println("################################");
    }
    
    public static void imprimeFileira(Carta[] fileira){
        for(Carta carta : fileira){
            System.out.print("| "+ carta.getNome() +" |");
        }
    }
    
    public static void imprimeMao(Carta[] cartas, String nomeJogador){
        System.out.println("################################");
        System.out.println("JOGADOR: " + nomeJogador);
        for(Carta carta : cartas){
            System.out.print("| "+ carta.getNome() +" |");
        }
        System.out.println();
        System.out.println("################################");
    }
    
}
