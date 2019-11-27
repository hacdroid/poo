package themanor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Player {

	private final String NAME;
	private List<Item> inventory;
	private Command command;
	private int hp;
	private Place actualPlace;
        private final World WORLD;

	/**
	 * 
	 * @param name
	 */
	public Player(String name, World w) {
		this.NAME=name;
                this.hp=20;
                this.inventory= new ArrayList<>();
                this.WORLD=w;
	}

	public int getHp() {
		return this.hp;
	}

        public boolean getIsOut(){
            return (this.hp <= 0);
        }
	/**
	 * 
	 * @param damage
	 */
	public void attacked(int damage) {
            this.hp -= damage;
            if (!this.getIsOut()){
                System.out.println("Il vous reste" + this.getHp() +
                        " point(s) de vie");
            }
	}
        
        public void attack(Creature monstre, int damage){
            monstre.attacked(this, damage);
        }
        
        public void setActualPlace(Place lieu){
            this.actualPlace=lieu;
        }
        

	public void saisieCommand() {
            if (!this.getIsOut()){
                Boolean isException = false;
                Scanner sc = new Scanner(System.in);
                
                
                System.out.print("\n");
                String input = sc.nextLine();
                input = input.toLowerCase();
                
                String[] splitInput = input.trim().split("\\s+");
                splitInput[0] = splitInput[0].toUpperCase();
                List<String> ls = new ArrayList<>(Arrays.asList(splitInput));
                ls.remove(0);
                
                try {
                    this.command=Command.valueOf(splitInput[0]);
                }
                catch(IllegalArgumentException e){
                    System.out.println("Commande non valide !");
                    isException = true;
                }

                if (!isException){
                    this.executeCommand(ls);
                }

            }
	}
        
        public Place getActualPlace(){
            return this.actualPlace;
        }
        
        public String getName(){
            return this.NAME;
        }
        

	/**
	 * 
	 * @param ls
	 */
	public void executeCommand(List<String> ls) {
            int nbArgs = ls.size();
            
            switch(this.command){
                case GO:
                    if (nbArgs>0){
                        this.actualPlace = this.WORLD.getPlaceVoisin(ls.get(0));
                        System.out.println("You are going to a " + this.actualPlace.getName() + "!\n");
                    } else {
                        System.out.println("You cannot go nowhere!");
                    }
                    break;
                case HELP :
                    for (int i = 0; i<Command.values().length;i++){
                        Command.values()[i].display();
                    }
                    break;
                case LOOK:
                    if ((this.WORLD.getThingInRoom(ls.get(0))!=null)){        
                        System.out.println("There is" +this.WORLD.getThingInRoom(ls.get(0)));
                    }
                    break;
                case TAKE:
                    if ((this.WORLD.getThingInRoom(ls.get(0))!=null)){        
                        this.inventory.add((Item)this.WORLD.getThingInRoom(ls.get(0)));
                        System.out.println("You take "+this.inventory.get(this.inventory.size()-1));
                        this.actualPlace.getThings().remove(ls.get(0));
                    }
                    //METTRE CHACUNE DES FONCTIONS DANS DES FONCTIONS SUBSIDIAIRES   
                    break;
                case QUIT:
                    this.hp=0;
                    System.out.println("You quit the game\n GAME OVER");
                    break;
                case USE:
                    break;
                case INVENTORY:
                    if(!inventory.isEmpty()){
                        System.out.println("Voici votre inventaire : ");
                        for (Item i : inventory){
                            System.out.println("- "+i);
                        }
                        break;
                    }
                default:
                    System.out.println("ERREUR SWITCH");
    

                
            }
            
            
            
            
            
	}

}