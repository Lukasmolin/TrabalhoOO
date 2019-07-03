/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhooo;

import java.util.logging.Level;
import java.util.logging.Logger;

import trabalhooo.controller.Controller;
import trabalhooo.jogo.Campo;
import trabalhooo.jogo.Fileira;
import trabalhooo.jogo.Jogador;
import trabalhooo.jogo.cartas.Carta;
/**
 *
 * @author izabe
 */
public class TrabalhoOO {

    public static void main(String[] args) {
        try {
           Controller c = new Controller();
           c.inicia();
           
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    static void testaJogador(Jogador j){
        System.out.println("Vidas: "+j.GetVidas());
        System.out.println("Nome: "+j.getNome());
        System.out.println("EstaPronto: "+j.estaPronto());
        System.out.println("GetLider: "+j.getLider());
        System.out.println("GetFaccao: "+j.getFaccao());
        
        System.out.println("#############################################");
        leCartas(j.getMao());
        
    }

    static void leCartas(Carta[] c){
        for(Carta car: c){
            imprimeCarta(car);
        }
    }

    static void imprimeCarta(Carta c){
        System.out.println("Carta: "+c.getNome()+" Pontuacao: "+c.getPontuacao());
    }

    static void testaCampo(Campo c){
        System.out.println(c.getPontuacaoGeral());
        leCartas(c.getFileiraArqueiros());
        leCartas(c.getFileiraBalistas());
        leCartas(c.getFileiraEspadachins());

    }

    static void testaFileira(Fileira f){
        System.out.println(f.getPontuacao());
    }
}


