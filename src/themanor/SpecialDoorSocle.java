package themanor;

public class SpecialDoorSocle extends Item {
    private SpecialDoor linkedDoor;
    
    public SpecialDoorSocle() {
        super();
    }

    public SpecialDoorSocle(Exit linkedDoor) {
        super();
        this.linkedDoor=(SpecialDoor)linkedDoor;
    }
    @Override
    public void use() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}