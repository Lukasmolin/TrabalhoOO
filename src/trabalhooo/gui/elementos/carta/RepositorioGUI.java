package trabalhooo.gui.elementos.carta;

import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class RepositorioGUI {
    private static boolean estaPronto = false;
    private static Path pasta;
    private static Dimension tamanho;
    private static Map<String, Image> cache = new HashMap<>();
    private RepositorioGUI(){};
    
    /**
     * Seta o caminho da pasta onde estão as imagens do Jogo
     * @param caminho Caminho da pasta
     * @throws Exception Se o caminho não existir ou for nulo
     */
    public static void setCaminho(String caminho) throws Exception{
        if(caminho == null) { throw new NullPointerException("O caminho é null!"); }
        Path p = FileSystems.getDefault().getPath(caminho);
        if (!Files.exists(p)) { throw new Exception("Caminho da pasta de imagens não encontrado!"); }
        pasta = p;
    }

    /**
     * Retorna uma string com o caminho selecionado ou em branco caso nenhum tenha sido selecionado
     * @return Caminho
     */
    public static String getCaminho(){
        if(pasta != null)
            return pasta.toString();
        else
            return "";
    }

    /**
     * @param nomeDaCarta nome da carta
     * @return Imagem da carta
     * @throws Exception Se não conseguir resgatar a imagem
     */
    public static Image getImagem(String nomeDaCarta) throws Exception{
        if(tamanho == null) { throw new NullPointerException("O tamanho não foi inicializado!"); }
        if(pasta == null) { throw new Exception("O caminho não foi inicializado."); }
        nomeDaCarta = nomeDaCarta.toLowerCase();
        nomeDaCarta = nomeDaCarta.replace(" ", "_");        
        File arq = new File(pasta.toString(), nomeDaCarta+".png");
        Image original = null;
        if(!cache.containsKey(nomeDaCarta)){
            try {
                original = ImageIO.read(arq);                
            } catch (Exception e){
                try{
                    original = ImageIO.read(new File(pasta.toString(), "null.png"));
                } catch (Exception ex){
                    ex.printStackTrace();
                }
            }
            Image escalada = original.getScaledInstance((int)tamanho.getWidth(), (int)tamanho.getHeight(), Image.SCALE_FAST);
            cache.put(nomeDaCarta, escalada);               
        }
        
        
        
        return cache.get(nomeDaCarta);
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