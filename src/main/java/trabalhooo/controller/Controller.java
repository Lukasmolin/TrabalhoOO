package trabalhooo.controller;

import trabalhooo.gui.Gui;
import trabalhooo.gui.GuiListener;
import trabalhooo.jogo.Jogo;
import trabalhooo.jogo.JogoListener;
import trabalhooo.jogo.cartas.Carta;
import trabalhooo.jogo.cartas.Faccao;

public class Controller implements GuiListener, JogoListener{

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
        atualizaGui();
        gui.setVisible(true);
        fazJogada();
    }
    
    private void inicializaJogo(String nomeUm, String nomeDois, int faccaoUm, int faccaoDois){
        jogo = new Jogo(nomeUm, nomeDois);
        jogo.getJogadorUm().setBaralho(converteFaccao(faccaoUm));
        jogo.getJogadorDois().setBaralho(converteFaccao(faccaoDois));
        try {
            jogo.iniciaPartida();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        
    }

    private void inicializaGui(String nomeUm, String nomeDois, int largura, int altura){
        gui = new Gui("Gwent!!", nomeUm, nomeDois, largura, altura);
        gui.setGuiListener(this);
    }

    private void atualizaGui(){
        try {
            atualizaJogadores();
            atualizaCampo();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void atualizaJogadores() throws Exception{
        gui.setVidaJogadorUm(Integer.toString(jogo.getJogadorUm().GetVidas()));
        gui.setVidaJogadorDois(Integer.toString(jogo.getJogadorDois().GetVidas()));
        gui.setFaccaoJogadorUm(converteFaccao(jogo.getJogadorUm().getFaccao()));
        gui.setFaccaoJogadorDois(converteFaccao(jogo.getJogadorDois().getFaccao()));
        gui.setMaoUm(converteCartas(jogo.getJogadorUm().getMao()));
        gui.setMaoDois(converteCartas(jogo.getJogadorDois().getMao()));
        gui.setPontosJogadorUm(Integer.toString(jogo.getTabuleiro().getCampoUm().getPontuacaoGeral()));        
        gui.setPontosJogadorDois(Integer.toString(jogo.getTabuleiro().getCampoDois().getPontuacaoGeral()));
    }

    private void atualizaCampo() throws Exception{
        gui.setCampoUm(new CartaControl[][]{
            converteCartas(jogo.getTabuleiro().getCampoUm().getFileiraBalistas()),
            converteCartas(jogo.getTabuleiro().getCampoUm().getFileiraArqueiros()),
            converteCartas(jogo.getTabuleiro().getCampoUm().getFileiraEspadachins())
        });
        gui.setCampoDois(new CartaControl[][]{
            converteCartas(jogo.getTabuleiro().getCampoDois().getFileiraEspadachins()),
            converteCartas(jogo.getTabuleiro().getCampoDois().getFileiraArqueiros()),
            converteCartas(jogo.getTabuleiro().getCampoDois().getFileiraBalistas())
        });
        gui.setPontosCampoUm(new String []{
            Integer.toString(jogo.getTabuleiro().getCampoUm().getPontuacaoBalistas()),
            Integer.toString(jogo.getTabuleiro().getCampoUm().getPontuacaoArqueiros()),
            Integer.toString(jogo.getTabuleiro().getCampoUm().getPontuacaoEspadachins())
        });
        gui.setPontosCampoDois(new String []{
            Integer.toString(jogo.getTabuleiro().getCampoDois().getPontuacaoEspadachins()),
            Integer.toString(jogo.getTabuleiro().getCampoDois().getPontuacaoArqueiros()),
            Integer.toString(jogo.getTabuleiro().getCampoDois().getPontuacaoBalistas())
        });
    }

    private void fazJogada(){
        int atual = jogo.getNumJogadorAtual();
        if(atual == 1){
            gui.jogaUm();
        } else if(atual == 2){
            gui.jogaDois();
        }
    }

    private String converteFaccao(Faccao faccao){
        switch(faccao){
            case MONSTROS:
                return "Monstros";
            case NILFGAARD:
                return "Nilfgaard";
            case REINO_DO_NORTE:
                return "Reino do Norte";
            case SCOIATAEL:
                return "ScoiaTael";
            default:
                return null;
        }
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

    private CartaControl[] converteCartas(Carta[] cartas){
        CartaControl[] retorno = new CartaControl[cartas.length];
        for(int i = 0; i < cartas.length; i++){
            retorno[i] = converteCarta(cartas[i]);
        }
        return retorno;
    }

    private CartaControl converteCarta(Carta c){
        return new CartaControl(c.getNome(), c.getDescricao(), Integer.toString(c.getPontuacao()));
    }

    public void setCaminho(String caminho){
        try{
            Gui.SetCaminho(caminho);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //GuiListener
    @Override
    public void jogadaFeita(String nomeJogador, String nomeCartaJogada) {
        try{
            jogo.fazJogada(nomeJogador, nomeCartaJogada);
        } catch (Exception ex){
            ex.printStackTrace();;
        }
        fazJogada();
        atualizaGui();
    }

    @Override
    public void JogoPronto() {

    }

    @Override
    public void vencedor(String jogadorVencedor) {
        gui.setVisible(false);
        inicia();
    }
}