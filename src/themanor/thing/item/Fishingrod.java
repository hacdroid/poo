/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package themanor.thing.item;

import themanor.World;
import themanor.interfaces.Takable;
import themanor.thing.Thing;

/**
 *
 * @author alexa
 */
public class Fishingrod extends Item implements Takable {
    
    public Fishingrod(String name) {
        super(name,4);
    }

    public Fishingrod(String name, Thing itemHidden) {
        super(name, itemHidden,4);
    }
    
    public void use(World w,Item i){
        if (i instanceof PoisonedLake){
            System.out.println("You harvest a " + i.getItemHide().getName() + "!\nIt's seems to be use somewhere!");
            w.getJOUEUR().getInventory().put(i.getItemHide().getName(),(Item)i.getItemHide());
            i.removeItemHide();
            w.getJOUEUR().getInventory().remove(this.getName());
        }else{
            super.use(w, i);
        }
    }

    @Override
    public String toString() {
        return("a handmade fishingrod");
    }
    
}
