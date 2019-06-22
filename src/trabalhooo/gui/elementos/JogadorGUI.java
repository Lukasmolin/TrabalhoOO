package trabalhooo.gui.elementos;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class JogadorGUI implements ElementoGUI {
    private String nome;
    private int vidas;
    private JPanel component;
    private JLabel nome_info;
    private JLabel vidas_info;

    //Rotulos fixos do Jogador
    private JLabel nome_rotulo = new JLabel("Nome do Jogador:");
    private JLabel vidas_rotulo = new JLabel("Vidas:");

    /**
     * Contrutor do JogadorGUI
     * @param nome Nome do jogador
     * @param vidas Vida do jogador
     */
    public JogadorGUI(String nome, int vidas) {
        this.nome = nome;
        this.vidas = vidas;
        inicializar();
    }

    /**
     * Inicializa os componentes Swing referentes ao Jogador
     */
    private void inicializar(){
        component = new JPanel();        
        nome_info = new JLabel(this.nome);
        vidas_info = new JLabel(Integer.toString(this.vidas));
        component.add(nome_rotulo);
        component.add(nome_info);
        component.add(vidas_rotulo);
        component.add(vidas_info);
    }

    /**
     * Seta o valor da vida deste Jogador
     * @param vidas quantidade de vidas atual
     */
    public void setVidas(int vidas){
        this.vidas_info.setText(Integer.toString(vidas));
    }

    /**
     * Retorna o nome do Jogador
     * @return Nome do jogador
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Retorna as vidas do Jogador
     * @return numero de vidas do jogador
     */
    public int getVidas() {
        return this.vidas;
    }

    @Override
    public void adicionarAoPanel(JPanel pai) {
        pai.add(component);
    }
}