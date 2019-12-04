package themanor.thing.item;

import themanor.World;
import themanor.thing.Thing;


/**
 * Classe d'une bouteille d'eau
 * @author alexa
 */
public class WaterBottle extends Bottle {

    public WaterBottle(String name) {
        super(name);
    }

    public WaterBottle(String name, Thing itemHidden) {
        super(name, itemHidden);
    }
    
    
    /**
     * La méthode donne une bouteille d'eau à un homme
     * @param w correspond au monde
     * @param i correspond à l'item (l'homme étant considéré comme un item)
     */
    @Override
    public void use(World w,Item i){
        if (i instanceof NPC){
            System.out.println("You give your water bottle to the man. He is really glad!\n"
                    + "In appreciation, he gives you the " + i.getItemHide().getName() + "!");
            w.getJoueur().getInventory().put(i.getItemHide().getName(),(Item)i.getItemHide());
            w.getJoueur().getInventory().remove(this.getName());
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
        return("a bottle full of fresh water");
    }
    
}