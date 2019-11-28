package themanor.exit;

import themanor.place.Place;

public class Door extends Exit {

    public Door (Place voisin){
        super(voisin);
        this.open();
    }
    
    
    @Override
    public String toString() {
        return "an opened door, it leads to " + this.getPlace().toString();
    }
}