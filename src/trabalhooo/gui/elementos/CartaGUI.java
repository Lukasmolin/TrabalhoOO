package trabalhooo.gui.elementos;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;

public class CartaGUI extends JPanel {
    //Id da Interface serializable
    private static final long serialVersionUID = -5901332414101123794L;

    private Dimension tamanho_carta;
    
    //Paineis principais
    private JPanel textos_panel = new JPanel();
    private JPanel img_panel = new JPanel();

    //Nome    
    private JPanel nome_panel = new JPanel();
    private JLabel nome_rotulo = new JLabel("Nome:");
    private JLabel nome_info = new JLabel();
    private Dimension tamanho_nome;
    
    //Pontuacao
    private JPanel pontuacao_panel = new JPanel();
    private JLabel pontuacao_rotulo = new JLabel("Pontuação:");
    private JLabel pontuacao_info = new JLabel();
    private Dimension tamanho_pontuacao;

    //Descricao
    private JPanel descricao_panel = new JPanel();
    private JLabel descricao_info = new JLabel();
    private Dimension tamanho_descricao;

    //Painel de texto
    private Dimension tamanho_texto;

    //Imagem
    private JLabel img_info = new JLabel();
    private Dimension tamanho_img;

    /**
     * Construtor da classe
     * @param nome Nome da carta
     * @param descricao descrição da carta
     * @param pontuacao pontuação da carta
     * @throws Exception
     */
    public CartaGUI(String nome, String descricao, int pontuacao) throws Exception {
        inicializa(nome, descricao, pontuacao);
    }

    /**
     * Inicializa os elementos Swing e adicionam ao JPanel carta
     */
    private void inicializa(String nome, String descricao, int pontuacao) throws Exception{
        //Adiciona informação da carta aos elementos
        nome_info.setText(nome);
        pontuacao_info.setText(Integer.toString(pontuacao));
        descricao_info.setText(descricao);

        inicializaTamanhos();
        alinhaElementos();
        adicionaElementos(nome);
        adicionaAoContainer();
    }

    private void inicializaTamanhos(){
        int altura = 200; //Temp
        int largura = altura / 4 * 3; //Temp
        tamanho_carta = new Dimension(largura, (int)altura);
        tamanho_texto = new Dimension(largura, (int)altura/2);
        tamanho_img = new Dimension(largura, (int)altura/2);

        tamanho_nome = new Dimension(largura, (int)altura/8);
        tamanho_pontuacao = new Dimension(largura, (int)altura/8);
        tamanho_descricao = new Dimension(largura, (int)altura/4);

        textos_panel.setSize(tamanho_texto);
        img_panel.setSize(tamanho_img);
        nome_panel.setSize(tamanho_nome);
        pontuacao_panel.setSize(tamanho_pontuacao);
        descricao_panel.setSize(tamanho_descricao);
        setSize(tamanho_carta);
        setMinimumSize(tamanho_carta);
    }

    /**
     * Seta o Layout e alinha os elementos da Carta
     */
    private void alinhaElementos(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        nome_panel.setLayout(new FlowLayout());
        pontuacao_panel.setLayout(new FlowLayout());
        descricao_panel.setLayout(new BorderLayout());
        textos_panel.setLayout(new BoxLayout(textos_panel, BoxLayout.Y_AXIS));
        img_panel.setLayout(new BorderLayout());
    }

    private void adicionaElementos(String nome) throws Exception{
        nome_panel.add(nome_rotulo);
        nome_panel.add(nome_info);
        pontuacao_panel.add(pontuacao_rotulo);
        pontuacao_panel.add(pontuacao_info);
        descricao_panel.add(descricao_info, BorderLayout.WEST);

        img_info.setIcon(getImagem(nome));
    }

    /**
     * Adiciona os elementos ao JPanel pai da CartaGUI
     */
    private void adicionaAoContainer(){
        textos_panel.add(nome_panel);
        textos_panel.add(pontuacao_panel);
        textos_panel.add(descricao_panel);
        img_panel.add(img_info, BorderLayout.CENTER);

        add(textos_panel);
        add(img_panel);
    }

    /**
     * Retorna a imagem da Carta
     * @param nome Nome da carta
     * @return Imagem da carta
     * @throws Exception Se a imagem não puder ser resgatada
     */
    private ImageIcon getImagem(String nome) throws Exception{
        if(tamanho_img == null) { throw new Exception("O tamanho da imagem não foi setado"); }

        int largura = (int)tamanho_img.getWidth();
        int altura = (int)tamanho_img.getHeight();
        Image img = RepositorioGUI.getImagem(nome);
        return new ImageIcon(img.getScaledInstance(largura, altura, Image.SCALE_FAST));
    }

}