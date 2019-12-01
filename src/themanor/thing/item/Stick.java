package themanor.thing.item;

import themanor.World;
import themanor.interfaces.Takable;
import themanor.thing.Thing;


/**
 * Classe d'un baton
 * @author alexa
 */
public class Stick extends Item implements Takable {

    public Stick(String name) {
        super(name,4);
    }

    public Stick(String name, Thing itemHidden) {
        super(name, itemHidden,4);
    }


    /**
     * La méthode permet de fabriquer une canne à pêche
     * @param w correspond au monde
     * @param i correspond au second item
     */
    @Override
    public void use(World w,Item i){
        if (i instanceof Wire){
            System.out.println("You craft a " + i.getItemHide().getName() + "!");
            w.getJOUEUR().getInventory().put(i.getItemHide().getName(),(Item)i.getItemHide());
            w.getJOUEUR().getActualPlace().getThings().remove(i.getName());
            w.getJOUEUR().getInventory().remove(i.getName());
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
        return("a long stick");
    }
}