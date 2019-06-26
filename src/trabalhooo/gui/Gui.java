package trabalhooo.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import trabalhooo.gui.elementos.*;

/**
 * Classe que representa toda a interface gráfica da aplicação e encapsula as operações necessárias
 */
public class Gui {
    //Frame da interface grafica
    private JFrame frame;
    //JPanel principal que contém todos os outros
    private JPanel janela;
    private GuiListener control;
    private JogadorGUI[] jogadores = new JogadorGUI[2];
    
    /**
     * @deprecated Contrutor de testes sem parametros com valores padrão
     */
    public Gui(){
        inicializaFrame("Gwent", 640, 320);
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
        inicializaFrame(titulo, largura, altura);
        inicializaJogador(nomeJogadorUm, nomeJogadorDois);
    }

    /**
     * Inicializa o JFrame e o Jpanel principal
     * @param titulo titulo do JFrame
     * @param largura largura do JFrame
     * @param altura altura do JFrame
     */
    private void inicializaFrame(String titulo, int largura, int altura){
        frame = new JFrame("Teste");
        frame.setSize(largura, altura);
        janela = new JPanel();
        frame.getContentPane().add(janela);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Torna visivel a interface gráfica.
     * Encapsula o método JFrame.setVisible(true)
     */
    public void mostrar(){
        frame.setVisible(true);
    }

    

    /**
     * inicializa a propriedade jogadores[2] com as informações dos jogadores
     * @param nomeJogadorUm nome do primeiro jogador
     * @param nomeJogadorDois nome do segundo jogador
     */
    private void inicializaJogador(String nomeJogadorUm, String nomeJogadorDois){
        jogadores[0] = new JogadorGUI(nomeJogadorUm, 3);
        jogadores[1] = new JogadorGUI(nomeJogadorDois, 3);
        jogadores[0].adicionarAoPanel(janela);
        jogadores[1].adicionarAoPanel(janela);
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
   

}