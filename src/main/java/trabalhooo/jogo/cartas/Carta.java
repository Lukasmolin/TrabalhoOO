package trabalhooo.jogo.cartas;
/**
 *
 * @author izabe
 */
public abstract class Carta {
    
    private final String nome;
    private final String tipo;
    protected String descricao;
    private Faccao faccao;
    private int fileira;
    private int pontuacao;
        
    /**
     * Cria um objeto carta com os parametros passados
     * @param nome Nome da carta
     * @param faccao Faccao da carta
     * @param fileira
     * @param tipo
     */
    public Carta(String nome, Faccao faccao, int fileira, String tipo){
        this.nome = nome;
        this.faccao = faccao;
        this.fileira = fileira;
        this.tipo = tipo;
    }
    
    /**
     * Retorna o nome da carta
     * @return Nome da carta 
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Retorna o atributo fileira
     * @return o atributo fileira
     */
    public int getFileira(){
        return this.fileira;
    }
    
    /**
     * Modifica o atributo fileira
     * @param novaFileira nova identificação de fileira da carta
     */
    public void setFileira(int novaFileira){
        this.fileira = novaFileira;
    }
    
    /**
     * Modifica pontuação da carta
     * @param novaPontuacao
     */
    public void setPontuacao(int novaPontuacao){
        this.pontuacao = novaPontuacao;
    }
    
    /**
     * retorna a pontuação
     * @return a pontuação da carta
     */
    public int getPontuacao(){
        return this.pontuacao;
    }
    
    /**
     * Adiciona uma descricao a carta
     * @param descricao
     */
    public void setDescricao(String descricao){
       this.descricao = descricao; 
    }

    public String getDescricao(){
        return this.descricao;
    }
    
    /**
     * Retorna o atributo tipo
     * @return 
     */
    public String getTipo(){
        return this.tipo;
    }

    /**
     * Retorna a faccao da carta
     * @return
     */
    public Faccao getFaccao(){
        return this.faccao;
    }
    
    /**
     * Retorna se a carta é igual a comparada
     * @param carta Carta a ser comparada
     * @return True se for a mesma, False se diferente
     */
    public boolean eIgual(Carta carta){
        return this.nome.equals(carta.nome);
    }
    
    /**
     * Retorna o efeito da carta
     */
     public abstract void getEfeito(Efeito efeito);


     //Override para que o metodo remove da lista identifique como cartas iguais
     @Override
     public boolean equals(Object obj){
        if(obj instanceof Carta){
            Carta compara = (Carta)obj;
            if(compara.nome.equals(this.nome)){
                return true;
            }
        }
        return false;
     }
    
    
    

    
    
    
   
    
}
