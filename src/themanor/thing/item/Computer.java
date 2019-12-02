package themanor.thing.item;

import themanor.World;
import static themanor.place.Place.isElectricityOn;
import themanor.thing.Thing;

/**
 * Classe d'un ordinateur lié à un item électroniquement bloqué
 * @author alexa
 */
public class Computer extends Item {

    public Computer(String name) {
        super(name);
    }
    
    public Computer(String name, Thing linkedItem) {
        super(name,linkedItem);
    }

    
    /**
     * Méthode pour débloquer electroniquement un item bloqué
     * @param w correspond au monde
     */
    @Override
    public void use(World w) {
        if (isElectricityOn){
            if (((Wardrobe)super.getItemHide()).isLocked()){
                ((Wardrobe)super.getItemHide()).unlock();
                System.out.println("You have unlocked something that was electronically locked!");
            } else {
                System.out.println("You have already done that!");
            }
        } else{
            System.out.println("You cannot use it without electricity.");
        }
    }

    
    /**
     * On redéfinit la méthode toString pour chaque porte
     * @return le message type String
     */  
    @Override
    public String toString() {
        return("a computer plugged into the wall");
    }
    
}
