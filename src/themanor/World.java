package themanor;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Map;
import java.util.stream.Stream;

public class World {

    private final Map<String,Place> LISTEPLACES;

    private final Player JOUEUR;
    
    

    public World() {
        System.out.println("Veuillez entrer votre pseudonyme :");
        this.JOUEUR = new Player(new Scanner(System.in).nextLine(),this);
        this.LISTEPLACES = new LinkedHashMap<>();
        this.initGame();
    }
    
    /**
     * Méthode d'intialisation des lieux, 
     */
    private void initGame(){
        Place hall = new Hall("hall");
        Place office = new Office("office");
        Place bathroom = new Bathroom("bathroom");
        Place lunchroom = new Lunchroom("lunchroom");
        Place kitchen = new Kitchen("kitchen");
        Place storeroom = new Storeroom("storeroom");
        Place livingroom = new Livingroom("livingroom");
        Place childbedroom = new Bedroom("child_bedroom");
        Place adultbedroom = new Bedroom("adult_bedroom");
        Place loundge = new Loundge("loundge");
        Place reserve = new Reserve("reserve");
        Place garage = new Garage("garage");
        Place garden = new Garden("garden");
        Place outside = new Outside("outside");
        
         /*
        Initialisation des sorties
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
        livingroom.addExit("child_bedroom", new Door(childbedroom));
        
        childbedroom.addExit("livingroom", new Door(livingroom));
        childbedroom.addExit("reserve", new SpecialDoor(reserve));
        childbedroom.addExit("adult_bedroom", new LockedDoor(adultbedroom,5));
        
        adultbedroom.addExit("child_bedroom", new Door(childbedroom));
        
        loundge.addExit("livingroom", new Door(livingroom));
        loundge.addExit("garden", new Door(garden));
        
        reserve.addExit("child_bedroom", new Door(childbedroom));
        
        garage.addExit("garden", new Door(garden));
        
        garden.addExit("garage", new LockedDoor(garage,1));
        garden.addExit("loundge", new Door(loundge));
        
        
        /*
        Initialisation des items et créatures
        */
        hall.addThing("bread",new Bread());
        hall.addThing("broom",new Broom());
        
        office.addThing("man",new NPC(new Key(1))); //bottle d'eau contre clé
        
        bathroom.addThing("detergent",new Detergent());
        
        lunchroom.addThing("chair",new Chair(new Stick()));
        lunchroom.addThing("wardrobe",new Wardrobe(new Key(5)));
        
        kitchen.addThing("bottle",new Bottle());
       
        storeroom.addThing("bat",new Bat(new Electricmeter(new Key(3))));
        
        livingroom.addThing("computer",new Computer(lunchroom.getThings().get(1))); //CONNAIT L'ARMOIRE
        
        childbedroom.addThing("dust",new Dust(new Key(2)));
        childbedroom.addThing("socle",new SpecialDoorSocle(childbedroom.getExits().get(1))); //AJOUTER SPECIAL DOOR
        
        adultbedroom.addThing("plants",new Plants(new Wire())); 
        
        loundge.addThing("oldMap",new WorldMap());
        
        reserve.addThing("key",new Key(4));
  
        garage.addThing("torch",new Torch());
        
        garden.addThing("scarecrow",new Scarecrow(new Fountain()));
        garden.addThing("poisoned_lake",new PoisonedLake(new Goldring()));
        
        
        /*
        Memorisation des différents lieux du jeu avec leurs attributs
        */        
        this.LISTEPLACES.put("hall",hall);
        this.LISTEPLACES.put("office",office);
        this.LISTEPLACES.put("bathroom",bathroom);
        this.LISTEPLACES.put("lunchroom",lunchroom);
        this.LISTEPLACES.put("kitchen",kitchen);
        this.LISTEPLACES.put("storeroom",storeroom);
        this.LISTEPLACES.put("livingroom",livingroom);
        this.LISTEPLACES.put("child_bedroom",childbedroom);
        this.LISTEPLACES.put("adult_bedroom",adultbedroom);
        this.LISTEPLACES.put("loundge",loundge);
        this.LISTEPLACES.put("reserve",reserve);
        this.LISTEPLACES.put("garage",garage);
        this.LISTEPLACES.put("garden",garden);
        this.LISTEPLACES.put("outside",outside);
        
        this.JOUEUR.setActualPlace(hall);
   }


    public void start() {
        System.out.println("At anytime, type HELP to see your commands.\n");
        
        System.out.println("Welcome " + this.JOUEUR.getName() + " to \"the manor\"!");
        
        
        
        System.out.println("You wake up .. you have a headache, you do not know where you are. \n" 
                + "You get up, you have cramps in your legs and tremble lightly. \n"
                + "You have to get out of here and go home, but the door is locked, how to get out?\n"
                + "\n"
                + "\n"
                + "You are into the hall");
        
        
        while(!this.JOUEUR.getIsOut()|| this.JOUEUR.getActualPlace().equals(this.LISTEPLACES.get("outside")))
            this.JOUEUR.saisieCommand();
        
        
        if (this.JOUEUR.getIsOut()){
            System.out.println("YOU LOOSE : GAME OVER!");
        } else if(this.JOUEUR.getActualPlace().equals(this.LISTEPLACES.get("outside"))) {
            System.out.println("YOU WIN!");
        }        
        
    }

    public Map<String, Place> getLISTEPLACES() {
        return LISTEPLACES;
    }    


}