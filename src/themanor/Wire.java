package themanor;

public class Wire extends Item implements Takable {

    @Override
    public void use() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return("a long solid wire");
    }
}