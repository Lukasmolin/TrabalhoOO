package trabalhooo.gui.elementos;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class JogadorGUI extends JPanel {
    //Elementos mutaveis
    private JLabel vidas_info = new JLabel();
    private JLabel cartasRestantes_info = new JLabel();

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
    public JogadorGUI(String nome, String baralho, int vidas) {
        inicializar(nome, baralho, vidas);
    }

    /**
     * Inicializa os componentes Swing referentes ao Jogador 
     * @param nome Nome do jogador
     * @param baralho Baralho escolhido para a partida
     */
    private void inicializar(String nome, String baralho, int vidas) {
        this.removeAll();    
        nome_info.setText(nome);
        baralho_info.setText(baralho);
        vidas_info = new JLabel(Integer.toString(vidas));
        this.add(nome_rotulo);
        this.add(nome_info);
        this.add(vidas_rotulo);
        this.add(vidas_info);
        this.add(baralho_rotulo);
        this.add(baralho_info);
        this.add(cartasRestantes_rotulo);
        this.add(cartasRestantes_info);
    }

    /**
     * Seta o valor do campo
     * @param vidas quantidade de vidas atual
     */
    public void setVidas(int vidas) {
        this.vidas_info.setText(Integer.toString(vidas));
    }

    /**
     * Seta o valor do campo vida
     * @param vidas quantidade de vidas atual
     */
    public void setVidas(String vidas) {
        this.vidas_info.setText(vidas);
    }

    /**
     * Seta o valor do campo Cartas restantes
     * @param cartasRestantes Quanridade de cartas restantes
     */
    public void setCartasRestantes(int cartasRestantes){
        this.cartasRestantes_info.setText(Integer.toString(cartasRestantes));
    }

    /**
     * Seta o valor do campo Cartas restantes
     * @param cartasRestantes Quanridade de cartas restantes
     */
    public void setCartasRestantes(String cartasRestantes){
        this.cartasRestantes_info.setText(cartasRestantes);
    }

}