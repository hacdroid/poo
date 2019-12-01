package themanor.thing.item;

import themanor.World;
import themanor.interfaces.Takable;
import themanor.thing.Thing;


/**
 * Classe d'un anneau en or
 * @author alexa
 */
public class Goldring extends Item implements Takable {

    public Goldring(String name) {
        super(name,20);
    }

    public Goldring(String name, Thing itemHidden) {
        super(name, itemHidden,20);
    }
    
    
    /**
     * Cette méthode permet d'ouvrir une porte spécial avec un goldring
     * @param w correspond au monde
     * @param i correspond au socle
     */
    @Override
    public void use(World w,Item i){
        if (i instanceof SpecialDoorSocle){
            if (!((SpecialDoorSocle)i).getLinkedDoor().isOpen()){
                    System.out.println("You opened the door!\nNow, you can go to the " + ((SpecialDoorSocle)i).getLinkedDoor().getPlace().getName());
                    ((SpecialDoorSocle)i).getLinkedDoor().open();
                    w.getJOUEUR().getInventory().remove(this.getName());
            } else System.out.println("Door already open..."); //NORMALEMENT N'ATTEINT JAMAIS CET ENDROIT!
        } else super.use(w, i);
    }


    /**
     * On redéfinit la méthode toString pour chaque porte
     * @return le message type String
     */  
    @Override
    public String toString() {
        return("a shiny tiny gold ring, it's got a perfect round shape");
    }
}