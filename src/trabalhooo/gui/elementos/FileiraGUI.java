package trabalhooo.gui.elementos;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class FileiraGUI extends JScrollPane {
    private JPanel fileira = new JPanel();

    public FileiraGUI(){
        this.setViewportView(fileira);
        this.setVisible(true);
    }

    /**
     * Atualiza as carats na fileira 
     * @param cartas cartas na fileira
     */
    public void setFileira(CartaGUI[] cartas) {
        // A fazer
    }
}