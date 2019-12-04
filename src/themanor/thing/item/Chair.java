package themanor.thing.item;

import themanor.World;
import themanor.thing.Thing;


/**
 * Classe d'une chaise
 * @author alexa
 */
public class Chair extends Item {

    public Chair(String name) {
        super(name);
    }

    public Chair(String name, Thing itemHidden) {
        super(name, itemHidden);
    }

    
    /**
     * Méthode d'une chaise qui se casse et donne un baton
     * @param w correspond au monde
     */
    @Override
    public void use(World w) {
        System.out.println("You seat on the chair. You break the chair...\n");
        if (this.haveAHiddenItem()){
            System.out.println("Now, there is a stick on the ground, from the broken chair.");
            w.getJoueur().getActualPlace().addThing(this.getItemHide());
            this.removeItemHide();
        } else System.out.println("\nNothing to unlock!");
        w.getJoueur().getActualPlace().getThings().remove(this.getName());
    }
    
    
    /**
     * On redéfinit la méthode toString pour chaque porte
     * @return le message type String
     */  
    @Override
    public String toString() {
        return("an old rickety chair");
    }
}
