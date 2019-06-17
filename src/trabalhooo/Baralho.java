/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhooo;

import java.util.ArrayList;

/**
 *
 * @author izabe
 */
public class Baralho {
    
    private ArrayList<Carta> monstros = new ArrayList<>();
    
    public Baralho (){
        this.monstros.add(new Carta("Earth Elemental",6,3));
        this.monstros.add(new Carta("Aracha",4,1));
        this.monstros.add(new Carta("Cockatrice",2,2));
        this.monstros.add(new Carta("Celaeno Harpy",2,2));
        this.monstros.add(new Carta("Botchling",4,1));
        this.monstros.add(new Carta("Arachas Behemoth",6,3));
        this.monstros.add(new Carta("Endrega",2,2));
        this.monstros.add(new Carta("Fiend",6,1));
        this.monstros.add(new Carta("Fire Elemental",6,3));
        this.monstros.add(new Carta("Foglet",2,1));
        this.monstros.add(new Carta("Forktail",6,1));
        this.monstros.add(new Carta("Crone Whispess",6,1));
        this.monstros.add(new Carta("Crone Brewess",6,1));
        this.monstros.add(new Carta("Crone Weaves",6,1));
        this.monstros.add(new Carta("Grave Hag",6,2));
        this.monstros.add(new Carta("Griffin",5,1));
        this.monstros.add(new Carta("Ghoul",1,1));
        this.monstros.add(new Carta("Gargoyle",2,2));
        this.monstros.add(new Carta("Frightener",5,1));
        this.monstros.add(new Carta("Ice Giant",5,3));
        this.monstros.add(new Carta("Harpy",2,2));
        this.monstros.add(new Carta("Nekker",2,1));
        this.monstros.add(new Carta("Plague Maiden",5,1));
        this.monstros.add(new Carta("Toad",7,2));
        this.monstros.add(new Carta("Vampire Bruxa",4,1));
        this.monstros.add(new Carta("Vampire Ekimmara",4,1));
        this.monstros.add(new Carta("Vampire Fleder",4,1));
        this.monstros.add(new Carta("Vampire Garkain",4,1));
        this.monstros.add(new Carta("Vampire Katakan",5,1));
        this.monstros.add(new Carta("Werewolf",5,1));
        this.monstros.add(new Carta("Wyvern",2,2));
    }

    /**
     * @return the monstros
     */
    public ArrayList<Carta> getMonstros() {
        return monstros;
    }
    
    
    
    
}
