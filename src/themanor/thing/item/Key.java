package themanor.thing.item;

import themanor.World;
import themanor.interfaces.Takable;
import themanor.thing.item.Item;

public class Key extends Item implements Takable {
    private final int CODE; //ON A DECIDE D'UTILISER UN SYSTEME DE CODE AVEC LES PORTES
    
    public Key(String name, int code) {
        super(name);
        this.CODE=code;
    }

    
    @Override
    public void use(World w) {
        System.out.println("You need to specify the door place to use.");
    }

    @Override
    public String toString() {
        return("a key");
    }
}