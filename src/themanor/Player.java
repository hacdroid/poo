package themanor;

import themanor.exit.Exit;
import themanor.interfaces.Takable;
import themanor.interfaces.Attackable;
import themanor.place.Place;
import themanor.thing.item.Item;
import themanor.thing.creature.Creature;
import themanor.thing.Thing;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
        
        public void attack(Attackable monstre, int damage){
            monstre.attacked(this, damage);
            
        }
        
        public void setActualPlace(Place lieu){
            this.actualPlace=lieu;
        }
        
        public Place getActualPlace(){
            return this.actualPlace;
        }
        
        public String getName(){
            return this.NAME;
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
        

	public void executeCommand(List<String> ls) {

            switch(this.command){
                case GO:
                    this.goCommand(ls.size(), ls);
                    break;    
                    
                case HELP :
                    this.helpCommand();
                    break;
                    
                case LOOK:
                    this.lookCommand(ls.size(), ls);
                    break;
                    
                case TAKE:
                    this.takeCommand(ls.size(),ls);
                    break;
                    
                case QUIT:
                    this.quitCommand();
                    break;
                    
                case USE:
                    this.useCommand(ls.size(),ls);
                    break;
                    
                case INVENTORY:
                    this.inventoryCommand();
                    break;
                    
                default:
                    System.err.println("SWITCH ERROR!");
            }

	}
        
        
        private void goCommand(int nbArgs, List<String> ls){
            Map<String,Exit> actualExits = this.actualPlace.getExits();
            Map<String,Exit> actualOpenExits = this.actualPlace.getOpenExits();
            
            if (nbArgs>0){
                if (actualOpenExits.containsKey(ls.get(0))){
                    this.actualPlace = actualExits.get(ls.get(0)).getPlace();
                    System.out.println("You are going to a " + this.actualPlace.getName() + "!\n");
                }
                else if (actualExits.containsKey(ls.get(0))) System.out.println("This door seems locked! You cannot go there.");
                else if (this.actualPlace.getName().equals(ls.get(0))) System.out.println("You already are into this place!");
                else if (this.WORLD.getLISTEPLACES().containsKey(ls.get(0))) System.out.println("This place is too far away!");
                else System.out.println("This place doesn't exist!");
            } else {
                System.out.println("You cannot go nowhere!");
            }
        }

        
        private void helpCommand(){
            for (int i = 0; i<Command.values().length;i++){
                Command.values()[i].display();
            }
        }
        
        
        
        
        private void lookCommand(int nbArgs, List<String> ls){
            Map<String,Thing> actualThings = this.actualPlace.getThings(); 
            
            if (nbArgs>0){
                if (actualThings.containsKey(ls.get(0))){        
                    System.out.println("It is a " + actualThings.get(ls.get(0)));
                    //VERIFIE SIL EST TAKABLE
                }
            } else {
                if (actualThings.size()!=0){
                    System.out.print("You are into ");
                    System.out.println(this.actualPlace.toStringComplete());
                    
                } else System.out.println("There is nothing there."); 
            }
        }
        
        
        
        
        private void takeCommand(int nbArgs, List<String> ls)
        {
            Map<String,Thing> actualThings = this.actualPlace.getThings();
            if (nbArgs>0){
                if (actualThings.containsKey(ls.get(0))){    
                    if (Takable.class.isAssignableFrom(actualThings.get(ls.get(0)).getClass())){
                        this.inventory.add((Item)actualThings.get(ls.get(0)));
                        System.out.println("You take "
                                + this.inventory.get(this.inventory.size()-1));

                        this.actualPlace.getThings().remove(ls.get(0));
                    } else System.out.println("You cannot take this!");   
                } else System.out.println("It does not exist.");
            } else System.out.println("You cannot take nothing.");
        }
        
        
        
        
        private void quitCommand(){
            this.hp=0;
            System.out.println("You quit the game, bye!\n");
        }
        
        
        
        
        
        private void useCommand(int nbArgs, List<String> ls){
            Map<String,Creature> actualCreature = this.actualPlace.getCreatures();
            Map<String,Item> actualItems = this.actualPlace.getItems();
            Map<String,Exit> actualExits = this.actualPlace.getExits();
            
            
            /*
            SI IL Y A > UN ARGUMENT ->
                  EST IL UN ITEM?
                  
                  SIL Y A > DEUX ARGUMENTS ->
                      DE QUEL TYPE EST IL ? ITEM EXIT OU CREATURE ?
            
            
            SINON -> NOPE
            */
            
            
            /*
            USE ITEM item.use() -> ITEM DANS INVENTAIRE
            
            USE ITEM ITEM item.use(item) -> ITEM 2 PAS DANS INVENTAIRE
            
            USE ITEM EXIT item.use(door)
            
            USE ITEM CREATURE item.use(creature)
            */
            
            if (nbArgs>0){
                if (/*ITEM DANS INVENTAIRE*/true){
                    if (nbArgs>1){
                        if (actualItems.containsKey(ls.get(0))) {/*ITEM (pas dans inventaire)*/}
                        if (actualCreature.containsKey(ls.get(0))) {/*CREATURE*/}
                        if (true){/*PORTE*/}
                        //SELON LE TYPE DU DEUXIEME ITEM.
                        
                    } else {
                        
                        //item.use
                        
                    }
                    
                } else System.out.println("First argument is not an item into your inventory.");
                
            } else System.out.println("You cannot use void.");
            
            
            
            
            
        }
        
        
        
        private void inventoryCommand(){
            if(!inventory.isEmpty()){
                System.out.println("Your inventory : ");
                for (Item i : inventory) System.out.println("- "+ i);           
            } else System.out.println("There is nothing in your inventory.");
        }
}