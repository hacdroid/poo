package themanor;

/**
 *
 * @author alexa
 */
public class Electricmeter extends Item {

    public Electricmeter() {
        super();
    }

    public Electricmeter(Thing itemHidden) {
        super(itemHidden);
    }

    @Override
    public void use() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return("an electricmeter");
    }
    
}
