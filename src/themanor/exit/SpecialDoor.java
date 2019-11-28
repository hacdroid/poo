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
        
        if (this.isOpen()) etat = "ouverte, elle mène à " +
                this.getPlace().toString();
        else etat = "fermée et semble liée a un socle";
        
        return "Une porte étrange est " + etat + ".";
    }
    
    @Override
    public void open(){
        System.out.println("LA PORTE S'OUVRE AVEC LE GOLD RING");
        this.open();
    }
}