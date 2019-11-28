package themanor.thing.item;

import themanor.World;
import themanor.thing.Thing;

/**
 *
 * @author alexa
 */
public class Electricmeter extends Item {

    public Electricmeter(String name) {
        super(name);
    }

    public Electricmeter(String name, Thing itemHidden) {
        super(name, itemHidden);
    }


    @Override
    public void use(World w) {
        System.out.println("You turn the light on!");
        w.getJOUEUR().getActualPlace().getThings().remove(this.getName());
        w.getJOUEUR().getActualPlace().addThing(this.getItemHide());
 
    }

    @Override
    public String toString() {
        return("an electricmeter");
    }
    
}
