/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhooo.jogo.cartas;
import trabalhooo.jogo.Tabuleiro;
import trabalhooo.jogo.Jogo;
import java.util.List;
import trabalhooo.jogo.Campo;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                
        if (carta.getFileira()==1){
             Carta[] c = tab.getCampoDoJogador(j.getJogadorAtual()).getFileiraEspadachins();
             for (int i=0; i<c.length; i++){
                if(c[i].eIgual(carta) && c[i] instanceof CartaHeroi == false){
                 c[i].setPontuacao(c[i].getPontuacao()*2);
                }
             }
        }
        else if(carta.getFileira()==2){
            Carta[] c = tab.getCampoDoJogador(j.getJogadorAtual()).getFileiraArqueiros();
            
            for (int i=0; i<c.length; i++){
                if(c[i].eIgual(carta) && c[i] instanceof CartaHeroi == false){
                 c[i].setPontuacao(c[i].getPontuacao()*2);
                }
             }
        }
        else if(carta.getFileira()==3){
            Carta[] c = tab.getCampoDoJogador(j.getJogadorAtual()).getFileiraBalistas();
            
            for (int i=0; i<c.length; i++){
                if(c[i].eIgual(carta) && c[i] instanceof CartaHeroi == false){
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
     * @param carta
     */
    public void CartaMedico(Carta carta){
              
       List<Carta> c = tab.getCampoDoJogador(j.getJogadorAtual()).getCemiterio();
       boolean escolhe=false;
       for (int i=0; i<c.size(); i++){
           c.get(i);
           if (escolhe==true){
               tab.getCampoDoJogador(j.getJogadorAtual()).addCarta(c.get(i));
           }
       }
    }
    
    /**
     * Implementa efeito da Carta Ágil
     * @param carta
     */
    public void CartaAgil(Carta carta){
        Scanner teclado = new Scanner(System.in);
        int escolha;
        escolha = teclado.nextInt();
        if (escolha==1){
            carta.setFileira(escolha);
        }
        else 
            carta.setFileira(escolha);
    }
    
    /**
     * Implementa efeito da Carta Coragem
     * @param carta
     */
    public void CartaCoragem(Carta carta){
        try {
                        
            List<Carta> baralho = j.getJogadorAtual().getBaralho().getBaralho();
            Carta[] mao = j.getJogadorAtual().getMao();
            
            for (int i=0; i<mao.length; i++){
                if (mao[i].getTipo() == carta.getTipo()){
                    tab.getCampoDoJogador(j.getJogadorAtual()).addCarta(mao[i]);
                }
            }
            
            for(int i=0; i < baralho.size(); i++){
                if (baralho.get(i).getTipo() == carta.getTipo()){
                    tab.getCampoDoJogador(j.getJogadorAtual()).addCarta(baralho.get(i));
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(Efeito.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * 
     * @param carta
     */
    public void CartaAumentoMoral(Carta carta){
        
        Scanner teclado = new Scanner(System.in);
        int fileira;
        fileira = teclado.nextInt();
        
        switch (fileira){
            case 1:
                Carta[] ce = tab.getCampoDoJogador(j.getJogadorAtual()).getFileiraEspadachins();
                for (int i=0; i<ce.length; i++){
                    if (ce[i] instanceof CartaHeroi){
                        i++;
                    }
                    ce[i].setPontuacao(ce[i].getPontuacao()*2);
                 }
            break;
            
            case 2:
                Carta[] ca = tab.getCampoDoJogador(j.getJogadorAtual()).getFileiraArqueiros();
                for (int i=0; i<ca.length; i++){
                    if (ca[i] instanceof CartaHeroi){
                        i++;
                    }
                    ca[i].setPontuacao(ca[i].getPontuacao()*2);
                 }
            break;
            
            case 3:
                Carta[] c = tab.getCampoDoJogador(j.getJogadorAtual()).getFileiraBalistas();
                for (int i=0; i<c.length; i++){
                    if (c[i] instanceof CartaHeroi){
                        i++;
                    }
                    c[i].setPontuacao(c[i].getPontuacao()*2);
                 }
            break;
        }
    }
    
    /**
     * Implementa efeito das cartas do tipo Queima
     * @param carta
     */
    public void CartaQueima(Carta carta) {
        try {
            Campo c = tab.getCampoDoJogador(j.getJogadorEmEspera());
            
            Carta maiorPontuacao = c.getFileiraArqueiros()[0];
            
            for (int i=0; i<c.getFileiraArqueiros().length;i++){
                if (c.getFileiraArqueiros()[i].getPontuacao() >= maiorPontuacao.getPontuacao()){
                    maiorPontuacao = c.getFileiraArqueiros()[i];
                }
            }
            for (int i=0; i<c.getFileiraEspadachins().length;i++){
                if (c.getFileiraEspadachins()[i].getPontuacao() >= maiorPontuacao.getPontuacao()){
                    maiorPontuacao = c.getFileiraEspadachins()[i];
                }
            }
            for (int i=0; i<c.getFileiraBalistas().length;i++){
                if (c.getFileiraBalistas()[i].getPontuacao() >= maiorPontuacao.getPontuacao()){
                    maiorPontuacao = c.getFileiraBalistas()[i];
                }
            }
            
            switch (maiorPontuacao.getFileira()){
                case 1:
                    c.getFileira(1).queimaCarta(carta);
                break;
                
                case 2:
                    c.getFileira(2).queimaCarta(carta);
                break;
                
                case 3:
                    c.getFileira(3).queimaCarta(carta);
                break;
            }
        } catch (Exception ex) {
            Logger.getLogger(Efeito.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Implementa efeito das cartas do tipo Lider
     * @param carta
     */
    public void CartaLider(CartaLider carta){
        
        if (carta.getUsada()==true){
            System.out.println("Carta já foi usada!");
        }
        else {
            try {
                Scanner teclado = new Scanner(System.in);
                boolean escolha;
                
                carta.setUsada(true);
                
                Carta[] mao = j.getJogadorAtual().getMao();
                List<Carta> cemiterio = tab.getCampoDoJogador(j.getJogadorEmEspera()).getCemiterio();
                
                
                switch (carta.getId()){
                    case 001:
                        for (int i=0; i<mao.length;i++){
                            if (mao[i] instanceof CartaClima){
                                tab.getCampoUm().addCarta(mao[i]);
                                tab.getCampoDois().addCarta(mao[i]);
                            }
                        }
                        break;
                        
                    case 002:
                        for (int i=0; i<cemiterio.size();i++){
                            cemiterio.get(i);
                            escolha = teclado.nextBoolean();
                            if (escolha == true){
                                tab.getCampoDoJogador(j.getJogadorAtual()).addCarta(cemiterio.get(i));
                            }
                        }
                        break;
                        
                    case 003:
                        Carta[] c = tab.getCampoDoJogador(j.getJogadorAtual()).getFileiraBalistas();
                        
                        for (int i=0; i<c.length; i++){
                            if(c[i].eIgual(carta) && c[i] instanceof CartaHeroi == false){
                                c[i].setPontuacao(c[i].getPontuacao()*2);
                            }
                        }
                        break;
                        
                    case 004:
                        List<Carta> baralho = j.getJogadorAtual().getBaralho().getBaralho();
                        mao[mao.length] = baralho.get(0);
                        break;
                }
            } catch (Exception ex) {
                Logger.getLogger(Efeito.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * Implementa o efeito de CartaClima
     * @param carta 
     */
    public void CartaClima (Carta carta){
        switch (carta.getFileira()){
            case 1:
                tab.getCampoUm().getFileira(0).setClima(true);
                tab.getCampoDois().getFileira(0).setClima(true);
            break;
            
            case 2:
                tab.getCampoUm().getFileira(1).setClima(true);
                tab.getCampoDois().getFileira(1).setClima(true);
            break;
            
            case 3:
                tab.getCampoUm().getFileira(2).setClima(true);
                tab.getCampoDois().getFileira(2).setClima(true);
            break;
            
            case 4:
               for (int i=0; i<3;i++){
                   tab.getCampoUm().getFileira(i).setClima(false);
                   tab.getCampoDois().getFileira(i).setClima(false);
               }
            break;
        }
    }
    
    public void CartaEspecial(CartaEspecial carta){
        
        Scanner teclado = new Scanner(System.in);
        boolean escolha=false;
        int novafileira;
        
        //nova fileira informada pelo usuario.
        novafileira = teclado.nextInt();
        carta.setFileira(novafileira);
        
        Carta[] f;        
        if (carta.getFileira()==1){
                    f = tab.getCampoDoJogador(j.getJogadorAtual()).getFileiraEspadachins();
                }
                else if (carta.getFileira()==2){
                    f = tab.getCampoDoJogador(j.getJogadorAtual()).getFileiraArqueiros();
                } else {
                    f = tab.getCampoDoJogador(j.getJogadorAtual()).getFileiraBalistas();
                }
        
        switch (carta.getId()){
            case 004:
                for (int i=0; i<f.length;i++){
                   if (escolha==true){
                       try {
                           j.getJogadorAtual().getMao()[j.getJogadorAtual().getMao().length] = f[i];
                           f[i]=carta;
                       } catch (Exception ex) {
                           Logger.getLogger(Efeito.class.getName()).log(Level.SEVERE, null, ex);
                       }
                   } 
                }
            break;
            
            case 005:
                this.CartaAumentoMoral(carta);
            break;
            
            case 006:
                this.CartaQueima(carta);
            break;
        }
    }
}

    
