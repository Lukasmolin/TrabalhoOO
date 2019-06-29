/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhooo.jogo;

import trabalhooo.jogo.cartas.*;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Lucas Molin <lucasmolin@ice.ufjf.br>
 */
public class Jogo {
    private boolean pronto = false;
    private Jogador jogadorUm, jogadorDois;
    private Tabuleiro tabuleiro;
    private int contaJogadas = 0;
    private boolean fimdeJogo = false;
    private boolean fimdeRodada = false;
    private final Efeito efeito = new Efeito(tabuleiro, this);
    private Jogador vencedor;
    
    /**
     * 
     * @param nomeJogadorUm Nome do primeiro jogador
     * @param nomeJogadorDois Nome do segundo jogador
     */
    public Jogo(Jogador JogadorUm, Jogador JogadorDois){
        jogadorUm = JogadorUm;
        jogadorDois = JogadorDois;
        tabuleiro = new Tabuleiro(jogadorUm, jogadorDois);
    }
    
    public Jogador getVencedor(){
        return this.vencedor;
    }
    
    public Jogador getJogadorUm(){
        return this.jogadorUm;
    }
    
    public Jogador getJogadorDois(){
        return this.jogadorDois;
    }
    
    /**
     * Retorna o nome do Jogador
     * @return Nome do jogador
     */
    public String getNomeJogadorUm(){
        return jogadorUm.getNome();
    }
    
    /**
     * Retorna o nome do Jogador
     * @return Nome do jogador
     */
    public String getNomeJogadorDois(){
        return jogadorDois.getNome();
    }
    
    /**
     * Escolhe a facção do Jogador Um
     * @param faccao Facção selecionada pelo jogador
     */
    public void setFaccaoJogadorUm(Faccao faccao){
             
        jogadorUm.setBaralho(faccao);
        
    }
    
    /**
     * Escolhe a facção do Jogador Dois
     * @param faccao Facção selecionada pelo jogador
     */
    public void setFaccaoJogadorDois(Faccao faccao){
              
        jogadorDois.setBaralho(faccao);
        
    }
    
    /**
     * Retorna um array de cartas na mão do Jogador um
     * @return Array de Carta na ão do jogador
     */
    public Carta[] getMaoJogadorUm(){
        try {
            return jogadorUm.getMao();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    /**
     * Retorna um array de cartas na mão do Jogador dois
     * @return Array de Carta na ão do jogador
     */
    public Carta[] getMaoJogadorDois(){
        try {
            return jogadorDois.getMao();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    /**
     * Retorna se ambos os jogadores estão prontos pra começar pelo metodo estaPronto
     * @return True se estaPronto for verdadeiro pra ambos Jogadores, false senão
     */
    public boolean estaPronto(){
        return this.jogadorUm.estaPronto() && this.jogadorDois.estaPronto();
    }
    
    /**
     * Determina jogador inicial
     * @return 
     */
    public  Jogador jogadorInicial(){
        
        Random random = new Random();
        int sorteio = random.nextInt(2);
        
        if (sorteio==0){
            return jogadorUm;
        }
        
        if (sorteio==1){
            return jogadorDois;
        }
        else
            System.out.println("Vixi");
            return null;
    }
    
    /**
     * Inicia o jogo com 0 jogadas, muda o jogador ativo conforme as jogadas avançam
     * @return o jagador ativo no momento
     */
    public Jogador getJogadorAtual(){
        Jogador jogadorInicial = jogadorInicial();
        if(jogadorInicial == jogadorUm){
            while (fimdeJogo==false){
                while (fimdeRodada==false){
                    if(contaJogadas%2 == 0){
                        return jogadorUm;
                    }
                    else 
                        return jogadorDois;
                }
            }
        }
        else 
            while (fimdeJogo==false){
                while (fimdeRodada==false){
                    if(contaJogadas%2 == 0){
                        return jogadorDois;
                    }
                    else 
                        return jogadorUm;
                }
            }
        
        return null;     
    }
    
    /**
     * Retorna o jogador em espera
     * @return 
     */
    public Jogador getJogadorEmEspera(){
        Jogador jogadorInicial = jogadorInicial();
        if(jogadorInicial == jogadorUm){
            while (fimdeJogo==false){
                while (fimdeRodada==false){
                    if(contaJogadas%2 == 0){
                        return jogadorDois;
                    }
                    else 
                        return jogadorUm;
                }
            }
        }
        else 
            while (fimdeJogo==false){
                while (fimdeRodada==false){
                    if(contaJogadas%2 == 0){
                        return jogadorUm;
                    }
                    else 
                        return jogadorDois;
                }
            }
        
        return null;     
    }
    
    public Tabuleiro  getTabuleiro(){
        return this.tabuleiro;
    }
    
    public boolean verificaVidas(){
        if (jogadorUm.GetVidas()==0){
            vencedor = jogadorUm;
            return true;
        } else if(jogadorDois.GetVidas()==0){
            vencedor = jogadorDois;
            return true;
        }
        else 
            return false;
    }
    
    public boolean verificaRodada(){
        if(jogadorUm.getPassou()==true && jogadorDois.getPassou()==true){
            return true;
        }
        else 
            return false;
    }
    
    public Carta escolheCarta(Jogador atual){
        boolean escolha;
        Scanner teclado = new Scanner(System.in);
        
        for (int i=0;i<atual.getMao().length;i++){
            Carta escolhida = atual.getMao()[i];
            escolha  = teclado.nextBoolean();
            if (escolha==true){
                return escolhida;
            }
        }
        return null;
    }
    
    public void verificaVencedorRodada (Jogo novoJogo) throws Exception{
        if (novoJogo.getJogadorUm().GetVidas() > novoJogo.getJogadorDois().GetVidas()){
            novoJogo.getJogadorDois().perdeVida();
        }
        else if (novoJogo.getJogadorDois().GetVidas() > novoJogo.getJogadorUm().GetVidas()){
            novoJogo.getJogadorUm().perdeVida();
        }
        else 
            novoJogo.getJogadorUm().perdeVida();
            novoJogo.getJogadorDois().perdeVida();
    }
    
    public void Jogo(Jogo novoJogo) throws Exception{
       
        boolean termina=false;
        
        
        do{
            Rodada(novoJogo);
            novoJogo.contaJogadas++;
            if (novoJogo.verificaVidas()==true){
               termina=true; 
            }
            
        } while(termina==false);
        
    }
    
    public static void Rodada(Jogo novoJogo) throws Exception{
       
        Scanner teclado = new Scanner(System.in);
        
        do{
            
            boolean passa;
            passa = teclado.nextBoolean();
            if (passa==false){
                novoJogo.getJogadorAtual().jogaCarta(novoJogo.escolheCarta(novoJogo.getJogadorAtual()));
                novoJogo.getJogadorAtual().setPassou(false);
            }
            else 
                novoJogo.getJogadorAtual().setPassou(true);
                novoJogo.verificaRodada();
                novoJogo.verificaVencedorRodada(novoJogo);
        } while (novoJogo.verificaRodada()==true);
    }
}
