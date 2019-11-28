/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package themanor.thing.item;

import themanor.thing.Thing;

/**
 *
 * @author alexa
 */
public class Computer extends Item {
    private final Thing LOCKEDITEM;

    public Computer(Thing lockedItem) {
        super();
        this.LOCKEDITEM=lockedItem;
    }

    @Override
    public void use() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return("a computer plugged into the wall");
    }
    
}
