package trabalhooo.gui.elementos;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.sun.prism.Image;

public class CartaGUI extends JPanel {
    // Elementos da Carta
    private final String nome;
    private final String descricao;
    private final int pontuacao;

    //Elementos da interface;
    private JLabel nome_rotulo = new JLabel("Nome:");
    private JLabel pontuacao_rotulo = new JLabel("Pontuação:");
    private JLabel nome_info = new JLabel();
    private JLabel pontuacao_info = new JLabel();
    private JLabel descricao_info = new JLabel(); 

    /**
     * Construtor da classe
     * @param nome Nome da carta
     * @param descricao descrição da carta
     * @param pontuacao pontuação da carta
     */
    public CartaGUI(String nome, String descricao, int pontuacao) {
        this.nome = nome;
        this.descricao = descricao;
        this.pontuacao = pontuacao;
        inicializa();
    }

    /**
     * Inicializa os elementos Swing e adicionam ao JPanel carta
     */
    private void inicializa(){
        //Adiciona informação da carta aos elementos
        nome_info.setText(this.nome);
        pontuacao_info.setText(Integer.toString(this.pontuacao));
        descricao_info.setText(this.descricao);

        //Adiciona os elementos ao container
        this.add(this.nome_rotulo);
        this.add(this.nome_info);
        this.add(this.pontuacao_rotulo);
        this.add(this.pontuacao_info);
        this.add(this.descricao_info);
    }

    /**
     * Retorna o nome da carta
     * 
     * @return Nome da carta
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Retorna a descrição da carta
     * 
     * @return Descrição da carta
     */
    public String getDescricao() {
        return this.descricao;
    }

    /**
     * Retorna a pontuação
     * @return pontuação
     */
    public int getPontuacao() {
        return this.pontuacao;
    }

    /**
     * Retorna a imagem da Carta
     * @return Imagem da carta
     * @throws Exception
     */
    public Image getImage() throws Exception{
        throw new Exception("Metodo ainda não implementado!");
    }

}