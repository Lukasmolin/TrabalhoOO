/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhooo.jogo.cartas;

/**
 * Construtor de CartaAgil
 * @author izabe
 */
public class CartaAgil extends CartaPontuada{

    private final String descricao;

    public CartaAgil(String nome, Faccao faccao, int fileira, String tipo, int pontuacao) {
        super(nome, faccao, fileira, tipo, pontuacao);
        this.descricao = "Pode ser colocada tanto na fileira de combate corporal como em combate a distância.";
    }
    
    
    /**
     * Retorna descricao
     * @return 
     */
    public String getDescricao(){
        return this.descricao;
    }
    
    @Override
    public void getEfeito(Efeito efeito) {
        
        efeito.CartaAgil(this);
    }
    
}
