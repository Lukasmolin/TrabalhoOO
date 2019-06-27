package trabalhooo.gui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import trabalhooo.gui.elementos.*;

/**
 * Classe que representa toda a interface gráfica da aplicação e encapsula as operações necessárias
 */
public class Gui extends JFrame implements Runnable{
    private static Dimension TAMANHO = new Dimension(640, 480);

    //JPanel principal que contém todos os outros
    private JPanel janela;
    private GuiListener control;
    private JogadorGUI[] jogadores = new JogadorGUI[2];
    
    /**
     * @deprecated Contrutor de testes sem parametros com valores padrão
     */
    public Gui(){
        inicializaFrame("Gwent");
        inicializaJogador("nomeJogadorUm", "nomeJogadorDois");
    }

    /**
     * Construtor com parametros
     * @param titulo titulo da janela
     * @param nomeJogadorUm nome do jogador um
     * @param nomeJogadorDois nome do jogador dois
     * @param largura largura da janela
     * @param altura altura da janela
     */
    public Gui(String titulo, String nomeJogadorUm, String nomeJogadorDois, int largura, int altura){
        inicializaFrame(titulo);
        setDimensao(new Dimension(largura, altura));
        inicializaJogador(nomeJogadorUm, nomeJogadorDois);
    }

    /**
     * Construtor com parametros
     * @param titulo titulo da janela
     * @param nomeJogadorUm nome do jogador um
     * @param nomeJogadorDois nome do jogador dois
     * @param tamanho Dimensão da janela
     */
    public Gui(String titulo, String nomeJogadorUm, String nomeJogadorDois, Dimension tamanho){
        inicializaFrame(titulo);
        setDimensao(new Dimension(tamanho));
        inicializaJogador(nomeJogadorUm, nomeJogadorDois);
    }

    /**
     * Seta o tamanho do frame
     * @param tamanho dimensão do frame
     */
    public static void setDimensao(Dimension tamanho){
        TAMANHO = tamanho;
    }

    /**
     * Retorna o tamanho do frame
     * @return Dimensão do frame
     */
    public static Dimension getDimensao(){
        return new Dimension(TAMANHO);
    }
    
    /**
     * Inicializa o JFrame e o Jpanel principal
     * @param titulo titulo do JFrame
     * @param largura largura do JFrame
     * @param altura altura do JFrame
     */
    private void inicializaFrame(String titulo){
        this.setTitle(titulo);
        this.setSize(TAMANHO);
        janela = new JPanel();
        this.getContentPane().add(janela);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }  

    /**
     * inicializa a propriedade jogadores[2] com as informações dos jogadores
     * @param nomeJogadorUm nome do primeiro jogador
     * @param nomeJogadorDois nome do segundo jogador
     */
    private void inicializaJogador(String nomeJogadorUm, String nomeJogadorDois){
        jogadores[0] = new JogadorGUI(nomeJogadorUm, "BaralhoUm", 3);
        jogadores[1] = new JogadorGUI(nomeJogadorDois, "BaralhoDois", 3);
        janela.add(jogadores[0]);
        janela.add(jogadores[1]);
    }

    /**
     * seta o valor da vida do jogador
     * @param vida Vida atual
     */
    public void setVidaJogadorUm(int vida){
        jogadores[0].setVidas(vida);
    }

    /**
     * seta o valor da vida do jogador
     * @param vida Vida atual
     */
    public void setVidaJogadorDois(int vida){
        jogadores[1].setVidas(vida);
    }

    /**
     * Seta o controller pra esta Gui
     * @param controller Listener pra esta Gui
     */
    public void setGuiListener(GuiListener controller){
        this.control = controller;
    }

    @Override
    public void run() {
        System.out.println("Run!");
    }

}