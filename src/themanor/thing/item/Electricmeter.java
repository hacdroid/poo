package themanor.thing.item;

import themanor.World;
import themanor.place.Place;
import themanor.thing.Thing;

/**
 * Classe d'un tableau électrique
 * @author alexa
 */
public class Electricmeter extends Item {

    public Electricmeter(String name) {
        super(name);
    }

    public Electricmeter(String name, Thing itemHidden) {
        super(name, itemHidden);
    }


    /**
     * La méthode permet d'allumer la lumière
     * @param w correspond au monde
     */
    @Override
    public void use(World w) {
        System.out.println("You turn on the electricity in the manor!\n"
                + "You can see better into the room and"
                + " you have probably unlocked electronic objetcs.");
        Place.isElectricityOn = true;
        w.getJOUEUR().getActualPlace().getThings().remove(this.getName());
        w.getJOUEUR().getActualPlace().addThing(this.getItemHide());
 
    }

    
    /**
     * On redéfinit la méthode toString pour chaque porte
     * @return le message type String
     */  
    @Override
    public String toString() {
        return("an electricmeter");
    }
    
}
