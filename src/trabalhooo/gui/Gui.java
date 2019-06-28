package trabalhooo.gui;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import trabalhooo.gui.elementos.*;

/**
 * Classe que representa toda a interface gráfica da aplicação e encapsula as operações necessárias
 */
public class Gui extends JFrame{
    private static Dimension TAMANHO = new Dimension(1280, 720);

    //JPanel principal que contém todos os outros
    private JPanel janela;
    private GuiListener control;
    private JogadorGUI[] jogadores = new JogadorGUI[2];
    private ArenaGUI arena = new ArenaGUI();
    
    /**
     * @deprecated Contrutor de testes sem parametros com valores padrão
     */
    public Gui(){
        inicializaFrame("Gwent");
        inicializaElementos("nomeJogadorUm", "nomeJogadorDois");
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
        inicializaElementos(nomeJogadorUm, nomeJogadorDois);
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
        inicializaElementos(nomeJogadorUm, nomeJogadorDois);
    }

    /**
     * Seta o tamanho do frame
     * @param tamanho dimensão do frame
     */
    private static void setDimensao(Dimension tamanho){
        TAMANHO = new Dimension(tamanho);
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
        setTitle(titulo);
        setSize(TAMANHO);
        janela = new JPanel();
        janela.setLayout(new BoxLayout(janela, BoxLayout.Y_AXIS));
        getContentPane().add(janela);
        TAMANHO = janela.getSize();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * inicializa a propriedade jogadores[2] com as informações dos jogadores
     * @param nomeJogadorUm nome do primeiro jogador
     * @param nomeJogadorDois nome do segundo jogador
     */
    private void inicializaElementos(String nomeJogadorUm, String nomeJogadorDois){
        jogadores[0] = new JogadorGUI(nomeJogadorUm, "BaralhoUm", "3");
        jogadores[1] = new JogadorGUI(nomeJogadorDois, "BaralhoDois", "3");
        janela.add(jogadores[0]);
        janela.add(arena);
        janela.add(jogadores[1]);
    }

    /**
     * Retorna o Jogador um da Gui
     * @return
     */
    public JogadorGUI getJogadorUm(){
        return jogadores[0];
    }

    /**
     * seta o valor da vida do jogador
     * @param vida Vida atual
     */
    public void setVidaJogadorDois(String vida){
        jogadores[1].setVidas(vida);
    }

    /**
     * Seta o controller pra esta Gui
     * @param controller Listener pra esta Gui
     */
    public void setGuiListener(GuiListener controller){
        this.control = controller;
    }

    /**
     * Seta o campo do jogador um
     * @param campo Campo de cartas
     * @throws Exception em caso de informações inválidas ou null
     */
    public void setCampoUm(CartaInfo[][] campo) throws Exception{
        CartaGUI[][] novoCampo = converteCampo(campo);
        arena.setCampoUm(novoCampo);
    }

    /**
     * Seta o campo do jogador dois
     * @param campo Campo de cartas
     * @throws Exception em caso de informações inválidas ou null
     */
    public void setCampoDois(CartaInfo[][] campo) throws Exception{
        CartaGUI[][] novoCampo = converteCampo(campo);
        arena.setCampoDois(novoCampo);
    }

    private CartaGUI[][] converteCampo(CartaInfo[][] campo) throws Exception{
        if(campo == null) { throw new Exception("Campo de CartaInfo null"); }
        CartaGUI[][] novo = new CartaGUI[campo.length][];
        for(int i = 0; i < novo.length; i++){
            novo[i] = new CartaGUI[campo[i].length];
            for(int j = 0; j < novo[i].length; j++){
                if(campo[i][j] == null) { throw new Exception ("CartaInfo Null"); }
                novo[i][j] = new CartaGUI(campo[i][j]);
            }
        }
        return novo;
    }

    /**
     * Seta os climas do tabuleiro, um array de tamanho zero limpa o clima
     * @param clima Array com as cartas clima
     * @throws Exception se alguma informação passada inválida ou null
     */
    public void setClima(CartaInfo[] clima) throws Exception{
        CartaGUI[] novoClima = converteClima(clima);
        arena.setClimas(novoClima);
    }

    public CartaGUI[] converteClima(CartaInfo[] clima) throws Exception{
        if(clima == null) { throw new Exception("Lista de cartaClima Null!"); }
        CartaGUI[] novo = new CartaGUI[clima.length];
        for(int i = 0; i < clima.length; i++){
            if(clima[i] == null) { throw new Exception("CartaClima Null no indice: " +i); }
            novo[i] = new CartaGUI(clima[i]);
        }
        return novo;
    }

    /**
     * Limpa os climas da arena
     */
    public void limpaClima(){
        arena.limpaClimas();
    }

}