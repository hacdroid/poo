package themanor.exit;

import themanor.place.Place;


/**
 * Porte nécessitant une goldring
 * @author alexa
 */
public class SpecialDoor extends Exit {
   
    
    /**
     * Constructeur d'une porte à goldring
     * @param place correspond au lieu lié à la sortie
     */   
    public SpecialDoor(Place place){ 
        super(place);
    }
    
    
   /**
     * On définit une méthode open pour ouvrir la porte
     * Elle passe la variable correspondante a true
     */  
    public void open(){
        super.isOpen=true;
    }
    
    
    /**
     * On redéfinit la méthode toString pour chaque porte
     * @return le message type String
     */
    @Override
    public String toString() {
        String etat;
        if (this.isOpen()) etat = "opened door, it leads to the " 
                + this.getPlace().toString();
        else etat = "closed door... It seems to be linked to a socle";
        return "A strange " + etat + ".";
    }
}