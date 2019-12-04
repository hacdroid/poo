package themanor.thing.item;

import themanor.World;
import themanor.interfaces.Takable;
import themanor.thing.Thing;


/**
 * Classe d'un détergent
 * @author alexa
 */
public class Detergent extends Item implements Takable {

    public Detergent(String name) {
        super(name,4);
    }

    public Detergent(String name, Thing itemHidden) {
        super(name, itemHidden,4);
    }
 
    
    /**
     * Cette méthode permet d'utiliser du détergent sur des plantes
     * @param w correspond au monde
     * @param i correspond aux plantes
     */
    @Override
    public void use(World w,Item i){
        if (i instanceof Plants){
            System.out.println("You pour detergent on " + i.getName() + ". The plants are now dissolved!\nYou can see a wire behind these.");
            w.getJoueur().getActualPlace().addThing(i.getItemHide());
            w.getJoueur().getActualPlace().getThings().remove(i.getName());
        }else{
            super.use(w, i);
        }
    }

    
    /**
     * On redéfinit la méthode toString pour chaque porte
     * @return le message type String
     */  
    @Override
    public String toString() {
        return("a detergent bottle of a brand that does not even exist anymore");
    }
}