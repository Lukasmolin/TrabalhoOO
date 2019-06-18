/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhooo.jogo.cartas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author izabe
 * @author Lucas Molin <lucasmolin@ice.ufjf.br>
 */
public final class Baralho {
    private List<Carta> baralho; 
    private Carta.Faccao faccao;
    
    /**
     * Contrutor do baralho com a facção desejada
     * @param faccao faccao do baralho
     * @throws Exception se a facção for inválida
     */
    public Baralho(Carta.Faccao faccao) throws Exception{
        this.faccao = faccao;
        reiniciarBaralho(faccao);
    }
    
    /**
     * Reinicia o baralho com uma facção
     * @param faccao facção com a qual reiniciar o baralho
     * @throws Exception se a faccção for inválida
     */
    public void reiniciarBaralho(Carta.Faccao faccao) throws Exception{
        this.faccao = faccao;
        switch (faccao){
            case MONSTROS:
                baralho = getMonstros();
                break;
            default:
                throw new Exception("Faccao inválida");
        }
    }
    
    public Carta[] getCartasIniciais(){
        return null; //A fazer
    }
    
    /**
     * Gera um baralho novo da Facção Monstros
     * @return Lista de cartas contendo o baralho
     */
    private static List<Carta> getMonstros(){
        List<Carta> monstros = new ArrayList<>();
        Carta.Faccao faccao = Carta.Faccao.MONSTROS;
        monstros.add(new CartaSimples("Earth Elemental",faccao,3));
        monstros.add(new CartaSimples("Aracha",faccao,1));
        monstros.add(new CartaSimples("Cockatrice",faccao,2));
        monstros.add(new CartaSimples("Cockatrice",faccao,2));
        monstros.add(new CartaSimples("Cockatrice",faccao,2));
        monstros.add(new CartaSimples("Cockatrice",faccao,2));
        monstros.add(new CartaSimples("Cockatrice",faccao,2));
        monstros.add(new CartaSimples("Cockatrice",faccao,2));
        monstros.add(new CartaSimples("Cockatrice",faccao,2));
        monstros.add(new CartaSimples("Cockatrice",faccao,2));
        monstros.add(new CartaSimples("Cockatrice",faccao,2));
        monstros.add(new CartaSimples("Celaeno Harpy",faccao,2));
        monstros.add(new CartaSimples("Botchling",faccao,1));
        monstros.add(new CartaSimples("Arachas Behemoth",faccao,3));
        monstros.add(new CartaSimples("Endrega",faccao,2));
        monstros.add(new CartaSimples("Fiend",faccao,1));
        monstros.add(new CartaSimples("Fire Elemental",faccao,3));
        monstros.add(new CartaSimples("Foglet",faccao,1));
        monstros.add(new CartaSimples("Forktail",faccao,1));
        monstros.add(new CartaSimples("Crone Whispess",faccao,1));
        monstros.add(new CartaSimples("Crone Brewess",faccao,1));
        monstros.add(new CartaSimples("Crone Weaves",faccao,1));
        monstros.add(new CartaSimples("Grave Hag",faccao,2));
        monstros.add(new CartaSimples("Griffin",faccao,1));
        monstros.add(new CartaSimples("Ghoul",faccao,1));
        monstros.add(new CartaSimples("Gargoyle",faccao,2));
        monstros.add(new CartaSimples("Frightener",faccao,1));
        monstros.add(new CartaSimples("Ice Giant",faccao,3));
        monstros.add(new CartaSimples("Harpy",faccao,2));
        monstros.add(new CartaSimples("Nekker",faccao,1));
        monstros.add(new CartaSimples("Plague Maiden",faccao,1));
        monstros.add(new CartaSimples("Toad",faccao,2));
        monstros.add(new CartaSimples("Vampire Bruxa",faccao,1));
        monstros.add(new CartaSimples("Vampire Ekimmara",faccao,1));
        monstros.add(new CartaSimples("Vampire Fleder",faccao,1));
        monstros.add(new CartaSimples("Vampire Garkain",faccao,1));
        monstros.add(new CartaSimples("Vampire Katakan",faccao,1));
        monstros.add(new CartaSimples("Werewolf",faccao,1));
        monstros.add(new CartaSimples("Wyvern",faccao,2));
        Collections.shuffle(monstros); //Mistura a lista
        return monstros;
    }
    
    
    
    
    
}
