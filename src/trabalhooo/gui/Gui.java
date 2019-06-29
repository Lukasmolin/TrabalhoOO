package trabalhooo.gui;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import trabalhooo.gui.elementos.arena.ArenaGUI;
import trabalhooo.gui.elementos.carta.CartaGUI;
import trabalhooo.gui.elementos.jogador.JogadorGUI;

/**
 * Classe que representa toda a interface gráfica da aplicação e encapsula as operações necessárias
 */
public class Gui extends JFrame{
    private static int altura = 0;
    private static int largura = 0;

    //JPanel principal que contém todos os outros
    private JPanel janela;
    private GuiListener control;
    private JogadorGUI[] jogadores = new JogadorGUI[2];
    public ArenaGUI arena;
    
    /**
     * @deprecated Contrutor de testes sem parametros com valores padrão
     */
    public Gui(){
        largura = 640;
        altura = 480;
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
        Gui.altura = altura;
        Gui.largura = largura;
        inicializaFrame(titulo);
        inicializaElementos(nomeJogadorUm, nomeJogadorDois);
    }

    /**
     * Retorna o tamanho do frame
     * @return Dimensão do frame
     */
    public static Dimension getDimensao(){
        if(altura == 0 || largura == 0){
            return null;
        } else {
            return new Dimension(largura, altura);
        }
    }

    /**
     * Inicializa o JFrame e o Jpanel principal
     * @param titulo titulo do JFrame
     * @param largura largura do JFrame
     * @param altura altura do JFrame
     */
    private void inicializaFrame(String titulo){
        setTitle(titulo);
        setSize(largura, altura);
        janela = new JPanel();
        janela.setLayout(new BoxLayout(janela, BoxLayout.Y_AXIS));
        getContentPane().add(janela);
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
        arena = new ArenaGUI();
        janela.add(jogadores[0]);
        janela.add(arena);
        janela.add(jogadores[1]);
    }
    /**
     * seta o valor da vida do jogador
     * @param vida Vida atual
     */
    public void setVidaJogadorUm(String vida){
        jogadores[0].setVidas(vida);
    }
    
    /**
     * seta o valor da vida do jogador
     * @param vida Vida atual
     */
    public void setVidaJogadorDois(String vida){
        jogadores[1].setVidas(vida);
    }

    /**
     * Jogador faz a jogada
     */
    public void jogaUm(){
        jogadores[0].mostraMao();
    }

    /**
     * Jogador faz a jogada
     */
    public void jogaDois(){
        jogadores[1].mostraMao();
    }

    /**
     * Seta a mão do Jogador
     * @param mao Array de cartas na mão do Jogador
     * @throws Exception se o array ou algum elemento nele contido for null
     */
    public void setMaoUm(CartaInfo[] mao) throws Exception{
        if(mao == null) { throw new Exception("Mao null!"); }
        CartaGUI[] novaMao = converteCartas(mao);
        jogadores[0].setMao(novaMao);
    }

    
    /**
     * Seta a mão do Jogador
     * @param mao Array de cartas na mão do Jogador
     * @throws Exception se o array ou algum elemento nele contido for null
     */
    public void setMaoDois(CartaInfo[] mao) throws Exception{
        if(mao == null) { throw new Exception("Mao null!"); }
        CartaGUI[] novaMao = converteCartas(mao);
        jogadores[1].setMao(novaMao);
    }

    /**
     * Converte um array de CartaInfo e retorna um novo array de CartaGUI
     * @param cartas Array de CartaInfo
     * @return Array de CartaGUI
     * @throws Exception se algum elemento no Array for null
     */
    private static CartaGUI[] converteCartas(CartaInfo[] cartas) throws Exception{
        CartaGUI[] novasCartas = new CartaGUI[cartas.length];
        for(int i = 0; i < novasCartas.length; i++){
            if(cartas == null) { throw new Exception("CartaInfo Null!"); }
            novasCartas[i] = new CartaGUI(cartas[i]);
        }
        return novasCartas;
    }

    /**
     * Seta o controller pra esta Gui
     * @param controller Listener pra esta Gui
     */
    public void setGuiListener(GuiListener controller){
        jogadores[0].SetGuiListener(controller);
        jogadores[1].SetGuiListener(controller);
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

    /**
     * converteU
     * @param campo
     * @return
     * @throws Exception
     */
    private static CartaGUI[][] converteCampo(CartaInfo[][] campo) throws Exception{
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