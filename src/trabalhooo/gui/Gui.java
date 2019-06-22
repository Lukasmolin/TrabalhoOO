package trabalhooo.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gui {
    private JFrame frame;
    private JPanel janela;
    private JPanel[] jogadores = new JPanel[2];
    

    public Gui(){
        inicializarFrame("Gwent", 640, 320);
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
        inicializarFrame(titulo, largura, altura);
    }

    /**
     * Inicializa o JFrame e o Jpanel principal
     * @param titulo titulo do JFrame
     * @param largura largura do JFrame
     * @param altura altura do JFrame
     */
    private void inicializarFrame(String titulo, int largura, int altura){
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
        aux_inicializaJogador(jogadores[0], nomeJogadorUm);
        aux_inicializaJogador(jogadores[1], nomeJogadorDois);
    }

    private void aux_inicializaJogador(JPanel jogador, String nome){
        jogador = new JPanel();
        JLabel nome_rotulo = new JLabel("Nome:");
        JLabel nome_info = new JLabel(nome);
        JLabel vidas_rotulo = new JLabel("Vidas: ");
        JLabel vidas_info = new JLabel("3");
        jogador.add(nome_rotulo);
        jogador.add(nome_info);
        jogador.add(vidas_rotulo);
        jogador.add(vidas_info);
        janela.add(jogador);
    }

}