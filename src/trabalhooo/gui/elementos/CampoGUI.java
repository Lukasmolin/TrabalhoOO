package trabalhooo.gui.elementos;

import javax.swing.JPanel;

public class CampoGUI extends JPanel {
    private FileiraGUI[] fileiras = new FileiraGUI[3];

    public CampoGUI(){
        inicializaFileiras();
    }

    /**
     * Inicializa as fileiras
     */
    private final void inicializaFileiras(){
        for(FileiraGUI f : fileiras){
            f = new FileiraGUI();
        }
    }

    public FileiraGUI getFileira(int i){
        return fileiras[i];
    }
}