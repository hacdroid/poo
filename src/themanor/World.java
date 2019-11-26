package themanor;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Map;

public class World {

    private final List<Place> LISTEPLACES;
    private final Player JOUEUR;
    

    public World() {
        System.out.println("Veuillez entrer votre pseudonyme :");
        this.JOUEUR = new Player(new Scanner(System.in).nextLine(),this);
        this.LISTEPLACES = new ArrayList<>();
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
        Place bedroom1 = new Bedroom("bedroom1");
        Place bedroom2 = new Bedroom("bedroom2");
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
        livingroom.addExit("bedroom1", new Door(bedroom1));
        
        bedroom1.addExit("livingroom", new Door(livingroom));
        bedroom1.addExit("reserve", new SpecialDoor(reserve));
        bedroom1.addExit("bedroom2", new LockedDoor(bedroom2,5));
        
        bedroom2.addExit("bedroom1", new Door(bedroom1));
        
        loundge.addExit("livingroom", new Door(livingroom));
        loundge.addExit("garden", new Door(garden));
        
        reserve.addExit("bedroom1", new Door(bedroom1));
        
        garage.addExit("garden", new Door(garden));
        
        garden.addExit("garage", new LockedDoor(garage,1));
        garden.addExit("loundge", new Door(loundge));
        
        
        /*
        Initialisation des items et créatures
        */
        hall.addThing(new Bread());
        hall.addThing(new Broom());

        office.addThing(new NPC(new Key(1))); //bottle d'eau contre clé
        
        bathroom.addThing(new Detergent());
        
        lunchroom.addThing(new Chair(new Stick()));
        lunchroom.addThing(new Wardrobe(new Key(5)));
        
        kitchen.addThing(new Bottle());
       
        storeroom.addThing(new Bat(new Electricmeter(new Key(3))));
        
        livingroom.addThing(new Computer(lunchroom.getThings().get(1))); //CONNAIT L'ARMOIRE
        
        bedroom1.addThing(new Dust(new Key(2)));
        bedroom1.addThing(new SpecialDoorSocle(bedroom1.getExits().get(1))); //AJOUTER SPECIAL DOOR
        
        bedroom2.addThing(new Plants(new Wire())); 
        
        loundge.addThing(new gameMap());
        
        reserve.addThing(new Key(4));
  
        garage.addThing(new Torch());
        
        garden.addThing(new Scarecrow(new Fountain()));
        garden.addThing(new PoisonedLake(new Goldring()));
        
        
        /*
        Memorisation des différents lieux du jeu avec leurs attributs
        */        
        this.LISTEPLACES.add(hall);
        this.LISTEPLACES.add(office);
        this.LISTEPLACES.add(bathroom);
        this.LISTEPLACES.add(lunchroom);
        this.LISTEPLACES.add(kitchen);
        this.LISTEPLACES.add(storeroom);
        this.LISTEPLACES.add(livingroom);
        this.LISTEPLACES.add(bedroom1);
        this.LISTEPLACES.add(bedroom2);
        this.LISTEPLACES.add(loundge);
        this.LISTEPLACES.add(reserve);
        this.LISTEPLACES.add(garage);
        this.LISTEPLACES.add(garden);
        this.LISTEPLACES.add(outside);
        
        this.JOUEUR.setActualPlace(hall);
   }


    public void start() {
        // TODO - implement World.start

        System.out.println("Bienvenue dans.....................");
        
        
        
        //while ! this.JOUEUR.isOut || this.JOUEUR.actualPlace=NULL
        
        //sout(place.toString())
        // (item/exit demandé si LOOK)
        //getactual place = temp_place
        //while temp_place = actualplace et not this.JOUEUR.getIsOut(
        //joueur.saisieCommand()
        //end loop;
        //
        //end loop;
        //
        //if this.JOUEUR.isOut the PERDU
        //ELSE GAGNE
        //
        
        
        throw new UnsupportedOperationException();
    }

}