package themanor;
/**
 * <p>Type énuméré des différentes <b>commandes<b/> utilisables par le joueur</p>
 * @author alexa
 */
public enum Command {
	GO("GO : Allows you to go where it is possible to.\nGO office\n"),
        HELP("HELP : Display the command list.\nHELP - HELP item - HELP exit\n"),
        LOOK("LOOK : See what is around you, or a specifical thing.\nLOOK - LOOK bread\n"),
        TAKE("TAKE : Use it to harvest items.\nTAKE bread\n"),
        QUIT("QUIT : Quit the game.\nQUIT\n"),
        USE("USE : Use an object, or use an object on something.\nUSE bread - USE key1 hall\n"),
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