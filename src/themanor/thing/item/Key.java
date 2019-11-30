package themanor.thing.item;

import themanor.World;
import themanor.exit.Exit;
import themanor.exit.LockedDoor;
import themanor.interfaces.Takable;
import themanor.thing.item.Item;

public class Key extends Item implements Takable {
    private final int CODE; //ON A DECIDE D'UTILISER UN SYSTEME DE CODE AVEC LES PORTES
    
    public Key(String name, int code) {
        super(name,4);
        this.CODE=code;
    }

    
    @Override
    public void use(World w) {
        System.out.println("You need to specify the door place to use.");
    }
    
    public void use(World w,Exit e){
        if (e instanceof LockedDoor){
            if (!((LockedDoor)e).isOpen()){
                if(((LockedDoor) e).open(CODE)){
                    System.out.println("You opened the door!\nNow, you can go to the " + e.getPlace().getName());
                    w.getJOUEUR().getInventory().remove(this.getName());
                } else{
                    System.out.println("You did not use the right key to open this door...");
                }
            } else System.out.println("Door already open..."); //NORMALEMENT N'ATTEINT JAMAIS CET ENDROIT!
  
        } else super.use(w, e);

    }


    @Override
    public String toString() {
        return("the key" + this.CODE);
    }
}