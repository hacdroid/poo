/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package themanor.thing.item;

import themanor.World;
import themanor.thing.Thing;

/**
 *
 * @author alexa
 */
public class Wardrobe extends Item {
    private boolean lock = true;
    
    public Wardrobe(String name) {
        super(name);
    }

    public Wardrobe(String name, Thing itemHidden) {
        super(name, itemHidden);
    }
    


    @Override
    public void use(World w) {
        if (lock){
            System.out.println("It seems to be electronically locked!");
        } else {
            System.out.println("There is the " + this.getItemHide().getName() + " into this wardrobe!");
            w.getJOUEUR().getActualPlace().getThings().remove(this.getName());
            w.getJOUEUR().getActualPlace().addThing(this.getItemHide());
        }
        
        
        
    }

    @Override
    public String toString() {
        return("an electronic wardrobe");
    }

    public void unlock() {
        this.lock = false;
    }
    
    public boolean isLocked(){
        return this.lock;
    }
     
    
    
}
