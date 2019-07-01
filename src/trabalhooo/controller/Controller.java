package trabalhooo.controller;

import trabalhooo.gui.Gui;
import trabalhooo.gui.GuiListener;
import trabalhooo.jogo.Jogo;

public class Controller implements GuiListener{
    
    private Gui gui;
    private Jogo jogo;
    private TelaConfig tela;

    //Resoluções disponiveis
    private final int[][] resolucao = {
        { 1920, 1080 },
        { 1280, 720 },
        { 1024, 768 },
        { 800, 600 }
    };

    public void inicia(){
        if(gui != null){
            gui.dispose();
        }
        tela = new TelaConfig(this);
    }

    //Metodo chamado pela tela de configuração para iniciar o jogo
    /**
     * inicia um jogo
     * @param nomeUm
     * @param nomeDois
     * @param faccaoUm
     * @param faccaoDois
     * @param resolucao
     */
    public void iniciarPartida(String nomeUm, String nomeDois, int faccaoUm, int faccaoDois, int resolucao){
        inicializaGui(nomeUm, nomeDois, this.resolucao[resolucao][0], this.resolucao[resolucao][1]);
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

    private void inicializaJogo(){

    }


    

    //GuiListener
    @Override
    public void jogadaFeita(String nomeJogador, String nomeCartaJogada) {

    }
}