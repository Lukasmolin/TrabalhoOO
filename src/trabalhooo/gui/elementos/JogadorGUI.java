package trabalhooo.gui.elementos;

import java.awt.Color;

import javax.swing.BorderFactory;
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
    public JogadorGUI(String nome, String baralho, String vidas) {
        inicializar(nome, baralho, vidas);
    }

    /**
     * Inicializa os componentes Swing referentes ao Jogador 
     * @param nome Nome do jogador
     * @param baralho Baralho escolhido para a partida
     */
    private void inicializar(String nome, String baralho, String vidas) {
        setBorder(BorderFactory.createLineBorder(Color.RED));
        removeAll();
        nome_info.setText(nome);
        baralho_info.setText(baralho);
        vidas_info = new JLabel(vidas);
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
     * Seta o valor do campo vida
     * @param vidas quantidade de vidas atual
     */
    public void setVidas(String vidas) {
        this.vidas_info.setText(vidas);
    }

    /**
     * Seta o valor do campo Cartas restantes
     * @param cartasRestantes Quantidade de cartas restantes
     */
    public void setCartasRestantes(String cartasRestantes){
        this.cartasRestantes_info.setText(cartasRestantes);
    }

}