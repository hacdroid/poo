package themanor;

public enum Command {
	GO("GO : Allows you to go where it is possible to.\nGO office\n"),
        HELP("HELP : Display the command list.\nHELP - HELP item - HELP exit\n"),
        LOOK("LOOK : See what is around you, or a specifical thing.\nLOOK - LOOK bread\n"),
        TAKE("TAKE : Use it to harvest items.\nTAKE bread\n"),
        QUIT("QUIT : Quit the game.\nQUIT\n"),
        USE("USE : Use an object, or use an object on something.\nUSE bread - USE key1 hall\n"),
        INVENTORY("INVENTORY : display your inventory.\nINVENTORY\n");
        

	private String desc;

	Command(String description){
            this.desc=description;
	}
        
        public void display() {
            System.out.println(this.desc);
	}

}