package themanor.thing.item;

import themanor.World;
import themanor.exit.SpecialDoor;
import themanor.exit.Exit;
import themanor.thing.Thing;


/**
 * Classe d'un socle permettant l'ouverture d'une porte spéciale
 * @author alexa
 */
public class SpecialDoorSocle extends Item {
    private SpecialDoor linkedDoor;
    
    public SpecialDoorSocle(String name) {
        super(name);
    }
    
    public SpecialDoorSocle(String name, Thing itemHidden) {
        super(name, itemHidden);
    }

    public SpecialDoorSocle(String name, Exit linkedDoor) {
        super(name);
        this.linkedDoor=(SpecialDoor)linkedDoor;
    }


    /**
     * Cette méthode donne la porte liée au socle
     * @return une specialDoor
     */
    public SpecialDoor getLinkedDoor() {
        return linkedDoor;
    }
    
    
    /**
     * Cette méthode donne un indice sur l'utilisation du socle
     * @param w correspond au monde
     */
    @Override
    public void use(World w) {
        System.out.println("You cannot use this socle. It seems to need an item on it.");
    }

    
    /**
     * On redéfinit la méthode toString pour chaque porte
     * @return le message type String
     */  
    @Override
    public String toString() {
        return "a socle linked to a door";
    }
}