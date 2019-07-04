package trabalhooo.jogo;

import trabalhooo.jogo.cartas.*;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Lucas Molin <lucasmolin@ice.ufjf.br>
 */
public class Jogo {
    private boolean jogadaRecemPassada = false;
    private boolean partidaIniciada = false;
    private boolean repeteJogada = false;
    private JogoListener control;
    private Jogador jogadorUm, jogadorDois, atual;
    private Tabuleiro tabuleiro;

    /**
     * Contrutor
     * @param nomeJogadorUm Nome do primeiro jogador
     * @param nomeJogadorDois Nome do segundo jogador
     */
    public Jogo(String JogadorUm, String JogadorDois){
        this.jogadorUm = new Jogador(JogadorUm);
        this.jogadorDois = new Jogador(JogadorDois);
        tabuleiro = new Tabuleiro(jogadorUm, jogadorDois, this);
    }

    /**
     * Contrutor
     * @param nomeJogadorUm Nome do primeiro jogador
     * @param nomeJogadorDois Nome do segundo jogador
     */
    public Jogo(Jogador JogadorUm, Jogador JogadorDois){
        jogadorUm = JogadorUm;
        jogadorDois = JogadorDois;
        tabuleiro = new Tabuleiro(jogadorUm, jogadorDois, this);
    }

    public void setListener(JogoListener control){
        this.control = control;
    }
    
    public Jogador getJogadorUm(){
        return this.jogadorUm;
    }
    
    public Jogador getJogadorDois(){
        return this.jogadorDois;
    }

    public Tabuleiro getTabuleiro(){
        return this.tabuleiro;
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
     */
    private void sorteiaJogadorInicial(){
        Random random = new Random();
        int sorteio = random.nextInt(2);
        
        if (sorteio == 0)
            this.atual = jogadorUm;

        if (sorteio == 1)
            this.atual = jogadorDois;
    }

    public void iniciaPartida() throws Exception{
        if(!estaPronto()) { throw new Exception("O jogo ainda não está pronto pra começar"); }
        sorteiaJogadorInicial();
        partidaIniciada = true;
        if(control != null)
            control.JogoPronto();
    }

    /**
     * Retorna o jogador que está fazendo a jogada
     * @return atual
     */
    public Jogador getJogadorAtual(){
        return this.atual;
    }

    /**
     * Retorna o jogador que não estã jogando
     * @return
     */
    public Jogador getJogadorEmEspera(){
        if(jogadorUm.equals(atual))
            return jogadorDois;
        else
            return jogadorUm;
    }

    /**
     * 
     * @param jogador
     * @param nomeCarta
     * @throws Exception Se a partida nao foi iniciada ou se o Jogador não for o atual
     * @throws Exception Se o Jogador atual não possuir a carta
     * @throws Exception Se for uma carta lider já usada
     */
    public void fazJogada(String jogador, String nomeCarta) throws Exception {
        if(!partidaIniciada) { throw new Exception("A partida não foi iniciada"); }
        if(!jogador.equals(atual.getNome())) { throw new Exception("Esse jogador não é o atual"); }
        if(nomeCarta.equals("")){            
            passaJogada(jogador);
            jogadaRecemPassada = true;
        } else {
            jogadaRecemPassada = false;
            Campo campo = tabuleiro.getCampoDoJogador(atual);
            campo.addCarta(atual.jogaCarta(nomeCarta));
            if(!repeteJogada){
                trocaAtual();
            }
        }
        
    }

    //Troca o jogoador atuante
    private void trocaAtual(){
        if(atual.equals(jogadorUm)){
            atual = jogadorDois;
        } else if (atual.equals(jogadorDois)) {
            atual = jogadorUm;
        }
    }

    /**
     * Passa a jogada ou encerra uma jogada multipla
     * @param jogador
     */
    private void passaJogada(String jogador){        
        trocaAtual();
        if(jogadaRecemPassada){
            try {
                encerraRodada();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            if(!repeteJogada){
                repeteJogada = true;
            } else {
                repeteJogada = false;
            }
        }        
    }

    private void encerraRodada() throws Exception{
        repeteJogada = false;
        jogadaRecemPassada = false;
        int pontuacaoUm = tabuleiro.getCampoUm().getPontuacaoGeral();
        int pontuacaoDois = tabuleiro.getCampoDois().getPontuacaoGeral();
        if(pontuacaoUm > pontuacaoDois){
            jogadorDois.perdeVida();   
        } else if (pontuacaoDois > pontuacaoUm){
            jogadorUm.perdeVida();
        } else {
            jogadorUm.perdeVida();
            jogadorDois.perdeVida();
        }
        tabuleiro.getCampoUm().limpaCampo();
        tabuleiro.getCampoDois().limpaCampo();
    }

    /**
     * Retorna o jogador atual numericamente
     * @return Jogador atual ou -1 se nenhum for atual
     */
    public int getNumJogadorAtual(){
        if(atual.equals(jogadorUm)){
            return 1;
        } else if(atual.equals(jogadorDois)){
            return 2;
        }
        return -1;
    }

    //Metodos nao utilizados
    public int getInputFileiraCartaAgil(){
       return 0;
    }

    public int getInputFileiraAumentoMoral(){
        return 0;
    }

    public int getInputResgataCemiterio(){
        return 0;
    }

    public int getInputFileiraCartaEspecial(){
        return 0;
    }
}