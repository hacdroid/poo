/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package themanor.thing.item;

import themanor.World;
import themanor.thing.Thing;


public class Computer extends Item {

    public Computer(String name) {
        super(name);
    }
    
    public Computer(String name, Thing linkedItem) {
        super(name,linkedItem);
    }

    @Override
    public void use(World w) {
        if (((Wardrobe)super.getItemHide()).isLocked()){
            ((Wardrobe)super.getItemHide()).unlock();
            System.out.println("You have unlocked something that was electronically locked!");
        } else {
            System.out.println("You have already done that!");
        }
    }

    @Override
    public String toString() {
        return("a computer plugged into the wall");
    }
    
}
