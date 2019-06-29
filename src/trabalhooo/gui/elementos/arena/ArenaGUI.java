package trabalhooo.gui.elementos.arena;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import trabalhooo.gui.elementos.carta.CartaGUI;

/**
 * Classe representa a arena do jogo, contém as fileiras, cemiterios e
 * pontuações de ambos os jogadores
 */
public class ArenaGUI extends JPanel {
    private CampoGUI[] campos = new CampoGUI[2];
    private List<CartaGUI> climas = new ArrayList<>();
    private JLabel climas_rotulo = new JLabel("Climas:");
    private JPanel climas_panel = new JPanel();
    private JPanel campos_painel = new JPanel();

    public ArenaGUI() {
        inicializaArena();
        setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    }

    private void inicializaArena() {
        setLayout(new FlowLayout());
        inicializaCampos();
        inicializaClimas();
        
        add(campos_painel);
        add(climas_panel);
    }

    private void inicializaCampos(){
        campos[0] = new CampoGUI();
        campos[1] = new CampoGUI();
        campos_painel.setLayout(new BoxLayout(campos_painel, BoxLayout.Y_AXIS));
        
        campos_painel.add(campos[0]);
        campos_painel.add(campos[1]);
    }

    private void inicializaClimas(){
        climas_panel.setLayout(new GridLayout(0, 1));
        climas_panel.add(climas_rotulo);
        climas_panel.add(new CartaGUI());
    }

    /**
     * Seta as cartaGUI no campo um
     * @param campo Matriz do campo a ser setado
     */
    public void setCampoUm(CartaGUI[][] campo) throws Exception{
        campos[0].setCampo(campo);
    }

    /**
     * Seta as cartaGUI no campo dois
     * @param campo Matriz do campo a ser setado
     */
    public void setCampoDois(CartaGUI[][] campo) throws Exception{
        campos[1].setCampo(campo);
    }

    /**
     * Seta a pontuação de cada uma das fileiras do jogador
     * @param pontos Array contendo a pontuação para cada uma das fileiras
     * @throws Exception se o array ou algum de seus elementos for null
     * @throws Exception se o tamanho do array for inferior a quantidade de fileiras de um jogador
     */
    public void setPontosCampoUm(String[] pontos) throws Exception{
        campos[0].setPontosFileira(pontos);
    }

    /**
     * Seta a pontuação de cada uma das fileiras do jogador
     * @param pontos Array contendo a pontuação para cada uma das fileiras
     * @throws Exception se o array ou algum de seus elementos for null
     * @throws Exception se o tamanho do array for inferior a quantidade de fileiras de um jogador
     */
    public void setPontosCampoDois(String[] pontos) throws Exception{
        campos[1].setPontosFileira(pontos);
    }

    /**
     * Seta os climas do tabuleiro, um array de tamanho zero limpa o clima
     * @param climas cartas de clima
     */
    public void setClimas(CartaGUI[] climas) throws Exception{
        if(climas == null) { throw new NullPointerException("climas NULL"); }
        
        if(climas.length == 0){
            limpaClimas();
        } else {
            climas_panel.removeAll();
            climas_panel.add(climas_rotulo);
            
            //Adiciona cartas          
            for(int i = 0; i < climas.length; i++){
                if(climas[i] == null) { throw new NullPointerException("CartaClima Null! Indice: " +i); }
                
                climas_panel.add(climas[i]);
            }
        }
    }

    /**
     * Limpa a sessão de climas
     */
    public void limpaClimas(){
        climas.clear();
        climas_panel.removeAll();
        climas_panel.add(climas_rotulo);
        climas_panel.add(new CartaGUI());
    }



}