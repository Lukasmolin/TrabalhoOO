package trabalhooo.gui.elementos;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * Classe que agrupa as fileiras de um jogador no tabuelrio
 */
public class CampoGUI extends JPanel {
    private FileiraGUI[] fileiras;

    public CampoGUI(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        inicializaFileiras();
    }

    /**
     * Inicializa as fileiras
     */
    private final void inicializaFileiras(){
        fileiras = new FileiraGUI[3];
        for(int i = 0; i < fileiras.length; i++){
            fileiras[i] = new FileiraGUI();
            add(fileiras[i]);
        }
    }

    /**
     * Retorna a fileira
     * @param i fileira
     * @return fileira desejada ou null se indice for inválido
     */
    public FileiraGUI getFileira(int i){
        return fileiras[i];
    }

    /**
     * Seta as três fileiras de uma vez, indices excedentes serão descartados
     * @param campo Matriz com as cartas do Campo
     */
    public void setCampo(CartaGUI[][] campo) {
        for(int i = 0; i < fileiras.length && i < campo.length; i++){
            fileiras[i].setFileira(campo[i]);
        }
    }
}