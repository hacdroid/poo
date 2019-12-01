package themanor.exit;

import themanor.place.Place;
/**
 * Classe abstraite des portes des salles
 * Elles sont caractérisées par la salle lié
 * et leur accessibilité
 * @author alexa
 */
public abstract class Exit {
	private final Place PLACE;
        protected boolean isOpen;
        
        
        /**
         * Constructeur des portes de sortie 
         * @param place correspond au lieu lié à la sortie
         */
        public Exit(Place place){
            this.PLACE = place;
            this.isOpen = false;
        }
        
        
        /**
         * Cette méthode indique si la sortie est ouverte ou non
         * @return si la porte est ouverte ou pas, type booléen
         */
        public boolean isOpen(){
            return this.isOpen;
        }
        
        
        /**
         * Cette méthode donne la porte lié à la sortie
         * @return la salle
         */
        public Place getPlace (){
            return this.PLACE;
        }

        /**
         * On redéfinit la méthode toString pour chaque porte
         * @return le message type String
         */
        @Override
	public abstract String toString();
}