package themanor;

import java.util.HashMap;
import themanor.thing.item.NPC;
import themanor.exit.*;
import themanor.thing.creature.*;
import themanor.place.*;
import themanor.thing.item.*;
import java.util.Scanner;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Un monde est caractérisé par un seul joueur et
 * une liste de salles.
 * @author alexa
 */
public class World {

    private final Map<String,Place> LISTEPLACES  = new HashMap<>();
    private Player joueur;
    
    
    /**
     * Le constructeur World récupère le nom du saisi par le joueur
     * et initialise le joueur, les salles et toutes les entités de
     * la partie.
     */
    public World() {
        System.out.println("Veuillez entrer votre pseudonyme :");
        try{
            this.joueur = new Player(new Scanner(System.in).nextLine(),this);
        }
        catch(NoSuchElementException e){
            this.joueur = new Player("player", this);
        }
        // Le try catch est utile pour les tests
        this.initGame();
    }
    
    /**
     * Cette méthode initialise chaque élément du jeu avec leurs liens.
     * On initialise les salles, leurs liens de sorties, les items
     * de chaque salle (éventuellement caché derrière un autre item).
     * Elle n'est appelée que par le constructeur World.
     */
    private void initGame(){
        /*
        Initialisation des salles
        */
        Place hall = new Hall("hall");
        Place office = new Office("office");
        Place bathroom = new Bathroom("bathroom");
        Place lunchroom = new Lunchroom("lunchroom");
        Place kitchen = new Kitchen("kitchen");
        Place storeroom = new Storeroom("storeroom");
        Place livingroom = new Livingroom("livingroom");
        Place childbedroom = new Bedroom("childbedroom");
        Place adultbedroom = new Bedroom("adultbedroom");
        Place loundge = new Loundge("loundge");
        Place reserve = new Reserve("reserve");
        Place garage = new Garage("garage");
        Place garden = new Garden("garden");
        Place outside = new Outside("outside");
        
        /*
        Initialisation des différentes sorties
        */       
        hall.addExit("outside", new LockedDoor(outside,4));
        hall.addExit("office", new Door(office));
        hall.addExit("livingroom", new Door(livingroom));
        hall.addExit("lunchroom", new Door(lunchroom));
        office.addExit("bathroom", new LockedDoor(bathroom,3));
        office.addExit("livingroom", new Door(livingroom));
        office.addExit("hall", new Door(hall));
        bathroom.addExit("office", new Door(office));
        lunchroom.addExit("hall", new Door(hall));
        lunchroom.addExit("kitchen", new Door(kitchen));
        kitchen.addExit("lunchroom", new Door(lunchroom));
        storeroom.addExit("livingroom", new Door(livingroom));
        livingroom.addExit("hall", new Door(hall));
        livingroom.addExit("office", new Door(office));
        livingroom.addExit("storeroom", new Door(storeroom));
        livingroom.addExit("loundge", new LockedDoor(loundge,2));
        livingroom.addExit("childbedroom", new Door(childbedroom));
        childbedroom.addExit("livingroom", new Door(livingroom));
        childbedroom.addExit("reserve", new SpecialDoor(reserve));
        childbedroom.addExit("adultbedroom", new LockedDoor(adultbedroom,5));
        adultbedroom.addExit("childbedroom", new Door(childbedroom));
        loundge.addExit("livingroom", new Door(livingroom));
        loundge.addExit("garden", new Door(garden));
        reserve.addExit("childbedroom", new Door(childbedroom));
        garage.addExit("garden", new Door(garden));
        garden.addExit("garage", new LockedDoor(garage,1));
        garden.addExit("loundge", new Door(loundge));
         
        /*
        Initialisation des entités
        */
        hall.addThing(new Scarecrow("scarecrow",new Stick("stick")));
        hall.addThing(new Bat("bat",new Stick("stick2")));
        hall.addThing(new Bread("bread"));
        hall.addThing(new Broom("broom"));
        office.addThing(new NPC("man", new Key("key1",1)));
        bathroom.addThing(new Detergent("detergent"));
        lunchroom.addThing(new Chair("chair", new Stick("stick")));
        lunchroom.addThing(new Wardrobe("wardrobe", new Key("key5",5)));
        kitchen.addThing(new Bottle("bottle"));
        storeroom.addThing(new Bat("bat", new Electricmeter("electricmeter", new Key("key3",3))));
        livingroom.addThing(new Computer("computer", lunchroom.getThings().get("wardrobe")));
        childbedroom.addThing(new Dust("dust",new Key("key2",2)));
        childbedroom.addThing(new SpecialDoorSocle("socle", childbedroom.getExits().get("reserve")));  
        adultbedroom.addThing(new Plants("plants",new Wire("wire",new Fishingrod("fishingrod")))); 
        loundge.addThing(new WorldMap("map"));
        reserve.addThing(new Key("key4",4));
        garage.addThing(new Torch("torch"));
        garden.addThing(new Scarecrow("scarecrow",new Fountain("fountain", new WaterBottle("waterbottle"))));
        garden.addThing(new PoisonedLake("poisonedlake",new Goldring("goldring")));

        
        /*
        Sauvegarde des différents lieux du jeu avec leurs attributs
        */        
        this.LISTEPLACES.put("hall",hall);
        this.LISTEPLACES.put("office",office);
        this.LISTEPLACES.put("bathroom",bathroom);
        this.LISTEPLACES.put("lunchroom",lunchroom);
        this.LISTEPLACES.put("kitchen",kitchen);
        this.LISTEPLACES.put("storeroom",storeroom);
        this.LISTEPLACES.put("livingroom",livingroom);
        this.LISTEPLACES.put("childbedroom",childbedroom);
        this.LISTEPLACES.put("adultbedroom",adultbedroom);
        this.LISTEPLACES.put("loundge",loundge);
        this.LISTEPLACES.put("reserve",reserve);
        this.LISTEPLACES.put("garage",garage);
        this.LISTEPLACES.put("garden",garden);
        this.LISTEPLACES.put("outside",outside);
        
        
        /*
        On set le joueur dans le hall au début de la partie
        */
        this.joueur.setActualPlace(hall);
   }


    /**
     * Cette méthode est la boucle de jeu.
     * C'est elle qui attend la saisie du joueur et qui
     * annonce la fin du jeu.
     */
    public void start() {
        System.out.println("");
        System.out.println("");
        System.out.println("At anytime, type HELP to see your commands.\n" 
                + "Welcome " 
                + this.joueur.getName() + " to \"the manor\"! "
                + "You wake up .. you have a headache, you do not know where you are. \n" 
                + "You get up, you have cramps in your legs and tremble lightly. \n"
                + "You have to get out of here and go home, but the door is locked, how to get out?\n"
                + "It's dark, the electricity seems cut off...\n"
                + "\n\nYou are into the hall");
        
        while(!this.joueur.getIsOut() && !this.joueur.getActualPlace().equals(this.LISTEPLACES.get("outside")))
            this.joueur.saisieCommand();
        
        if (this.joueur.getIsOut())
            System.out.println("YOU LOOSE : GAME OVER!");
        else if(this.joueur.getActualPlace().equals(this.LISTEPLACES.get("outside")))
            System.out.println("YOU WIN!"); 
    }

    
    /**
     * Cette méthode est un getteur sur les salles
     * @return correspond à toutes les salles du monde.
     */
    public Map<String, Place> getLISTEPLACES() {
        return LISTEPLACES;
    }    

    
    /**
     * Cette méthode est un getteur sur le joueur
     * @return correspond au joueur du monde actuel.
     */
    public Player getJoueur() {
        return joueur;
    }
}