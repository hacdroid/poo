package themanor.thing.item;

import themanor.World;
import themanor.thing.*;

public class Plants extends Item{

    public Plants(String name) {
        super(name);
    }

    public Plants(String name, Thing itemHidden) {
        super(name, itemHidden);
    }

    @Override
    public String toString() {
        return "There are plants that prevent you to move forward.";
    }
    

    
    
}