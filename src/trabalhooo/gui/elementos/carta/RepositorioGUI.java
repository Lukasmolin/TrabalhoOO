package trabalhooo.gui.elementos.carta;

import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.imageio.ImageIO;

public class RepositorioGUI {
    private static boolean estaPronto = false;
    private static Path pasta;
    private static Dimension tamanho;
    private RepositorioGUI(){};

    //Temp
    private static Image img;

    /**
     * Seta o caminho da pasta onde estão as imagens do Jogo
     * @param caminho Caminho da pasta
     * @throws Exception Se o caminho não existir ou for nulo
     */
    public static void setCaminho(String caminho) throws Exception{
        if(caminho == null) { throw new Exception("O caminho é null!"); }
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
        System.out.println(nomeDaCarta+ "  ");
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
     * Retorna se o repositorio está pronto para enviar as imagens
     * @return True se estiver pronto, false senão
     */
    public static boolean estaPronto(){
        return estaPronto;
    }

    /**
     * Retorna se o tamanho das imagens ja foi inicializado
     * @return true se esta inicializado, false senão
     */
    public static boolean tamanhoInicializado(){
        return !(tamanho == null);
    }


}