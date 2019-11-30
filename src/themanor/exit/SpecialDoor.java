package themanor.exit;

import themanor.place.Place;

public class SpecialDoor extends Exit {
    
    public SpecialDoor(Place voisin){ 
        super(voisin);
        // Le socle connait la porte ET la dévérouille (selon les conditions du
        // socle)
    }
    
    
    @Override
    public String toString() {
        String etat;
        
        if (this.isOpen()) etat = "opened door, it leads to the " +
                this.getPlace().toString();
        else etat = "closed door... It seems to be linked to a socle";
        
        return "A strange " + etat + ".";
    }
    
    @Override
    public void open(){
        System.out.println("LA PORTE S'OUVRE AVEC LE GOLD RING");
        super.open();
    }
}