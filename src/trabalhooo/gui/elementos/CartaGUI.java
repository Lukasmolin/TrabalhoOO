package trabalhooo.gui.elementos;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import trabalhooo.gui.Gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;

public class CartaGUI extends JPanel {
    //Id da Interface serializable
    private static final long serialVersionUID = -5901332414101123794L;

    private Dimension tamanho_carta;
    private static int altura = 0;
    //Tamanho da carta = altura da resolução da Gui / max cartas na vertical
    private static final int MAX_CARTAS_VERTICAL = 7;
    
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
     * @throws Exception se não for possivel recuperar a imagem da carta
     */
    public CartaGUI(String nome, String descricao, String pontuacao) throws Exception {
        inicializa(nome, descricao, pontuacao);
    }

    //Inicializa os elementos Swing e adicionam ao JPanel carta
    private void inicializa(String nome, String descricao, String pontuacao) throws Exception{
        if(!descricao.equals("")){
            setToolTipText(descricao);
        }
        nome_info.setText(nome);
        pontuacao_info.setText(pontuacao);

        inicializaTamanhos();
        alinhaElementos();
        adicionaElementos(nome);
        adicionaAoContainer();
    }

    private void inicializaTamanhos(){
        if(altura == 0)
            altura = (int)Gui.getDimensao().getHeight()/MAX_CARTAS_VERTICAL;

        int largura = altura / 5 * 4; //Temp
        tamanho_carta = new Dimension(largura, (int)altura);
        tamanho_texto = new Dimension(largura, (int)altura/2);
        tamanho_img = new Dimension(largura, (int)altura/2);

        tamanho_nome = new Dimension(largura, (int)altura/4);
        tamanho_pontuacao = new Dimension(largura, (int)altura/4);

        textos_panel.setSize(tamanho_texto);
        img_panel.setSize(tamanho_img);
        nome_panel.setSize(tamanho_nome);
        pontuacao_panel.setSize(tamanho_pontuacao);
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
        textos_panel.setLayout(new BoxLayout(textos_panel, BoxLayout.Y_AXIS));
        img_panel.setLayout(new BorderLayout());
    }

    /**
     * Adiciona conteudo aos elementos
     * @param nome Nome da carta
     * @throws Exception se ouver problemas resgatando a imagem da carta
     */
    private void adicionaElementos(String nome) throws Exception{
        nome_panel.add(nome_rotulo);
        nome_panel.add(nome_info);
        pontuacao_panel.add(pontuacao_rotulo);
        pontuacao_panel.add(pontuacao_info);

        img_info.setIcon(getImagem(nome));
    }

    /**
     * Adiciona os elementos ao JPanel pai da CartaGUI
     */
    private void adicionaAoContainer(){
        textos_panel.add(nome_panel);
        textos_panel.add(pontuacao_panel);
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
        
        if(RepositorioGUI.getTamanho() == null){
            RepositorioGUI.setTamanho(tamanho_img);
        }

        Image img = RepositorioGUI.getImagem(nome);
        return new ImageIcon(img);
    }

}