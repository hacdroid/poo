package themanor;

/**
 * Classe main qui créé le monde et met en route la partie
 * @author alexa
 */
public class Main {

    /**
     * Methode principale pour lancer le jeu
     * @param args n'est pas utilisé ici.
     */
    public static void main(String[] args) {
        World w = new World();
        
        w.start();        
    }

}
