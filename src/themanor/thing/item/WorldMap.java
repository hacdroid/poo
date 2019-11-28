package themanor.thing.item;

import themanor.World;
import themanor.interfaces.Takable;
import themanor.thing.Thing;

/**
 *
 * @author alexa
 */
public class WorldMap extends Item implements Takable {

    public WorldMap(String name) {
        super(name);
    }

    public WorldMap(String name, Thing itemHidden) {
        super(name, itemHidden);
    }

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
"|  room|               |child_bed- |adult_bed  |\n"+
"|      =   Livingroom  =     room  =     room  |\n"+
"|      |               |           |           |\n"+
"------------||------||--------------------------\n"+
"|      |       |       |           |           |\n"+
"|Bath- =Office = Hall  =Lunchroom  =   Kitchen |\n"+
"|  room|       |       |           |           |\n"+
"------------------------------------------------\n"


               );    }

    @Override
    public String toString() {
        return("an old map");
    }
    
}
