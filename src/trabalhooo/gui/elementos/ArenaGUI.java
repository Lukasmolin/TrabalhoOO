package trabalhooo.gui.elementos;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Classe representa a arena do jogo, contém as fileiras, cemiterios e
 * pontuações de ambos os jogadores
 */
public class ArenaGUI extends JPanel {
    private CampoGUI[] campos = new CampoGUI[2];
    private List<CartaGUI> climas = new ArrayList<>();
    private JLabel climas_rotulo = new JLabel("Climas:");
    private JPanel climas_panel;
    private JPanel campos_painel;

    public ArenaGUI() {
        inicializaArena();
    }

    private void inicializaArena() {
        setLayout(new GridLayout(1, 2));
        inicializaCampos();
        inicializaClimas();
        
        add(climas_panel);
        add(campos_painel);
    }

    private void inicializaCampos(){
        campos[0] = new CampoGUI();
        campos[1] = new CampoGUI();
        campos_painel = new JPanel();
        campos_painel.add(campos[0]);
        campos_painel.add(campos[1]);
    }

    private void inicializaClimas(){
        climas_panel = new JPanel();
        climas_panel.add(climas_rotulo);
    }

    /**
     * Retorna o campo do Jogador Um
     * @return Campo um
     */
    public CampoGUI getCampoUm(){
        return campos[0];
    }

    /**
     * Retorna o campo do Jogador Dois
     * @return Campo dois
     */
    public CampoGUI getCampoDois(){
        return campos[1];
    }

    /**
     * Seta os climas do tabuleiro
     * @param climas cartas de clima
     */
    public void setClimas(CartaGUI[] climas){
        for(int i = 0; i < climas.length; i++){
            if(!this.climas.contains(climas[i]));
                adicionaClima(climas[i]);
        }
    }

    private void adicionaClima(CartaGUI clima){
        climas.add(clima);
        climas_panel.add(clima);
    }

    /**
     * Limpa a sessão de climas
     */
    public void limpaClimas(){
        climas.clear();
        climas_panel.removeAll();
        climas_panel.add(climas_rotulo);
    }

}