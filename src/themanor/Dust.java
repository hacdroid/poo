package themanor;

public class Dust extends Item {

    public Dust() {
        super();
    }
    

    public Dust(Thing itemHidden) {
        super(itemHidden);
    }

    @Override
    public void use() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return("a huge pile of dust");
    }
}