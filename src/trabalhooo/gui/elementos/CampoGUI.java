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
     * Seta as três fileiras de uma vez, indices excedentes serão descartados, arrays de tamanho(length) zero
     * serão considerados como um campo vazio
     * @param campo Matriz com as cartas do Campo
     * @throws Exception Se a matriz campo for null, se alguma fileiraGUI for null, se alguma cartaGUI for null
     */
    public void setCampo(CartaGUI[][] campo) throws Exception{
        if(campo == null) { throw new Exception("Campo Null"); }
        if(campo.length == 0){
            for(int i = 0; i < fileiras.length; i++){
                fileiras[i].setFileira(new CartaGUI[0]);
            }
        } else {
            for(int i = 0; i < fileiras.length && i < campo.length; i++){
                fileiras[i].setFileira(campo[i]);
            }
        }        
    }
}