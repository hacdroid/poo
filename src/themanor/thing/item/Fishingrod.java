package themanor.thing.item;

import themanor.World;
import themanor.interfaces.Takable;
import themanor.thing.Thing;

/**
 * Classe d'une canne à pêche
 * @author alexa
 */
public class Fishingrod extends Item implements Takable {
    
    public Fishingrod(String name) {
        super(name,4);
    }

    public Fishingrod(String name, Thing itemHidden) {
        super(name, itemHidden,4);
    }
    
    
    /**
     * Méthode permettant de pêcher l'item caché dans le lac empoisonné
     * @param w correspond au monde
     * @param i correspond au lac
     */
    @Override
    public void use(World w,Item i){
        if (i instanceof PoisonedLake){
            System.out.println("You harvest a " + i.getItemHide().getName() + "!\nIt's seems to be use somewhere!");
            w.getJOUEUR().getInventory().put(i.getItemHide().getName(),(Item)i.getItemHide());
            i.removeItemHide();
            w.getJOUEUR().getInventory().remove(this.getName());
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
        return("a handmade fishingrod");
    }
    
}
