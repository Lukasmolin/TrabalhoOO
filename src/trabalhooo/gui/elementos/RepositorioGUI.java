package trabalhooo.gui.elementos;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class RepositorioGUI {
    private static Path pasta;
    private static Dimension tamanho;
    private RepositorioGUI(){};

    //Temp
    private static Image img;

    /**
     * Seta o caminho da pasta onde estão as imagens do Jogo
     * @param caminho Caminho da pasta
     * @throws Exception Se o caminho não existir
     */
    public static void setCaminho(String caminho) throws Exception{
        Path p = FileSystems.getDefault().getPath(caminho);
        System.out.println(p.toString()); //Temp
        if (!Files.exists(p)) { throw new Exception("Caminho da pasta de imagens não encontrado!"); }
        pasta = p;
    }

    /**
     * @param nomeDaCarta nome da carta
     * @return Imagem da carta
     * @throws Exception Se não conseguir resgatar a imagem
     */
    public static Image getImagem(String nomeDaCarta) throws Exception{
        if(img == null){
            Image original = ImageIO.read(new File("C:/Users/Lucas/Pictures/Saved Pictures/PurpleCode.jpg"));
            img = original.getScaledInstance((int)tamanho.getWidth(), (int)tamanho.getHeight(), Image.SCALE_FAST);
        }
        
        
        /*BufferedImage original = ImageIO.read(new File("C:/Users/Lucas/Pictures/Saved Pictures/PurpleCode.jpg"));
        BufferedImage nova = new BufferedImage(40, 40, BufferedImage.TYPE_INT_ARGB);
        Graphics2D motorGrafico = nova.createGraphics();
        motorGrafico.drawImage(original, 0, 0, 40, 40, null);
        motorGrafico.dispose();*/
        return img;
        
        /*if (pasta == null) { throw new Exception("Caminho para as imagens não foi setado!"); }
        String textoCaminho = pasta.toString() + "/" + nomeDaCarta + ".jpg";
        Path caminho = FileSystems.getDefault().getPath(textoCaminho);
        if (!Files.exists(caminho)) { throw new Exception("Caminho para a imagem inválido: " + textoCaminho); }
        ImageIcon imagem = new ImageIcon(caminho.toString());
        return imagem;*/
    }

    /**
     * Seta o tamanho das imagens para o armazenamento do repositorio
     * @param tam Tamanho das imagens
     */
    public static void setTamanho(Dimension tam){
        tamanho = new Dimension(tam);
    }

    /**
     * Retorna uma cópia das dimensões atuais ou null se ainda não tiver sido setado
     * @return tamanho atual
     */
    public static Dimension getTamanho(){
        return (tamanho == null ? null : new Dimension(tamanho));
    }


}