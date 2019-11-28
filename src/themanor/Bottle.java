package themanor;

public class Bottle extends Item implements Takable {

    @Override
    public void use() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return("a plastic bottle, it can handle some liquid");
    }
}