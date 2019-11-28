package themanor.thing.item;

import themanor.interfaces.Takable;
import themanor.thing.item.Item;

public class Key extends Item implements Takable {
    private final int CODE; //ON A DECIDE D'UTILISER UN SYSTEME DE CODE AVEC LES PORTES
    
    
    public Key(int code) {
        super();
        this.CODE=code;
    }

    
    
    @Override
    public void use() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return("a key");
    }
}