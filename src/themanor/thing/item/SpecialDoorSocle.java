package themanor.thing.item;

import themanor.World;
import themanor.exit.SpecialDoor;
import themanor.exit.Exit;
import themanor.thing.item.Item;

public class SpecialDoorSocle extends Item {
    private SpecialDoor linkedDoor;
    
    public SpecialDoorSocle(String name) {
        super(name);
    }

    public SpecialDoorSocle(String name, Exit linkedDoor) {
        super(name);
        this.linkedDoor=(SpecialDoor)linkedDoor;
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