package themanor.thing.item;

import themanor.World;
import themanor.exit.SpecialDoor;
import themanor.exit.Exit;
import themanor.thing.Thing;

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

    public SpecialDoor getLinkedDoor() {
        return linkedDoor;
    }
    
    @Override
    public void use(World w) {
        System.out.println("You cannot use this socle. It seems to need an item on it.");
    }

    @Override
    public String toString() {
        return "a socle linked to a door";
    }
}