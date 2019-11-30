package themanor.thing.item;

import themanor.World;
import themanor.exit.Exit;
import themanor.exit.SpecialDoor;
import themanor.interfaces.Takable;
import themanor.thing.Thing;

public class Goldring extends Item implements Takable {

    public Goldring(String name) {
        super(name,20);
    }

    public Goldring(String name, Thing itemHidden) {
        super(name, itemHidden,20);
    }
    
    public void use(World w,Item i){
        if (i instanceof SpecialDoorSocle){
            if (!((SpecialDoorSocle)i).getLinkedDoor().isOpen()){
                    System.out.println("You opened the door!\nNow, you can go to the " + ((SpecialDoorSocle)i).getLinkedDoor().getPlace().getName());
                    ((SpecialDoorSocle)i).getLinkedDoor().open();
                    w.getJOUEUR().getInventory().remove(this.getName());
            } else System.out.println("Door already open..."); //NORMALEMENT N'ATTEINT JAMAIS CET ENDROIT!
        } else super.use(w, i);
    }


    @Override
    public String toString() {
        return("a shiny tiny gold ring, it's got a perfect round shape");
    }
}