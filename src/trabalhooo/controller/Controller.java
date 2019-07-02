package trabalhooo.controller;

import trabalhooo.gui.Gui;
import trabalhooo.gui.GuiListener;
import trabalhooo.jogo.Jogo;
import trabalhooo.jogo.cartas.Faccao;

public class Controller implements GuiListener{

    private Gui gui;
    private Jogo jogo;

    //Resoluções disponiveis
    private final int[][] resolucao = {
        { 1920, 1080 },
        { 1280, 720 },
        { 1024, 768 },
        { 800, 600 }
    };

    public void inicia(){
        if(gui != null){
            gui.setVisible(false);
            gui.dispose();
        }
        new TelaConfig(this);
    }

    /**
     * inicia um jogo
     * @param nomeUm
     * @param nomeDois
     * @param faccaoUm
     * @param faccaoDois
     * @param resolucao
     */
    public void iniciarPartida(String nomeUm, String nomeDois, int faccaoUm, int faccaoDois, int resolucao){
        inicializaJogo(nomeUm, nomeDois, faccaoUm, faccaoDois);
        inicializaGui(nomeUm, nomeDois, this.resolucao[resolucao][0], this.resolucao[resolucao][1]);
        primeiraJogada();
        gui.setVisible(true);
    }

    public void setCaminho(String caminho){
        try{
            Gui.SetCaminho(caminho);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void inicializaGui(String nomeUm, String nomeDois, int largura, int altura){
        gui = new Gui("Gwent!!", nomeUm, nomeDois, largura, altura);
        gui.setGuiListener(this);
    }

    private void inicializaJogo(String nomeUm, String nomeDois, int faccaoUm, int faccaoDois){
        jogo = new Jogo(nomeUm, nomeDois);
        jogo.getJogadorUm().setBaralho(converteFaccao(faccaoUm));
        jogo.getJogadorDois().setBaralho(converteFaccao(faccaoDois));
        thread.start();        
    }

    private void primeiraJogada(){

    }

    private Faccao converteFaccao(int faccao){
        switch(faccao){
            case 0:
                return Faccao.MONSTROS;
            case 1:
                return Faccao.NILFGAARD;
            case 2:
                return Faccao.REINO_DO_NORTE;
            case 3:
                return Faccao.SCOIATAEL;
            default:
                return null;
        }
    }


    

    //GuiListener
    @Override
    public void jogadaFeita(String nomeJogador, String nomeCartaJogada) {

    }
}