package trabalhooo.gui.elementos.arena;

import java.awt.FlowLayout;
import javax.swing.JPanel;

import trabalhooo.gui.elementos.carta.CartaGUI;

/**
 * Classe que representa uma fileira no tabuleiro de um jogador
 */
public class FileiraGUI extends JPanel {
    //ID Serializavel
    private static final long serialVersionUID = -4696099802481110108L;

    public FileiraGUI() {
        setLayout(new FlowLayout());
        add(new CartaGUI());
    }

    /**
     * Atualiza as carats na fileira
     * @param cartas cartas na fileira
     * @throws Exception se cartas for null ou se algum indice de cartas for null
     */
    public void setFileira(CartaGUI[] cartas) throws Exception{
        if (cartas == null) { throw new Exception("Array de CartaGUI Null!"); }

        removeAll();
        if(cartas.length == 0){
            add(new CartaGUI());
        } else {
            for(CartaGUI carta : cartas){
                if(carta == null) {
                    removeAll();
                    add(new CartaGUI());
                    throw new Exception("CartaGUI Null!");
                }
                add(carta);
            }
        }
    }
}