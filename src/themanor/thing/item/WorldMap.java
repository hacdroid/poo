package themanor.thing.item;

import themanor.World;
import themanor.interfaces.Takable;
import themanor.thing.Thing;

/**
 * Classe d'une carte
 * @author alexa
 */
public class WorldMap extends Item implements Takable {

    public WorldMap(String name) {
        super(name,1);
    }

    public WorldMap(String name, Thing itemHidden) {
        super(name, itemHidden,1);
    }

    /**
     * La méthode affiche la carte du jeu
     * @param w correspond au monde
     */
    @Override
    public void use(World w) {
        System.out.print("     -----------------------------------------\n"+
            "       |Lake                           Fountain|\n"+
            "       |               Garden                  |\n"+
            "       |                                       |\n"+
            "---------------||-------------------------||----\n"+
            "|      |               |           |           |\n"+
            "|      |Loundge        |   ???     |   Garage  |\n"+
            "|      |               |           |           |\n"+
            "|Store-|-------||------------------|------------\n"+
            "|  room|               |Child bed- |Adult bed  |\n"+
            "|      =   Livingroom  =     room  =     room  |\n"+
            "|      |               |           |           |\n"+
            "------------||------||--------------------------\n"+
            "|      |       |       |           |           |\n"+
            "|Bath- =Office = Hall  =Lunchroom  =   Kitchen |\n"+
            "|  room|       |       |           |           |\n"+
            "------------------------------------------------\n"
        );
    }

    
    /**
     * On redéfinit la méthode toString pour chaque porte
     * @return le message type String
     */  
    @Override
    public String toString() {
        return("an old map");
    }
    
}
