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
public class Wardrobe extends Item {
    
    public Wardrobe() {
        super();
    }

    public Wardrobe(Thing itemHidden) {
        super(itemHidden);
    }

    @Override
    public void use() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return("an electric wardrobe");
    }
    
}
