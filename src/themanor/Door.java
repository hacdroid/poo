package themanor;

public class Door extends Exit {

    public Door (Place voisin){
        super(voisin);
        this.open();
    }
    
    
    @Override
    public String toString() {
        return "Une porte est ouverte, elle mène à " + this.getVoisin().toString();
    }
}