package themanor;

public class PoisonedLake extends Item {

    public PoisonedLake() {
        super();
    }

    public PoisonedLake(Thing itemHidden) {
        super(itemHidden);
    }

    @Override
    public void use() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return("a lake full of muddy water, something shiny is at the bottom");
    }
}