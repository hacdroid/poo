package themanor;

import themanor.exit.Exit;
import themanor.interfaces.Takable;
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
import static themanor.Command.*;

public class Player {

    private final String NAME;
    private Map<String,Item> inventory = new LinkedHashMap<>();;
    private Command command;
    private int hp = 20;
    private Place actualPlace;
    private final World WORLD;
    private boolean inFigth = false;

    /**
     * 
     * @param name
     */
    public Player(String name, World w) {
            this.NAME=name;
            this.WORLD=w;
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
    }

    public void attack(Creature monstre, int damage){
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
                if (!this.inFigth) this.goCommand(ls.size(), ls);
                else System.out.println("You cannot leave during fight!");
                break;    

            case HELP :
                this.helpCommand();
                break;

            case LOOK:
                this.lookCommand(ls.size(), ls);
                break;

            case TAKE:
                if (!this.inFigth) this.takeCommand(ls.size(),ls);
                else System.out.println("You cannot take something during fight");
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
                if("storeroom".equals(ls.get(0)) && !this.inventory.containsKey("torch")){
                    System.out.println("The room is to dark... You cannot go there...");
                }else {
                this.actualPlace = actualExits.get(ls.get(0)).getPlace();
                System.out.println("You are going to the " + this.actualPlace.getName() + "!\n");
                }
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
            }
        } else {
            
                System.out.print("You are into ");
                System.out.println(this.actualPlace.toStringComplete());
           
        }
    }



    private void takeCommand(int nbArgs, List<String> ls)
    {
        Map<String,Thing> actualThings = this.actualPlace.getThings();
        if (nbArgs>0){
            if (actualThings.containsKey(ls.get(0))){    
                if (Takable.class.isAssignableFrom(actualThings.get(ls.get(0)).getClass())){
                    this.inventory.put(ls.get(0),(Item)actualThings.get(ls.get(0)));
                    System.out.println("You take "
                            + this.inventory.get(ls.get(0)));

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

        if (nbArgs>0){
            if (this.inventory.containsKey(ls.get(0))){ 
                if (nbArgs>1){ 
                    if (actualItems.containsKey(ls.get(1))) {
                        this.inventory.get(ls.get(0)).use(this.WORLD,actualItems.get(ls.get(1)));
                    }
                    else if (this.inventory.containsKey(ls.get(1))) {
                        this.inventory.get(ls.get(0)).use(this.WORLD,this.inventory.get(ls.get(1)));
                    }
                    else if (actualCreature.containsKey(ls.get(1))) {
                        this.inventory.get(ls.get(0)).use(this.WORLD,actualCreature.get(ls.get(1)));
                    }
                    else if (actualExits.containsKey(ls.get(1))){
                        this.inventory.get(ls.get(0)).use(this.WORLD,actualExits.get(ls.get(1)));
                    } else System.out.println("Second argument is not valid.");

                } else this.inventory.get(ls.get(0)).use(this.WORLD);

            } else if(actualItems.containsKey(ls.get(0)) 
                    && !Takable.class.isAssignableFrom(actualItems.get(ls.get(0)).getClass())) {
                actualItems.get(ls.get(0)).use(this.WORLD);
            }

            else System.out.println("First argument is not an item in your inventory.");

        } else System.out.println("You cannot use void.");

    }



    private void inventoryCommand(){
        if(!inventory.isEmpty()){
            System.out.println("Your inventory : ");
            for (Item i : inventory.values()) System.out.println("- "+ i);           
        } else System.out.println("There is nothing in your inventory.");
    }

    
    
    public void addHp(int hp) {
        this.hp += hp;
    }

    public Map<String, Item> getInventory() {
        return inventory;
    }

    public int getHp() {
        return hp;
    }

    public void setFigth(boolean inFigth) {
        this.inFigth = inFigth;
    }

    public boolean isInFigth() {
        return inFigth;
    }
     
        
}