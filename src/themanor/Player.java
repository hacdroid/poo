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


/**
 * Un joueur est caractérisé par son nom, son inventaire, sa commande actuelle,
 * ses points de vies, sa position et s'il est en combat ou non.
 * Il connait aussi le monde dans lequel il évolu.
 * @author alexa
 */
public class Player {

    private final String NAME;
    private Map<String,Item> inventory = new LinkedHashMap<>();;
    private Command command;
    private int hp = 20;
    private Place currentPlace;
    private final World WORLD;
    private boolean inFight = false;

    
    /**
     * Constructeur du joueur
     * @param name correspond au nom du joueur
     * @param w permet au joueur de connaitre son monde
     */
    public Player(String name, World w) {
        this.NAME=name;
        this.WORLD=w;
    }

    
    /**
     * Cette methode nous dit si le joueur est toujours en vie ou non
     * @return si le joueur est en vie ou non
     */
    public boolean getIsOut(){
        return (this.hp <= 0);
    }
    
    
    /**
     * Cette méthode réduit la vie du joueur selon la force de
     * l'attaque ennemi
     * @param damage correspond aux points de vies perdu
     */
    public void attacked(int damage) {
        if (damage > 0)
            this.hp -= damage;
    }

    
    /**
     * Cette méthode d'attaque appelle une méthode de créature pour
     * réduire la vie de l'ennemi selon les paramètres
     * @param monstre est l'ennemi combattu
     * @param damage correspond à la puissance de l'objet utilisé
     */
    public void attack(Creature monstre, int damage){
        monstre.attacked(damage);
    }

    
    /**
     * Cette méthode permet de changer l'emplacement du joueur dans
     * le jeu
     * @param lieu correspond au nouvel emplacement du joueur
     */
    public void setActualPlace(Place lieu){
        this.currentPlace=lieu;
    }

    
    /**
     * Cette méthode permet de récupèrer l'emplacement actuel du joueur
     * @return l'emplacement du joueur de type Place
     */
    public Place getActualPlace(){
        return this.currentPlace;
    }

    
    /**
     * Cette méthode permet de récupèrer le nom du joueur
     * @return son nom de type String
     */
    public String getName(){
        return this.NAME;
    }


    /**
     * Cette méthode récupère la saisie clavier du joueur
     * Toutes les commandes tapées passent par cette méthode
     * afin de vérifier que la commande saisie est valide.
     * Les arguments sont vérifiés ultérieurement.
     * On UpperCase la commande et LowerCase les argumentd
     * car c'est la convention choisie.
     * Cette méthode n'est appelée que dans le package racine
     */
    public void saisieCommand() {
        if (!this.getIsOut()){
            Boolean isException = false;
            Scanner sc = new Scanner(System.in);

            System.out.println("");
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

            if (!isException) this.executeCommand(ls); 
        }
    }


    /**
     * Cette méthode redirige la commande actuelle vers la méthode liée.
     * Elle n'est appelé que par saisieCommand.
     * @param ls correspond aux arguments qui seront nécessaires selon
     * la commande demandée.
     */
    private void executeCommand(List<String> ls) {
        switch(this.command){
            case GO:
                if (!this.inFight) this.goCommand(ls.size(), ls);
                else System.out.println("You cannot leave during fight!");
                break;    

            case HELP :
                this.helpCommand(ls.size(),ls);
                break;

            case LOOK:
                this.lookCommand(ls.size(), ls);
                break;

            case TAKE:
                if (!this.inFight) this.takeCommand(ls.size(),ls);
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


    /**
     * Cette méthode réagit à la saisie utilisateur GO
     * Elle ne peut être appelée que par executeCommand.
     * Go verifie que la sortie est bien voisine a la salle actuelle.
     * Sinon elle retourne le bon message d'erreur.
     * @param nbArgs corresponds aux nombres d'arguments donnés par le joueur
     * @param ls corresponds aux arguments donnés par le joueur
     */
    private void goCommand(int nbArgs, List<String> ls){
        Map<String,Exit> currentExits = this.currentPlace.getExits();
        Map<String,Exit> currentOpenExits = this.currentPlace.getOpenExits();

        if (nbArgs>0){
            if (currentOpenExits.containsKey(ls.get(0))){
                if("storeroom".equals(ls.get(0)) && !this.inventory.containsKey("torch")){
                    System.out.println("The room is to dark... You cannot go there...");
                }else {
                this.currentPlace = currentExits.get(ls.get(0)).getPlace();
                System.out.println("You are going to the " + this.currentPlace.getName() + "!\n");
                }
            }
            else if (currentExits.containsKey(ls.get(0))) System.out.println("This door seems locked! You cannot go there.");
            else if (this.currentPlace.getName().equals(ls.get(0))) System.out.println("You already are into this place!");
            else if (this.WORLD.getLISTEPLACES().containsKey(ls.get(0))) System.out.println("This place is too far away!");
            else System.out.println("This place doesn't exist!");
        } else {
            System.out.println("You cannot go nowhere!");
        }
    }

    /**
     * Cette méthode réagit à la saisie utilisateur HELP
     * Elle ne peut être appelée que par executeCommand.
     * Help donne les différentes utilisations des commandes.
     * Elle donne aussi le nom des items ou endroits demandées
     * pour éviter qu'un joueur soit bloqué.
     * @param nbArgs corresponds aux nombres d'arguments donnés par le joueur
     * @param ls corresponds aux arguments donnés par le joueur
     */
    private void helpCommand(int nbArgs, List<String> ls){
        Map<String,Exit> currentExits = this.currentPlace.getExits();
        Map<String,Thing> currentThings = this.currentPlace.getThings(); 
        
        if (nbArgs>0){
            System.out.println("Code names :");
            if (ls.get(0).equals("item") || ls.get(0).equals("items")) {
                currentThings.forEach((k,v) ->{
                    System.out.println(k);
                });  
            }
            else if (ls.get(0).equals("exit") || ls.get(0).equals("exits"))
                currentExits.forEach((k,v) ->{
                    System.out.println(k);
                });  
            else {
                for (int i = 0; i<Command.values().length;i++){
                    Command.values()[i].display();
                }
            }
        } else {
            for (int i = 0; i<Command.values().length;i++){
                Command.values()[i].display();
            }
        }
    }



    /**
     * Cette méthode réagit à la saisie utilisateur LOOK
     * Elle ne peut être appelée que par executeCommand.
     * Look affiche ce qu'il y a dans la salle
     * ou juste la description d'un item spécifié
     * @param nbArgs corresponds aux nombres d'arguments donnés par le joueur
     * @param ls corresponds aux arguments donnés par le joueur
     */
    private void lookCommand(int nbArgs, List<String> ls){
        Map<String,Thing> currentThings = this.currentPlace.getThings(); 

        if (nbArgs>0){
            if (currentThings.containsKey(ls.get(0))){        
                System.out.println("It is a " + currentThings.get(ls.get(0)));
            }
        } else {
            
                System.out.print("You are into ");
                System.out.println(this.currentPlace.toStringComplete());
           
        }
    }


    /**
     * Cette méthode réagit à la saisie utilisateur TAKE
     * Elle ne peut être appelée que par executeCommand.
     * Take permet au joueur de récupérer un item présent dans la salle.
     * @param nbArgs corresponds aux nombres d'arguments donnés par le joueur
     * @param ls corresponds aux arguments donnés par le joueur
     */
    private void takeCommand(int nbArgs, List<String> ls)
    {
        Map<String,Thing> currentThings = this.currentPlace.getThings();
        if (nbArgs>0){
            if (currentThings.containsKey(ls.get(0))){    
                if (Takable.class.isAssignableFrom(currentThings.get(ls.get(0)).getClass())){
                    this.inventory.put(ls.get(0),(Item)currentThings.get(ls.get(0)));
                    System.out.println("You take "
                            + this.inventory.get(ls.get(0)));

                    this.currentPlace.getThings().remove(ls.get(0));
                } else System.out.println("You cannot take this!");   
            } else System.out.println("It does not exist.");
        } else System.out.println("You cannot take nothing.");
    }


    /**
     * Cette méthode réagit à la saisie utilisateur QUIT
     * Elle ne peut être appelée que par executeCommand.
     * Quit permet à l'utilisateur de quitter le jeu.
     * On peut très bien imaginer une autre utilisation avec
     * de la sérialization pour charger différente parties.
     */
    private void quitCommand(){
        this.hp=0;
        System.out.println("You quit the game, bye!\n");
    }


     /**
     * Cette méthode réagit à la saisie utilisateur USE
     * Elle ne peut être appelée que par executeCommand.
     * USE est une commande très polyvalente.
     * On peut USE un item de l'inventaire, lorsqu'il a une utilisation seul
     * On peut USE un item sur une créature pour se battre, 
     * lui faisant plus ou moins de dégâts selon les arguments de l'item.
     * On peut USE un item sur un autre item pour fabriquer un nouvel item.
     * On peut USE un item (clé ou goldring) sur un lieu pour ouvrir une porte
     * fermé ou spéciale.
     * @param nbArgs corresponds aux nombres d'arguments donnés par le joueur
     * @param ls corresponds aux arguments donnés par le joueur
     */
    private void useCommand(int nbArgs, List<String> ls){
        Map<String,Creature> currentCreature = this.currentPlace.getCreatures();
        Map<String,Item> currentItems = this.currentPlace.getItems();
        Map<String,Exit> currentExits = this.currentPlace.getExits();            

        if (nbArgs>0){
            if (this.inventory.containsKey(ls.get(0))){ 
                if (nbArgs>1){ 
                    if (currentItems.containsKey(ls.get(1))) {
                        this.inventory.get(ls.get(0)).use(this.WORLD,currentItems.get(ls.get(1)));
                    }
                    else if (this.inventory.containsKey(ls.get(1))) {
                        this.inventory.get(ls.get(0)).use(this.WORLD,this.inventory.get(ls.get(1)));
                    }
                    else if (currentCreature.containsKey(ls.get(1))) {
                        this.inventory.get(ls.get(0)).use(this.WORLD,currentCreature.get(ls.get(1)));
                    }
                    else if (currentExits.containsKey(ls.get(1))){
                        this.inventory.get(ls.get(0)).use(this.WORLD,currentExits.get(ls.get(1)));
                    } else System.out.println("Second argument is not valid.");

                } else this.inventory.get(ls.get(0)).use(this.WORLD);

            } else if(currentItems.containsKey(ls.get(0)) 
                    && !Takable.class.isAssignableFrom(currentItems.get(ls.get(0)).getClass())) {
                currentItems.get(ls.get(0)).use(this.WORLD);
            }

            else System.out.println("First argument is not an item in your inventory.");

        } else System.out.println("You cannot use void.");

    }


     /**
     * Cette méthode réagit à la saisie utilisateur INVENTORY
     * Elle ne peut être appelée que par executeCommand.
     * Inventory affiche le profil du joueur ainsi que le contenu
     * de son inventaire.
     */
    private void inventoryCommand(){
        System.out.println("Your name : " + this.NAME 
                + "\nYour life points : " + this.hp 
                + "\nCurrent place : " + this.currentPlace);
        if(!inventory.isEmpty()){
            System.out.println("\nYour inventory : ");
            for (Item i : inventory.values()) System.out.println("- "+ i);           
        } else System.out.println("There is nothing in your inventory.");
    }

    
    /**
     * Cette méthode ajoute de la vie au joueur
     * @param hp correspond à la quantité de vie ajoutée 
     */
    public void addHp(int hp) {
        if (hp > 0)
            this.hp += hp;
    }

    
    /**
     * Cette méthode récupère tous les items présent dans l'inventaire
     * @return les éléments de l'inventaire du joueur sous forme de Map
     */
    public Map<String, Item> getInventory() {
        return inventory;
    }

    
    /**
     * Cette méthode est un getteur sur la vie du joueur
     * @return la vie du joueur sous forme d'entier
     */
    public int getHp() {
        return hp;
    }

    
    /**
     * Cette méthode est un setteur sur la mise en combat d'un joueur
     * @param inFight dit si le joueur est en combat, de type boolean 
     */
    public void setFight(boolean inFight) {
        this.inFight = inFight;
    }

    
    /**
     * Cette méthode est un getteur de la variable booléenne inFight
     * @return true ou false
     */
    public boolean isInFight() {
        return inFight;
    }
     
        
}