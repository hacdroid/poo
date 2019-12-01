package themanor.thing.item;

import themanor.World;
import themanor.thing.Thing;


/**
 * Classe d'un NPC
 * @author alexa
 */
public class NPC extends Item {

    public NPC(String name) {
        super(name);
    }

    public NPC(String name, Thing itemHidden) {
        super(name, itemHidden);
    }
 
    
    /**
     * Cette méthode donne des indications sur ce que l'homme attend
     * @param w correspond au monde
     */
    @Override
    public void use(World w) {
        System.out.println("You talk to the friendly man. He is so thirsty...\nHe will give anything to have a water bottle.");
    }
    
    
    /**
     * On redéfinit la méthode toString pour chaque porte
     * @return le message type String
     */  
    @Override
    public String toString() {
        return ("A friendly mans spread out at the ground");
    }
    
}