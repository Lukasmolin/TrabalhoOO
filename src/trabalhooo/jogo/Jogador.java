package trabalhooo.jogo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import trabalhooo.jogo.cartas.Baralho;
import trabalhooo.jogo.cartas.Carta;
import trabalhooo.jogo.cartas.CartaLider;
import trabalhooo.jogo.cartas.Faccao;

/**
 *
 * @author izabe
 * @author Lucas Molin <lucasmolin@ice.ufjf.br>
 */
public class Jogador {
    
    private String nome;
    private Baralho baralho;
    private List<Carta> mao = new ArrayList<>();
    private CartaLider lider;
    private boolean usouLider = false;
    private int vidas = 3;
    private boolean pronto = false;
    
    /**
     * Contrutor do Jogador
     * @param nome Nome do jogador
     */
    public Jogador(String nome){
        this.nome = nome;
    }
    
    /**
     * Setar o nome do Jogador
     * @param nome nome a ser setado
     */
    public void setNome(String nome){
        this.nome = nome;
    }
    
    /**
     * Retorna o nome do Jogador
     * @return o nome do Jogador
     */
    public String getNome(){
        return this.nome;
    }
    
    /**
     * Retorna as vidas do Jogador
     * @return Quantidade de vidas
     */
    public int GetVidas(){
        return this.vidas;
    }
    
    /**
     * Inicia o baralho com a Faccção escolhida
     * @param faccao Facção escolhida
     * @throws Exception se já tiver pedido as cartas iniciais
     */
    public void setBaralho(Faccao faccao){
       //Inicia o baralho com a facção
       baralho = new Baralho(faccao);
       this.lider = baralho.getLider();
       //Retira as 10 primeiras cartas e passa para mão       
       mao.addAll(java.util.Arrays.asList(baralho.getCartasIniciais()));
       this.pronto = true;
    }
    
    /**
     * Reduz em 1 a vida do Jogador
     * @return true se o jogador ainda tiver vidas, false senão
     * @throws Exception se o jogador já tiver zero vidas
     */
    public boolean perdeVida() throws Exception{
        if(this.vidas == 0) {
            throw new Exception("Jogador não pode perder mais vidas pois já tem zero vidas.");
        }
        
        this.vidas--;
        return (vidas > 0);
    }
    
    /**
     * Retorna mão atual do jogador
     * @return Array de Cartas com as cartas na mão do jogador ou null se nao estiver pronto
     */
    public Carta[] getMao(){
        if(pronto){
            Carta[] retornoMao = new Carta[mao.size()];
            retornoMao = mao.toArray(retornoMao);
            return retornoMao;
        }
        return null;           
    }
    
    /**
     * Joga uma carta especificada
     * @param carta Carta a ser jogada
     * @return a Carta se a jogada foi feita, null se o jogador nao possuir a carta na mao
     * @throws Exception se o jogador não possuir a carta
     */
    public Carta jogaCarta(String carta) throws Exception{
        for(Carta c : mao){
            if(c.getNome().equals(carta)){
                Carta cartaJogada = c;
                mao.remove(cartaJogada);
                return cartaJogada;
            }
        }
        throw new Exception("Carta inexistente na mao do Jogador!");
    }
    
    /**
     * Retorna se o jogador está pronto para começar a jogar
     * @return true se está pronto, false senão
     */
    public boolean estaPronto(){
        return this.pronto;
    }

    public boolean liderUsado(){
        return usouLider;
    }
    
    public CartaLider getLider(){
        return this.lider;
    }

    /**
     * Joga a carta Lider
     * @return carta lider jogada
     * @throws Exception se o lider ja foi usado
     */
    public CartaLider jogaCartaLider() throws Exception{
        if(usouLider) { throw new Exception("O lider já foi usado"); }
        
        usouLider = true;
        return this.lider;
    }

    /**
     * Retorna o baralho do Jogador
     * @return baralho do jogador
     */
    public Baralho getBaralho(){
        return this.baralho;
    }

    /**
     * Retorna a faccao do Jogador
     * @return faccao
     */
    public Faccao getFaccao(){
        return this.baralho.getFaccao();
    }
}
