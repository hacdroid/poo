package themanor.thing.item;

import themanor.World;
import themanor.interfaces.Takable;
import themanor.thing.Thing;


/**
 * Classe d'un pain
 * @author alexa
 */
public class Bread extends Item implements Takable{

    public Bread(String name) {
        super(name,2);
    }

    public Bread(String name, Thing itemHidden) {
        super(name, itemHidden,2);
    }

    
    /**
     * Méthode permettant de gagner de la vie
     * @param w correspond au monde
     */
    @Override
    public void use(World w) {
        w.getJoueur().addHp(5);
        w.getJoueur().getInventory().remove(this.getName());
        System.out.println("Henceforth, you have " + w.getJoueur().getHp() + " life points!");
    }

    
    /**
     * On redéfinit la méthode toString pour chaque porte
     * @return le message type String
     */  
    @Override
    public String toString() {
        return("a piece of bread");
    }
}