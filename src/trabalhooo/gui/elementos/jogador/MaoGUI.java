package trabalhooo.gui.elementos.jogador;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import trabalhooo.gui.Gui;
import trabalhooo.gui.elementos.carta.CartaGUI;

public class MaoGUI extends JFrame implements MouseListener {
    private static final int PROPORCAO_ALTURA = 6;
    private static Dimension TAMANHO_MIN;
    private MaoGUIListener jogador;
    private List<CartaGUI> mao = new ArrayList<>();
    private JPanel painelExterno = new JPanel(new BorderLayout());
    private JPanel painel = new JPanel();

    public MaoGUI() {
        if(TAMANHO_MIN == null)
            inicializaTamanho();

        painelExterno.add(painel, BorderLayout.CENTER);
        painel.setLayout(new FlowLayout());
        painel.add(new CartaGUI());
        add(painelExterno);
    }

    private void inicializaTamanho(){
        //Consertar
        int altura = (int)(Gui.getDimensao().getHeight());
        int largura = (int)(Gui.getDimensao().getWidth());
        TAMANHO_MIN = new Dimension(largura, altura);
    }

    /**
     * Seta a mão atual do jogador
     * 
     * @param mao Array de cartas na mão do jogador
     * @throws Exception Se o array ou algum elemento for nulo
     */
    public void set(CartaGUI[] mao) throws Exception {
        if (mao == null) {
            throw new Exception("Mão é nula");
        }

        if (mao.length == 0)
            limpa();
        else
            preencheMao(mao);
    }

    /**
     * Preenche a lista e o painel com as novas cartas
     * @param mao Array de cartas não null
     * @throws Exception Se algum elemento for null
     */
    private void preencheMao(CartaGUI[] mao) throws Exception {
        this.mao.clear();
        painel.removeAll();
        for (int i = 0; i < mao.length; i++) {
            if (mao[i] == null) {
                throw new Exception("CartaGUI Null na Mao!" + i);
            }
            this.mao.add(mao[i]);
            mao[i].addMouseListener(this);
            painel.add(mao[i]);
        }
    }

    /**
     * Limpa o painel e a lista da mao, tornando a mão vazia
     */
    public void limpa() {
        mao.clear();
        painel.removeAll();
        painel.add(new CartaGUI());
    }

    /**
     * Retorna a quantidade de cartas nessa mão
     * @return Quantidade de cartas nessa mão
     */
    public int quantidade() {
        return this.mao.size();
    }

    /**
     * Adiciona um Listener a esta mao
     * @param jogador Ouvinte
     */
    public void setListener(MaoGUIListener jogador){
        this.jogador = jogador;
    }


    //Eventos MouseListener
    @Override
    public void mouseClicked(MouseEvent e) {
        this.setVisible(false);
        if(jogador != null && e.getSource() instanceof CartaGUI){
            CartaGUI fonte = (CartaGUI)e.getSource();
            jogador.jogadaFeita(fonte.getNome());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}   

}