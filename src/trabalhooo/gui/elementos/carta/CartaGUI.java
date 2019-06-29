package trabalhooo.gui.elementos.carta;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import trabalhooo.gui.CartaInfo;
import trabalhooo.gui.Gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;

public class CartaGUI extends JPanel{
    //Id da Interface serializable
    private static final long serialVersionUID = -5901332414101123794L;

    private String nome = "";
    private Dimension tamanho_carta;
    private static int altura = 0;

    //Altura da carta = altura da resolução da Gui * MULTIPLICADOR_TAM
    private static final double MULTIPLICADOR_TAM = 0.12;
    
    //Paineis principais
    private JPanel textos_panel = new JPanel();
    private JPanel img_panel = new JPanel();

    //Nome
    private JLabel nome_info = new JLabel();
    
    //Pontuacao
    //private JLabel pontuacao_rotulo = new JLabel("Pontuação:");
    private JLabel pontuacao_info = new JLabel();

    //Imagem
    private JLabel img_info = new JLabel();
    private Dimension tamanho_img;

    /**
     * Cria uma carta a partir de uma CartaInfo
     * @param carta Carta com as informações
     * @throws Exception se a carta for null, se alguma informacao da carta for null ou se não for possivel
     * recuperar a imagem da carta
     */
    public CartaGUI(CartaInfo carta) throws Exception{
        if (carta == null) { throw new Exception("CartaInfo null"); }
        valida(carta.getNome(), carta.getDescricao(), carta.getPontuacao());
        inicializa(carta.getNome(), carta.getDescricao(), carta.getPontuacao());
    }

    /**
     * Construtor da classe
     * @param nome Nome da carta
     * @param descricao descrição da carta
     * @param pontuacao pontuação da carta
     * @throws Exception se não for possivel recuperar a imagem da carta ou algum parametro for null
     */
    public CartaGUI(String nome, String descricao, String pontuacao) throws Exception {
        valida(nome, descricao, pontuacao);
        inicializa(nome, descricao, pontuacao);
    }

    /**
     * Cria um slot vazio para uma carta
     */
    public CartaGUI(){
        inicializaTamanhos();
        setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
    }

    private void valida(String nome, String descricao, String pontuacao) throws Exception{
        if(nome == null) { throw new Exception ("Nome Null"); }
        if(descricao == null) { throw new Exception ("Descricao Null! Carta: " +nome); }
        if(pontuacao == null) { throw new Exception("Pontuacao Null! Carta: " +nome); }
    }

    //Inicializa os elementos Swing e adicionam ao JPanel carta
    private void inicializa(String nome, String descricao, String pontuacao) throws Exception{
        if(!descricao.equals("")){
            setToolTipText(descricao);
        }
        this.nome = nome;
        nome_info.setText(nome);
        pontuacao_info.setText(pontuacao);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        inicializaTamanhos();
        alinhaElementos();
        adicionaElementos(nome);
        adicionaAoContainer();
    }

    private void inicializaTamanhos(){
        if(altura == 0){
            altura = (int)(Gui.getDimensao().getHeight() * MULTIPLICADOR_TAM);
        }

        int largura = altura / 5 * 4;
        tamanho_carta = new Dimension(largura, (int)altura);
        tamanho_img = new Dimension(largura, (int)altura/2);
        img_panel.setSize(tamanho_img);
        setSize(tamanho_carta);
        setMinimumSize(tamanho_carta);
        setPreferredSize(tamanho_carta);
    }

    /**
     * Seta o Layout e alinha os elementos da Carta
     */
    private void alinhaElementos(){
        setLayout(new GridLayout(2, 1));
        textos_panel.setLayout(new BoxLayout(textos_panel, BoxLayout.Y_AXIS));
        img_panel.setLayout(new BorderLayout());


        textos_panel.setAlignmentX(0);
        nome_info.setHorizontalAlignment(SwingConstants.LEFT);
        pontuacao_info.setHorizontalAlignment(SwingConstants.LEFT);
    }

    /**
     * Adiciona conteudo aos elementos
     * @param nome Nome da carta
     * @throws Exception se ouver problemas resgatando a imagem da carta
     */
    private void adicionaElementos(String nome) throws Exception{
        textos_panel.add(nome_info);
        textos_panel.add(pontuacao_info);
        img_info.setIcon(getImagem(nome));
    }

    /**
     * Adiciona os elementos ao JPanel pai da CartaGUI
     */
    private void adicionaAoContainer(){        
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

    /**
     * Retorna o nome da carta ou uma String vazia se a carta for vazia
     * @return Nome da carta
     */
    public String getNome(){
        return nome;
    }

}