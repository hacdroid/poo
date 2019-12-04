package themanor.thing.item;

import themanor.World;
import themanor.interfaces.Takable;
import themanor.thing.Thing;


/**
 * Classe d'un fil
 * @author alexa
 */
public class Wire extends Item implements Takable {

    public Wire(String name) {
        super(name,3);
    }

    public Wire(String name, Thing itemHidden) {
        super(name, itemHidden,3);
    }
    
    
    /**
     * La méthode correspond à la fabrication d'une canne à pêche
     * @param w correspond au monde
     * @param i correspond au second item
     */
    @Override
    public void use(World w,Item i){
        if (i instanceof Stick){
            if (this.haveAHiddenItem()){
                System.out.println("You craft a " + this.getItemHide().getName() + "!");
                w.getJoueur().getInventory().put(this.getItemHide().getName(),(Item)this.getItemHide());
                this.removeItemHide();
            } else System.out.println("You craft nothing");
            w.getJoueur().getInventory().remove(this);
            w.getJoueur().getInventory().remove(i);
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
        return("a long solid wire");
    }
}