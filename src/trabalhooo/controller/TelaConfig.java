package trabalhooo.controller;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Tela de configuração pre-jogo
 */
public class TelaConfig extends JFrame implements MouseListener {

    //Serializable
    private static final long serialVersionUID = 1L;
    
    private JPanel janela = new JPanel();
    private Controller control;

    private String[] resolucoes = new String[] { "1920x1080", "1280x720", "1024x768", "800x600" };
    private String[] faccoes = new String[] { "Monstros", "NilfGaard", "Reino do Norte", "ScoiaTael" };

    

    private JPanel resolucao_panel = new JPanel();
    private JLabel resolucao_rotulo = new JLabel("Resolução: ");
    private JComboBox<String> resolucao = new JComboBox<>(resolucoes);

    private JPanel nomeUm_panel = new JPanel(new GridLayout(1, 0));
    private JLabel nomeUm_rotulo = new JLabel("Jogador um: ");
    private JTextField nomeUm = new JTextField();

    private JPanel faccaoUm_panel = new JPanel();
    private JLabel faccaoUm_rotulo = new JLabel("Facção: ");
    private JComboBox<String> faccaoUm = new JComboBox<>(faccoes);

    private JPanel nomeDois_panel = new JPanel(new GridLayout(1, 0));
    private JLabel nomeDois_rotulo = new JLabel("Jogador dois: ");
    private JTextField nomeDois = new JTextField();

    private JPanel faccaoDois_panel = new JPanel();
    private JLabel faccaoDois_rotulo = new JLabel("Facção: ");
    private JComboBox<String> faccaoDois = new JComboBox<>(faccoes);

    private JPanel botoes_panel = new JPanel();
    private JButton iniciar = new JButton("INICIAR!");
    private JButton editarCaminho = new JButton("ARQUIVOS");
    private JFileChooser caminho = new JFileChooser();    

    public TelaConfig(Controller control) {
        super("Nova Partida");
        this.control = control;
        adicionaElementos();
        mostraTela();
    }

    private final void adicionaElementos() {
        resolucao_panel.add(resolucao_rotulo);
        resolucao_panel.add(resolucao);

        nomeUm_panel.add(nomeUm_rotulo);
        nomeUm_panel.add(nomeUm);
        faccaoUm_panel.add(faccaoUm_rotulo);
        faccaoUm_panel.add(faccaoUm);

        nomeDois_panel.add(nomeDois_rotulo);
        nomeDois_panel.add(nomeDois);
        faccaoDois_panel.add(faccaoDois_rotulo);
        faccaoDois_panel.add(faccaoDois);

        botoes_panel.add(iniciar);
        botoes_panel.add(editarCaminho);

        caminho.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        janela.setLayout(new GridLayout(0, 1));
        getContentPane().add(janela);
        janela.add(resolucao_panel);
        janela.add(nomeUm_panel);
        janela.add(faccaoUm_panel);
        janela.add(nomeDois_panel);
        janela.add(faccaoDois_panel);
        janela.add(botoes_panel);
        iniciar.addMouseListener(this);
        editarCaminho.addMouseListener(this);
    }

    private final void mostraTela() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(200, 230));
        setSize(new Dimension(200, 230));
        setVisible(true);
    }

    private final void iniciaJogo(){
        String nome_um = nomeUm.getText();
        String nome_dois = nomeDois.getText();
        int faccao_um = faccaoUm.getSelectedIndex();
        int faccao_dois = faccaoDois.getSelectedIndex();
        int res = resolucao.getSelectedIndex();
        control.iniciarPartida(nome_um, nome_dois, faccao_um, faccao_dois, res);
    }

    //MouseListener Eventos
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(iniciar)){
            iniciaJogo();
        } else if (e.getSource().equals(editarCaminho)) {
            if (caminho.showOpenDialog(botoes_panel) == JFileChooser.APPROVE_OPTION){
                control.setCaminho(caminho.getSelectedFile().toString());
            }
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