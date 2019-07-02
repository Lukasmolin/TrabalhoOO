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
    private Faccao faccao;
    private Carta lider;
    private boolean comecou = false; 
    private int troca = 0; //Trocas d ecarta iniciais
    
    /**
     * Contrutor do baralho com a facção desejada
     * @param faccao faccao do baralho
     */
    public Baralho(Faccao faccao) {
        this.faccao = faccao;
        reiniciarBaralho(faccao);
    }
    
    /**
     * Reinicia o baralho com uma facção
     * @param faccao facção com a qual reiniciar o baralho
     */
    public void reiniciarBaralho(Faccao faccao){
        this.faccao = faccao;
        switch (faccao){
            case MONSTROS:
                baralho = getMonstros(getNeutro());
                break;
            case NILFGAARD:
                baralho = getNilfgaard(getNeutro());
                break;
            case REINO_DO_NORTE:
                baralho = getReinosDoNorte(getNeutro());
                break;
            case SCOIATAEL:
                baralho = getScoiaTael(getNeutro());
                break;
        }
    }
    
    /**
     * Retorna as cartas iniciais do jogo
     * @return Array de 10 cartas iniciais do jogo
     * @throws Exception se Já pediu as Cartas Iniciais
     */
    public Carta[] getCartasIniciais(){
        if(comecou) {
           reiniciarBaralho(faccao); 
        }
        
        comecou = true;
        Carta[] cartasIniciais = new Carta[10];
        cartasIniciais = baralho.subList(0, 10).toArray(cartasIniciais);
        baralho.removeAll(baralho.subList(0, 10));
        return cartasIniciais;
    }
    
    /**
     * Troca uma carta por outra do baralho
     * @param carta Carta a ser devolvida ao deck
     * @return Carta nova recebida se a troca for possivel, null se não tiver mais trocas
     */
    public Carta trocaCarta(Carta carta){
        if(troca >= 3)
            return null;
        
        this.troca++;
        baralho.add(carta);
        return baralho.get(0);
    }
    
    /**
     * 
     * @return retorna o baralho do jogador
     */
    public List<Carta> getBaralho(){
        return this.baralho;
    }
    
    /**
     * 
     * @return 
     */
    public Carta getLider(){
        return this.lider;
    }
    
    /**
     * Gera um baralho novo da Facção Monstros
     * @return Lista de cartas contendo o baralho
     */
    private static List<Carta> getMonstros(List<Carta> neutro){
       
        List<Carta> monstros = new ArrayList<>();
        monstros.addAll(neutro);
        Faccao faccao = Faccao.MONSTROS;
        Carta lider = new CartaLider("Eredin: King of the Wild Hunt",faccao,4,"Leader",001);
        monstros.add(new CartaCoragem("Arachas I",faccao,1,"Arachas",4));
        monstros.add(new CartaCoragem("Arachas II",faccao,1,"Arachas",4));
        monstros.add(new CartaCoragem("Arachas III",faccao,1,"Arachas",4));        
        monstros.add(new CartaCoragem("Arachas Behemoth",faccao,3,"Arachas",6));
        monstros.add(new CartaSimples("Botchling",faccao,1,"Botchling",4));
        monstros.add(new CartaAgil("Calaeno Harpy",faccao,1,"Harpy",2));
        monstros.add(new CartaSimples("Cockatrice", faccao,2,"Cockatrice",2));
        monstros.add(new CartaCoragem("Crone Brewess",faccao,1,"Crone",6));
        monstros.add(new CartaCoragem("Crone Weavess",faccao,1,"Crone",6));
        monstros.add(new CartaCoragem("Crone Whispess",faccao,1,"Crone",6));
        monstros.add(new CartaHeroi("Draug",faccao,1,"Hero",10));
        monstros.add(new CartaSimples("Earth Elemental",faccao,3,"Elemental",6));
        monstros.add(new CartaSimples("Endrega",faccao,2,"Endrega",2));
        monstros.add(new CartaSimples("Fiend",faccao,1,"Fiend",6));
        monstros.add(new CartaSimples("Fire Elemental",faccao,3,"Elemental",6));
        monstros.add(new CartaSimples("Foglet",faccao,1,"Foglet",2));
        monstros.add(new CartaSimples("Forktail",faccao,1,"Forktail",5));
        monstros.add(new CartaSimples("Frightener",faccao,1,"Frightener",5));
        monstros.add(new CartaSimples("Gargoyle",faccao,2,"Gargoyle",2));
        monstros.add(new CartaCoragem("Ghoul I",faccao,1,"Ghoul",1));
        monstros.add(new CartaCoragem("Ghoul II",faccao,1,"Ghoul",1));
        monstros.add(new CartaCoragem("Ghoul III",faccao,1,"Ghoul",1));
        monstros.add(new CartaSimples("Grave Hag",faccao,2,"Grave Hag",5));
        monstros.add(new CartaSimples("Griffin",faccao,1,"Griffin",5));
        monstros.add(new CartaAgil("Harpy",faccao,2,"Harpy",2));
        monstros.add(new CartaSimples("Ice Giant",faccao,3,"Giant",5));
        monstros.add(new CartaHeroi("Imlerith",faccao,1,"Hero",10));
        monstros.add(new CartaHeroi("Kayran",faccao,2,"Hero",8));
        monstros.add(new CartaHeroi("Leshen",faccao,2,"Hero",10));
        monstros.add(new CartaCoragem("Nekker I",faccao,1,"Nekker",2));
        monstros.add(new CartaCoragem("Nekker II",faccao,1,"Nekker",2));
        monstros.add(new CartaCoragem("Nekker III",faccao,1,"Nekker",2));
        monstros.add(new CartaSimples("Plague Maiden",faccao,1,"Plague Maiden",5));
        monstros.add(new CartaQueima("Toad",faccao,2,"Toad",7));
        monstros.add(new CartaCoragem("Vampire Bruxa",faccao,1,"Vampire",4));
        monstros.add(new CartaCoragem("Vampire Ekimmara",faccao,1,"Vampire",4));
        monstros.add(new CartaCoragem("Vampire Fleder",faccao,1,"Vampire",4));
        monstros.add(new CartaCoragem("Vampire Garkain",faccao,1,"Vampire",4));
        monstros.add(new CartaCoragem("Vampire Katakan",faccao,1,"Vampire",4));
        monstros.add(new CartaSimples("Werewolf",faccao,1,"Werewolf",5));
        monstros.add(new CartaSimples("wyvern",faccao,2,"Wyvern",2));
        
        Collections.shuffle(monstros); //Mistura a lista
        monstros.add(0, lider);
        return monstros;
    }  
    
    /**
     * Gera um baralho novo da Facção Nilfgaard
     * @return Lista de cartas contendo o baralho
     */
    private static List<Carta> getNilfgaard(List<Carta> neutro){
        List<Carta> nilfgaard = new ArrayList<>();
        nilfgaard.addAll(neutro);
        Faccao faccao = Faccao.NILFGAARD;
        Carta lider = new CartaLider("Emhyr var Emreis: The Relentless",faccao,4,"Leader",002);
        nilfgaard.add(new CartaSimples("Albrich",faccao,2,"Unit",2));
        nilfgaard.add(new CartaSimples("Assire var Anahid",faccao,2,"Unit",6));
        nilfgaard.add(new CartaSimples("Black Infantry Archer I",faccao,2,"Unit",10));
        nilfgaard.add(new CartaSimples("Black Infantry Archer II",faccao,2,"Unit",10));
        nilfgaard.add(new CartaSimples("Cahir Mawr Dyffryn aep Ceallach",faccao,1,"Unit",6));
        nilfgaard.add(new CartaSimples("Cynthia",faccao,2,"Unit",4));
        nilfgaard.add(new CartaMedico("Etolian Auxiliary Archers I",faccao,2,"Unit",1));
        nilfgaard.add(new CartaMedico("Etolian Auxiliary Archers II",faccao,2,"Unit",1));
        nilfgaard.add(new CartaSimples("Fringilla Vigo",faccao,2,"Unit",6));
        nilfgaard.add(new CartaSimples("Heavy Zerrikanian Fire Scorpion",faccao,3,"Unit",10));
        nilfgaard.add(new CartaEloForte("Impera Brigade Guard",faccao,1,"Unit",3));
        nilfgaard.add(new CartaEloForte("Impera Brigade Guard",faccao,1,"Unit",3));
        nilfgaard.add(new CartaEloForte("Impera Brigade Guard",faccao,1,"Unit",3));
        nilfgaard.add(new CartaEloForte("Impera Brigade Guard",faccao,1,"Unit",3));
        nilfgaard.add(new CartaHeroi("Letho of Gulet",faccao,1,"Hero",10));
        nilfgaard.add(new CartaHeroi("Menno Coehoorn",faccao,1,"Hero",10));
        nilfgaard.add(new CartaSimples("Morteisen",faccao,1,"Unit",3));
        nilfgaard.add(new CartaHeroi("Morvran Voohis",faccao,3,"Hero",10));
        nilfgaard.add(new CartaEloForte("Nausicaa Cavalry Rider",faccao,1,"Unit",2));
        nilfgaard.add(new CartaEloForte("Nausicaa Cavalry Rider",faccao,1,"Unit",2));
        nilfgaard.add(new CartaSimples("Puttkammer",faccao,2,"Unit",3));
        nilfgaard.add(new CartaSimples("Rainfarn",faccao,1,"Unit",4));
        nilfgaard.add(new CartaSimples("Renuald aep Matsen",faccao,2,"Unit",5));
        nilfgaard.add(new CartaSimples("Rotten Mangonel",faccao,3,"Unit",3));
        nilfgaard.add(new CartaEspiao("Shilard Fitz-Oesterlen",faccao,1,"Unit",7));
        nilfgaard.add(new CartaSimples("Siege Engineer",faccao,3,"Unit",6));
        nilfgaard.add(new CartaMedico("Siege Technician",faccao,3,"Unit",0));
        nilfgaard.add(new CartaEspiao("Stefan Skellen",faccao,1,"Unit",9));
        nilfgaard.add(new CartaSimples("Sweers",faccao,2,"Unit",2));
        nilfgaard.add(new CartaHeroi("Tibor Eggebracht",faccao,2,"Hero",10));
        nilfgaard.add(new CartaSimples("Vanhemar",faccao,2,"Unit",4));
        nilfgaard.add(new CartaEspiao("Vattier de Rideaux",faccao,1,"Unit",4));
        nilfgaard.add(new CartaSimples("Young Emissary I",faccao,1,"Unit",5));
        nilfgaard.add(new CartaSimples("Young Emissary II",faccao,1,"Unit",5));
        nilfgaard.add(new CartaSimples("Zerrikanian Fire Scorpion",faccao,3,"Unit",5));
        
        Collections.shuffle(nilfgaard); //Mistura a lista
        nilfgaard.add(0, lider);
        return nilfgaard;
    }
    
    /**
     * Gera um baralho novo da facção Reinos do Norte  
     * @return Lista de cartas contendo o baralho
     */
    public static List<Carta> getReinosDoNorte(List<Carta> neutro){
        List<Carta> reinosdonorte = new ArrayList<>();
        reinosdonorte.addAll(neutro);
        Faccao faccao = Faccao.REINO_DO_NORTE;
        Carta lider = new CartaLider("Foltest: The Siegemaster",faccao,4,"Leader",003);
        reinosdonorte.add(new CartaHeroi("Esterad",faccao,1,"Hero",10));
        reinosdonorte.add(new CartaEloForte("Blue Stripes Commando",faccao,1,"Unit",4));
        reinosdonorte.add(new CartaEloForte("Blue Stripes Commando",faccao,1,"Unit",4));
        reinosdonorte.add(new CartaHeroi("John Natalis",faccao,1,"Hero",10));
        reinosdonorte.add(new CartaEloForte("Poor Fucking Infantry",faccao,1,"Unit",1));
        reinosdonorte.add(new CartaEloForte("Poor Fucking Infantry",faccao,1,"Unit",1));
        reinosdonorte.add(new CartaEspiao("Prince Stennis",faccao,1,"Unit",5));
        reinosdonorte.add(new CartaSimples("Redanian Foot Soldier I",faccao,1,"Unit",1));
        reinosdonorte.add(new CartaSimples("Redanian Foot Soldier II",faccao,1,"Unit",1));
        reinosdonorte.add(new CartaSimples("Siegfried of Danesie",faccao,1,"Unit",5));
        reinosdonorte.add(new CartaEspiao("Sigismund Dijkstra",faccao,1,"Unit",4));
        reinosdonorte.add(new CartaHeroi("Vernon Roche",faccao,1,"Hero",10));
        reinosdonorte.add(new CartaSimples("Ves",faccao,1,"Unit",5));
        reinosdonorte.add(new CartaSimples("Yarpen Zigrin",faccao,1,"Unit",2));
        reinosdonorte.add(new CartaAumentoMoral("Kaedweni Siege Expert",faccao,3,"Unit",1));
        reinosdonorte.add(new CartaEloForte("Catapult",faccao,3,"Unit",8));
        reinosdonorte.add(new CartaEloForte("Catapult",faccao,3,"Unit",8));
        reinosdonorte.add(new CartaSimples("Ballista I",faccao,3,"Unit",6));
        reinosdonorte.add(new CartaSimples("Ballista II",faccao,3,"Unit",6));
        reinosdonorte.add(new CartaMedico("Dun Banner Medic",faccao,3,"Unit",5));
        reinosdonorte.add(new CartaSimples("Siege Tower",faccao,3,"Unit",6));
        reinosdonorte.add(new CartaEspiao("Thaler",faccao,3,"Unit",1));
        reinosdonorte.add(new CartaSimples("Trebuchet I",faccao,3,"Unit",6));
        reinosdonorte.add(new CartaSimples("Trebuchet II",faccao,3,"Unit",6));
        reinosdonorte.add(new CartaSimples("Keira Metz",faccao,2,"Unit",5));
        reinosdonorte.add(new CartaSimples("Dethmold",faccao,2,"Unit",6));
        reinosdonorte.add(new CartaEloForte("Crinfrid Reavers Dragon Hunter",faccao,2,"Unit",5));
        reinosdonorte.add(new CartaEloForte("Crinfrid Reavers Dragon Hunter",faccao,2,"Unit",5));
        reinosdonorte.add(new CartaSimples("Sheldon Skaggs",faccao,2,"Unit",4));
        reinosdonorte.add(new CartaSimples("Sabrina Glevissig",faccao,2,"Unit",4));
        reinosdonorte.add(new CartaHeroi("Philippa Eilhart",faccao,2,"Hero",10));
        reinosdonorte.add(new CartaSimples("Síle de Tansarville",faccao,2,"Unit",5));

        Collections.shuffle(reinosdonorte); //Mistura a lista
        reinosdonorte.add(0, lider);
        return reinosdonorte;
    }
    
    
    /**
     * Gera um baralho novo da facção Scoia Tael 
     * @return Lista de cartas contendo o baralho
     */
    public static List<Carta> getScoiaTael(List<Carta> neutro){
        List<Carta> ScoiaTael = new ArrayList<>();
        ScoiaTael.addAll(neutro);
        Faccao faccao = Faccao.SCOIATAEL;
        Carta lider = new CartaLider("Francesca Findabair: Daisy of the Valley",faccao,4,"Leader",004);
        ScoiaTael.add(new CartaCoragem("Dwarven Skirmisher I",faccao,1,"Dwarven",3));
        ScoiaTael.add(new CartaCoragem("Dwarven Skirmisher II",faccao,1,"Dwarven",3));
        ScoiaTael.add(new CartaCoragem("Dwarven Skirmisher III",faccao,1,"Dwarven",3));
        ScoiaTael.add(new CartaSimples("Dennis Cranmer",faccao,1,"Unit",6));
        ScoiaTael.add(new CartaCoragem("Havekar Smuggler I",faccao,1,"Smuggler",5));
        ScoiaTael.add(new CartaCoragem("Havekar Smuggler II",faccao,1,"Smuggler",5));
        ScoiaTael.add(new CartaCoragem("Havekar Smuggler III",faccao,1,"Smuggler",5));
        ScoiaTael.add(new CartaAumentoMoral("Isengrim Faoiltiarna",faccao,1,"Unit",10));
        ScoiaTael.add(new CartaSimples("Mahakaman Defender I",faccao,1,"Unit",5));
        ScoiaTael.add(new CartaSimples("Mahakaman Defender II",faccao,1,"Unit",5));
        ScoiaTael.add(new CartaSimples("Mahakaman Defender III",faccao,1,"Unit",5));
        ScoiaTael.add(new CartaSimples("Mahakaman Defender IV",faccao,1,"Unit",5));
        ScoiaTael.add(new CartaSimples("Mahakaman Defender V",faccao,1,"Unit",5));
        ScoiaTael.add(new CartaAgil("Filavandrel aen Fidhail",faccao,2,"Unit",6));
        ScoiaTael.add(new CartaAgil("Ciaran aep Easnillien",faccao,2,"Unit",3));
        ScoiaTael.add(new CartaAgil("Barclay Els",faccao,2,"Unit",6));
        ScoiaTael.add(new CartaAgil("Dol Blathanna Scout I",faccao,2,"Unit",6));
        ScoiaTael.add(new CartaAgil("Dol Blathanna Scout II",faccao,2,"Unit",6));
        ScoiaTael.add(new CartaAgil("Dol Blathanna Scout III",faccao,2,"Unit",6));
        ScoiaTael.add(new CartaAgil("Vrihedd Brigade Veteran",faccao,2,"Unit",6));
        ScoiaTael.add(new CartaAgil("Yaevinn",faccao,2,"Unit",5));
        ScoiaTael.add(new CartaQueima("Schirrú",faccao,3,"Unit",8));
        ScoiaTael.add(new CartaCoragem("Elven Skirmisher I",faccao,2,"Skirmisher",2));
        ScoiaTael.add(new CartaCoragem("Elven Skirmisher II",faccao,2,"Skirmisher",2));
        ScoiaTael.add(new CartaCoragem("Elven Skirmisher III",faccao,2,"Skirmisher",2));
        ScoiaTael.add(new CartaSimples("Dol Blathanna Archer",faccao,2,"Unit",4));
        ScoiaTael.add(new CartaHeroi("Dol Blathanna Archer",faccao,2,"Hero",10));
        ScoiaTael.add(new CartaHeroi("Eithné",faccao,2,"Hero",10));
        ScoiaTael.add(new CartaAumentoMoral("Milva",faccao,2,"Unit",10));
        ScoiaTael.add(new CartaHeroi("Iorveth",faccao,2,"Hero",10));
        ScoiaTael.add(new CartaMedico("Havekar Healer I",faccao,2,"Unit",1));
        ScoiaTael.add(new CartaMedico("Havekar Healer II",faccao,2,"Unit",1));
        ScoiaTael.add(new CartaMedico("Havekar Healer III",faccao,2,"Unit",1));
        ScoiaTael.add(new CartaSimples("Ida Emean aep Sivney",faccao,2,"Unit",6));
        ScoiaTael.add(new CartaHeroi("Saesenthessis",faccao,2,"Hero",10));
        ScoiaTael.add(new CartaSimples("Riordain",faccao,2,"Unit",1));
        ScoiaTael.add(new CartaSimples("Vrihedd Brigade Recruit I",faccao,2,"Unit",4));
        ScoiaTael.add(new CartaSimples("Vrihedd Brigade Recruit II",faccao,2,"Unit",4));
        ScoiaTael.add(new CartaSimples("Toruviel",faccao,2,"Unit",2));   
        
        Collections.shuffle(ScoiaTael); //Mistura a lista
        ScoiaTael.add(0, lider);
        return ScoiaTael;
    }
    
    /**
     * Gera um baralho novo da facção Neutro 
     * @return Lista de cartas contendo o baralho
     */
    public static List<Carta> getNeutro(){
        List<Carta> neutro = new ArrayList<>();
        Faccao faccao = Faccao.NEUTRO;
        neutro.add(new CartaHeroi("Cirilla Fiona Elen Riannon",faccao,1,"Hero",15));
        neutro.add(new CartaHeroi("Geralt of Rivia",faccao,1,"Hero",15));
        neutro.add(new CartaEspecial("Decoy",faccao,1,"Special",004));
        neutro.add(new CartaEspecial("Commander's Horn",faccao,1,"Special",005));
        neutro.add(new CartaEspecial("Scorch",faccao,1,"Special",006));
        neutro.add(new CartaClima("Biting Frost",faccao,1,"Weather"));
        neutro.add(new CartaClima("Clear Weather",faccao,4,"Weather"));
        neutro.add(new CartaClima("Impenetrable Fog",faccao,2,"Weather"));
        neutro.add(new CartaClima("Torrential Rain",faccao,3,"Weather"));
        neutro.add(new CartaSimples("Emiel Regis Rohellec Terzieff",faccao,1,"Unit",5));
        neutro.add(new CartaEspiao("Mysterious Elf",faccao,1,"Unit",1));
        neutro.add(new CartaHeroi("Triss Merigold",faccao,1,"Hero",10));
        neutro.add(new CartaQueima("Villentretenmerth",faccao,1,"Unit",7));
        neutro.add(new CartaSimples("Vesemir",faccao,1,"Unit",15));
        neutro.add(new CartaSimples("Bovine Defense Force",faccao,1,"Unit",8));
        neutro.add(new CartaAumentoMoral("Dandelion",faccao,1,"Unit",2));
        neutro.add(new CartaSimples("Zoltan Chivay",faccao,1,"Unit",5));
        neutro.add(new CartaAgil("Olgierd von Everec",faccao,2,"Unit",6));
        neutro.add(new CartaCoragem("Gaunter O'Dimm",faccao,3,"Gaunter O'Dimm",2));
        neutro.add(new CartaCoragem("Gaunter O'Dimm Darkness",faccao,2,"Gaunter O'Dimm",2));
        neutro.add(new CartaHeroi("Yennefer of Vengerberg",faccao,2,"Hero",15));
        
        Collections.shuffle(neutro); //Mistura a lista
        return neutro;
    }
}
