package trabalhooo.gui.elementos.jogador;

import javax.swing.JLabel;
import javax.swing.JPanel;

import trabalhooo.gui.GuiListener;
import trabalhooo.gui.elementos.carta.CartaGUI;

/**
 * Representa o painel de informações de um jogador
 */
public class JogadorGUI extends JPanel implements MaoGUIListener {
    //Serializable
    private static final long serialVersionUID = 1L;
    
    private final String nome;
    private GuiListener gui;
    private MaoGUI mao = new MaoGUI();

    //Elementos
    private JLabel vidas_info = new JLabel();
    private JLabel cartasRestantes_info = new JLabel();
    private JLabel pontuacao_info = new JLabel();
    private JLabel nome_info = new JLabel();
    private JLabel baralho_info = new JLabel();

    //Rotulos fixos da Classe
    private JLabel nome_rotulo = new JLabel("Nome do Jogador:");
    private JLabel vidas_rotulo = new JLabel("Vidas:");
    private JLabel baralho_rotulo = new JLabel("Baralho:");
    private JLabel cartasRestantes_rotulo = new JLabel("Cartas Restantes: ");

    public JogadorGUI(String nome){
        this.nome = nome;
        inicializar(this.nome);
    }

    /**
     * Contrutor do JogadorGUI
     * @param nome Nome do jogador
     * @param vidas Vida do jogador
     */
    public JogadorGUI(String nome, String baralho, String vidas) {
        this.nome = nome;
        inicializar(this.nome);
        setFaccao(baralho);
        setVidas(vidas);
    }

    /**
     * Inicializa os componentes Swing referentes ao Jogador 
     * @param nome Nome do jogador
     * @param baralho Baralho escolhido para a partida
     */
    private void inicializar(String nome) {
        removeAll();
        mao.setListener(this);
        nome_info.setText(nome);
        pontuacao_info.setText("0");
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
        System.out.println("CartasRestantes: "+cartasNaMao);
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
     * Seta a facção do Jogador
     * @param faccao
     */
    public void setFaccao(String faccao){
        baralho_info.setText(faccao);
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

    @Override
    public String getNome() {
        return this.nome;
    }
}