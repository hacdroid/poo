package themanor.exit;

import themanor.place.Place;


/**
 * Porte toujours ouverte
 * @author alexa
 */
public class Door extends Exit {
    
    
    /**
     * Constructeur de la porte toujours ouverte
     * @param place correspond au lieu lié à la sortie
     */
    public Door (Place place){
        super(place);
        this.isOpen=true;
    }
    

    /**
     * On redéfinit la méthode toString pour chaque porte
     * @return le message type String
     */
    @Override
    public String toString() {
        return "an opened door, it leads to " + this.getPlace().toString();
    }
}