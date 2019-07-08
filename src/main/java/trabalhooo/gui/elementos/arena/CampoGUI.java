package trabalhooo.gui.elementos.arena;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import trabalhooo.gui.elementos.carta.CartaGUI;

/**
 * Classe que agrupa as fileiras de um jogador no tabuelrio
 */
public class CampoGUI extends JPanel {
    //Serializable
    private static final long serialVersionUID = 1L;
    
    private static final int QUANTIDADE = 3;
    private FileiraGUI[] fileiras;
    private JLabel[] pontuacoes_fileira;
    private JPanel[] paineis_fileira;    

    public CampoGUI(){
        setLayout(new GridLayout(QUANTIDADE,2));
        inicializaPaineis();
        inicializaPontuacoes();
        inicializaFileiras();
        estruturaPaineis();
    }

    private final void inicializaPaineis(){
        paineis_fileira = new JPanel[QUANTIDADE];
        for(int i = 0; i < paineis_fileira.length; i++){
            paineis_fileira[i] = new JPanel();
        }
    }

    private final void inicializaPontuacoes(){
        pontuacoes_fileira = new JLabel[QUANTIDADE];
        for(int i = 0; i < pontuacoes_fileira.length; i++){
            pontuacoes_fileira[i] = new JLabel("0");
        }
    }

    private final void inicializaFileiras(){
        fileiras = new FileiraGUI[QUANTIDADE];
        for(int i = 0; i < fileiras.length; i++){
            fileiras[i] = new FileiraGUI();
            add(fileiras[i]);
        }
    }

    private final void estruturaPaineis(){
        for(int i = 0; i < QUANTIDADE; i++){
            add(pontuacoes_fileira[i]);
            add(fileiras[i]);
        }
    }

    /**
     * Seta a pontuação de cada fileira, indices excedentes serão desconsiderados
     * @param pontos
     * @throws Exception se o array ou algum de seus elementos for null
     * @throws Exception se o tamanho do array for inferior a quantidade de fileiras de um jogador
     */
    public void setPontosFileira(String[] pontos) throws Exception{
        if(pontos == null) { throw new NullPointerException("Array de pontos é null!"); }
        if(pontos.length < QUANTIDADE) {
            throw new ArrayIndexOutOfBoundsException("Array de pontos menor que quantidade de fileiras!");
        }

        boolean elementoNull = false;
        for(int i = 0; i < QUANTIDADE; i++){
            if(pontos[i] != null) {
                pontuacoes_fileira[i].setText(pontos[i]);
            } else {
                elementoNull = true;
                pontuacoes_fileira[i].setText("");
            }
        }
        if(elementoNull) { throw new NullPointerException("Elemento nulo dentro do array!"); }
    }

    /**
     * Seta as três fileiras de uma vez, indices excedentes serão descartados, arrays de tamanho(length) zero
     * serão considerados como um campo vazio
     * @param campo Matriz com as cartas do Campo
     * @throws Exception Se a matriz campo for null, se alguma fileiraGUI for null, se alguma cartaGUI for null
     */
    public void setCampo(CartaGUI[][] campo) throws Exception{
        if(campo == null) { throw new NullPointerException("Campo Null"); }
        if(campo.length == 0){
            for(int i = 0; i < fileiras.length; i++){
                fileiras[i].setFileira(new CartaGUI[0]);
            }
        } else {
            for(int i = 0; i < fileiras.length && i < campo.length; i++){
                fileiras[i].setFileira(campo[i]);
            }
        }
        this.setVisible(true);
    }
}