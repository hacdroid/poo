package themanor.thing.item;

import themanor.World;
import themanor.interfaces.Takable;
import themanor.thing.Thing;


/**
 * Classe d'une lampe torche
 * @author alexa
 */
public class Torch extends Item implements Takable {

    public Torch(String name) {
        super(name,3);
    }

    public Torch(String name, Thing itemHidden) {
        super(name, itemHidden,3);
    }
    
    
    /**
     * Cette méthode indique que la torch est toujours en fonctionnement
     * @param w correspond au monde
     */
    @Override
    public void use(World w) {
        System.out.println("You already are using the torch.");
    }

    
    /**
     * On redéfinit la méthode toString pour chaque porte
     * @return le message type String
     */  
    @Override
    public String toString() {
        return("a small practical torch");
    }


}