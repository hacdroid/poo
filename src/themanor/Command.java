package themanor;
/**
 * Type énuméré des différentes commandes utilisables par le joueur
 * @author alexa
 */
public enum Command {

    /**
     * Commande de déplacement
     */
    GO("GO : Allows you to go where it is possible to.\nGO office\n"),

    /**
     * Commande d'aide
     */
    HELP("HELP : Display the command list.\nHELP - HELP item - HELP exit\n"),

    /**
     * Commande d'observation d'une salle ou d'une entité
     */
    LOOK("LOOK : See what is around you, or a specifical thing.\nLOOK - LOOK bread\n"),

    /**
     * Commande de récupération d'item
     */
    TAKE("TAKE : Use it to harvest items.\nTAKE bread\n"),

    /**
     * Commande de sortie du jeu
     */
    QUIT("QUIT : Quit the game.\nQUIT\n"),

    /**
     * Commande d'utilisations diverses
     */
    USE("USE : Use an object, or use an object on something.\nUSE bread - USE key1 hall\n"),

    /**
     * Commande d'affichage du profil joueur
     */
    INVENTORY("INVENTORY : display your inventory.\nINVENTORY\n");

	private String desc;

        /**
         * Le constructeur des commandes nécessite un string :
         * @param description correspond à l'utilisation des commandes affiché dans HELP
         */
	Command(String description){
            this.desc=description;
	}
        
        
        /**
         * Affichage des utilisations des commandes
         */
        public void display() {
            System.out.println(this.desc);
	}

}