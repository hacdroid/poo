package themanor;

public class Chair extends Item {

    public Chair() {
        super();
    }

    public Chair(Thing itemHidden) {
        super(itemHidden);
    }

    @Override
    public void use() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return("an old rickety chair");
    }
}//hey
