package themanor;

public enum Command {
	GO("GO : Allows you to go where it is possible to.\nUse : GO office\n"),
        HELP("HELP : Display the command list.\nUses : HELP / HELP GO\n"),
        LOOK("LOOK : See what is around you, or a specifical thing.\nUses : LOOK / LOOK bread\n"),
        TAKE("TAKE : Use it to harvest items.\nUse : TAKE bread\n"),
        QUIT("QUIT : Quit the game.\nUse : QUIT\n"),
        USE("USE : Use an object, or use an object on something.\nUses : USE bread, USE key1 door\n"),
        INVENTORY("INVENTORY : display your inventory.\nUse : INVENTORY\n");

	private String desc;

	Command(String description){
            this.desc=description;
	}
        
        public void display() {
            System.out.println(this.desc);
	}

}