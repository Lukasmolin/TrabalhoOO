/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhooo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author izabe
 */
public class TrabalhoOO {
    
    //verifica quem venceu ou se empatou
    public static Jogador verificaVencedor(Jogador p1, Jogador p2){
        if (p1.getPontuação()>p2.getPontuação()){
            p2.setVidas(p2.GetVidas()-1);
            return p1;
        }
        else if (p2.getPontuação() > p1.getPontuação()){
            p1.setVidas(p1.GetVidas()-1);
            return p2;
        }
        else{
            p1.setVidas(p1.GetVidas()-1);
            p2.setVidas(p2.GetVidas()-1);
            return null;
        }    
    }
    
    // adiciona uma carta
    public static void jogaCarta(Jogador jogador){
        
        Scanner teclado = new Scanner(System.in);
        int escolha;
        Carta escolhida;
        
        System.out.println("Qual carta: ");
                 for( int i=0; i< jogador.getDeck().size(); i++){
                       System.out.println("["+i+"] "+jogador.getDeck().get(i).getNome());
                }
                escolha = teclado.nextInt();
                escolhida = jogador.getDeck().get(escolha);
                if (jogador.getDeck().get(escolha).getFileira()== 1){
                    jogador.getFileira1().add(escolhida);
                }
                else if(jogador.getDeck().get(escolha).getFileira()== 2){
                    jogador.getFileira2().add(escolhida);
                }
                else if(jogador.getDeck().get(escolha).getFileira()== 3){
                    jogador.getFileira3().add(escolhida);
                }
            //atualiza a pontuação do jogador
            jogador.setPontuação(jogador.getPontuação()+ escolhida.getPontuação());
            //remove do deck a carta adicionada
            jogador.getDeck().remove(escolha);
    }
    
    // mostra as fileiras do jogador passado como parâmetro
    public static void mostraFileiras (Jogador jogador){
        
        for(int i=0; i<jogador.getFileira1().size();i++){
                       System.out.println("["+1+"] "+jogador.getFileira1().get(i).getNome());
                       
                }
                
                       System.out.println("\n>>>>>>>>>>>>>>>>===============<<<<<<<<<<<<<<<");
                       
                for(int i=0; i<jogador.getFileira2().size();i++){
                       System.out.println("["+2+"] "+jogador.getFileira2().get(i).getNome());
                }
                
                       System.out.println("\n>>>>>>>>>>>>>>>>===============<<<<<<<<<<<<<<<");
                       
                for(int i=0; i<jogador.getFileira3().size();i++){
                       System.out.println("["+3+"] "+jogador.getFileira3().get(i).getNome());
                
                }
    }
    
    public static int joga(Jogador jogador){
        Scanner teclado = new Scanner(System.in);
        int opcao;
        ArrayList<String> opcoes = new ArrayList<> ();
        
        opcoes.add("[1] Jogar Carta");
        opcoes.add("[2] Passar");
        opcoes.add("[3] Mostrar Fileiras");
        opcoes.add("[0] Desistir");
        
        do{
            System.out.println(jogador.getNome()+", escolha uma opcao: ");
            for (int i=0; i<opcoes.size(); i++){
                System.out.println(opcoes.get(i));
            }
            opcao = teclado.nextInt();
            if (opcao==0){
                //encerra a partida retornando 0 para a main
                return opcao;
            }
            if (opcao==1){
                jogaCarta(jogador);
                System.out.println("Pontuação do jogador "+jogador.getNome()+": "+jogador.getPontuação());
                System.out.println("Vidas do jogador "+jogador.getNome()+": "+jogador.GetVidas());
                return -1;
            }
            if (opcao==2){
                //encerra a jogada passando para o outro
                return opcao;
            }
            if (opcao==3){
                mostraFileiras(jogador);
            }
        
        }while (opcao!=0 || opcao!=2);
        
        System.out.println("Pontuação do jogador: "+jogador.getPontuação());
        System.out.println("Vidas do jogador: "+jogador.GetVidas());
        
        return opcao;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Jogador p1= new Jogador();
        p1.setNome("P1");
        Jogador p2= new Jogador();
        p2.setNome("P2");
        
        p1.MontaDeck();
        p2.MontaDeck();
        
        int opcao=-1;
        Jogador vencedor = null;
        
         while (p1.GetVidas()>0 && p2.GetVidas()>0 && opcao!=0){
           
            opcao = joga(p1);
                           
            if (opcao==0){ 
                vencedor = p2;
                break;
            }
            if (opcao!=0){
                opcao = joga(p2);
           
                if (opcao==0){
                    vencedor = p1;
                    break;  
                 }
            
            }
            
            vencedor = verificaVencedor(p1,p2);
        }
        
        if (vencedor==p1){
            System.out.println("Jogador 1 venceu!");
        }
        else if (vencedor==p2){
             System.out.println("Jogador 2 venceu!");
        }
        else if (vencedor == null){
            System.out.println("Empate!");
            
        }
            
        
        
    }
    
}
