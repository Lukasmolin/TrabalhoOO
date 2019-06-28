package trabalhooo.gui.elementos;

import java.awt.FlowLayout;

import javax.swing.JPanel;

/**
 * Classe que representa uma fileira no tabuleiro de um jogador
 */
public class FileiraGUI extends JPanel {
    //ID Serializavel
    private static final long serialVersionUID = -4696099802481110108L;

    public FileiraGUI() {
        setLayout(new FlowLayout());
    }

    /**
     * Atualiza as carats na fileira
     * @param cartas cartas na fileira
     */
    public void setFileira(CartaGUI[] cartas) {
        removeAll();
        for(CartaGUI carta : cartas){
            add(carta);
        }
    }
    
}