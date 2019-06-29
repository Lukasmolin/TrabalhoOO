package trabalhooo.gui.elementos.jogador;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;

import trabalhooo.gui.GuiListener;
import trabalhooo.gui.elementos.carta.CartaGUI;

public class JogadorGUI extends JPanel implements MaoGUIListener {
    
    private final String nome;
    private GuiListener gui;
    private MaoGUI mao = new MaoGUI();

    //Elementos mutaveis
    private JLabel vidas_info = new JLabel();
    private JLabel cartasRestantes_info = new JLabel();
    private JLabel pontuacao_info = new JLabel();

    //Elementos fixos de cada instancia
    private JLabel nome_info = new JLabel();
    private JLabel baralho_info = new JLabel();

    //Rotulos fixos da Classe
    private JLabel nome_rotulo = new JLabel("Nome do Jogador:");
    private JLabel vidas_rotulo = new JLabel("Vidas:");
    private JLabel baralho_rotulo = new JLabel("Baralho:");
    private JLabel cartasRestantes_rotulo = new JLabel("Cartas Restantes: ");

    /**
     * Contrutor do JogadorGUI
     * @param nome Nome do jogador
     * @param vidas Vida do jogador
     */
    public JogadorGUI(String nome, String baralho, String vidas) {
        this.nome = nome;
        inicializar(this.nome, baralho, vidas);
    }

    /**
     * Inicializa os componentes Swing referentes ao Jogador 
     * @param nome Nome do jogador
     * @param baralho Baralho escolhido para a partida
     */
    private void inicializar(String nome, String baralho, String vidas) {
        removeAll();
        mao.setListener(this);
        nome_info.setText(nome);
        baralho_info.setText(baralho);
        pontuacao_info.setText("0");
        vidas_info = new JLabel(vidas);
        adicionaElementos();
    }

    private void adicionaElementos(){
        add(pontuacao_info);
        add(nome_rotulo);
        add(nome_info);
        add(vidas_rotulo);
        add(vidas_info);
        add(baralho_rotulo);
        add(baralho_info);
        add(cartasRestantes_rotulo);
        add(cartasRestantes_info);
    }

    /**
     * Seta a pontuação do jogador
     * @param pontuacao Pontos do jogador
     */
    public void setPontuacao(String pontuacao){
        pontuacao_info.setText(pontuacao);
    }
    
    /**
     * Seta o valor do campo vida
     * @param vidas quantidade de vidas atual
     */
    public void setVidas(String vidas) {
        vidas_info.setText(vidas);
    }

    /**
     * Seta as cartas na mão do jogador
     * @param cartas Cartas atualmente na mão do jogador
     * @throws Exception Se o array ou algum elemento for null
     */
    public void setMao(CartaGUI[] cartas) throws Exception{
        mao.set(cartas);
        atualizaCartas();
    }

    public void mostraMao(){
        mao.setVisible(true);
    }

    private void atualizaCartas(){
        String cartasNaMao = Integer.toString(mao.quantidade());
        this.cartasRestantes_info.setText(cartasNaMao);
    }

    /**
     * Seta o valor do campo Cartas restantes
     * @param cartasRestantes Quantidade de cartas restantes
     */
    public void setCartasRestantes(String cartasRestantes){
        this.cartasRestantes_info.setText(cartasRestantes);
    }

    /**
     * Seta o listener para este Jogador
     * @param ouvinte deste Jogador
     */
    public void SetGuiListener(GuiListener ouvinte){
        this.gui = ouvinte;
    }
    
    @Override
    public void jogadaFeita(String nomeCartaJogada) {
        if(gui != null){            
            gui.jogadaFeita(this.nome, nomeCartaJogada);
        }
    }
}