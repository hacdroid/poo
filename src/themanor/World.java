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
        Place childbedroom = new Bedroom("child bedroom");
        Place adultbedroom = new Bedroom("adult bedroom");
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
        livingroom.addExit("child bedroom", new Door(childbedroom));
        
        childbedroom.addExit("livingroom", new Door(livingroom));
        childbedroom.addExit("reserve", new SpecialDoor(reserve));
        childbedroom.addExit("adult bedroom", new LockedDoor(adultbedroom,5));
        
        adultbedroom.addExit("child bedroom", new Door(childbedroom));
        
        loundge.addExit("livingroom", new Door(livingroom));
        loundge.addExit("garden", new Door(garden));
        
        reserve.addExit("bedroom1", new Door(childbedroom));
        
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
        
        childbedroom.addThing(new Dust(new Key(2)));
        childbedroom.addThing(new SpecialDoorSocle(childbedroom.getExits().get(1))); //AJOUTER SPECIAL DOOR
        
        adultbedroom.addThing(new Plants(new Wire())); 
        
        loundge.addThing(new gameMap());
        
        reserve.addThing(new Key(4));
  
        garage.addThing(new Torch());
        
        garden.addThing(new Scarecrow(new Fountain()));
        garden.addThing(new PoisonedLake(new Goldring()));
        
        
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
        this.LISTEPLACES.put("bedroom1",childbedroom);
        this.LISTEPLACES.put("bedroom2",adultbedroom);
        this.LISTEPLACES.put("loundge",loundge);
        this.LISTEPLACES.put("reserve",reserve);
        this.LISTEPLACES.put("garage",garage);
        this.LISTEPLACES.put("garden",garden);
        this.LISTEPLACES.put("outside",outside);
        
        this.JOUEUR.setActualPlace(hall);
   }


    public void start() {
        // TODO - implement World.start

        System.out.println("Welcome " + this.JOUEUR.getName() + " to \"the manor\"!");
        
        while(!this.JOUEUR.getIsOut() || this.JOUEUR.getActualPlace().equals(this.LISTEPLACES.get("outside"))){
            System.out.println("You are into " + this.JOUEUR.getActualPlace().toString());
            
            this.JOUEUR.saisieCommand();
        }

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
        
    }
    

    
    
//    public Place getPlaceVoisin(String place){
//    
//        if (this.JOUEUR.getActualPlace().getOpenExits().containsKey(place)){
//            for(Map.Entry<String, Place> entry : this.LISTEPLACES.entrySet()){
//                if (entry.getKey().equals(place)){
//                    return entry.getValue();
//                }
//            }
//        } else if (this.JOUEUR.getActualPlace().getExits().containsKey(place)) {
//            System.out.println("This door seems locked! You cannot go there.");
//        } else if (this.LISTEPLACES.containsKey(place)){
//            System.out.println("This place is too far away!");
//        } else {
//            System.out.println("This place doesn't exist!");
//        }
//        return this.JOUEUR.getActualPlace();
//    }
    
    public Place getPlaceVoisin(String place){
    
        if (this.JOUEUR.getActualPlace().getOpenExits().containsKey(place)) return this.LISTEPLACES.get(place);
        else if (this.JOUEUR.getActualPlace().getExits().containsKey(place)) System.out.println("This door seems locked! You cannot go there.");
        else if (this.JOUEUR.getActualPlace().getName().equals(place)) System.out.println("You already are into this place!");
        else if (this.LISTEPLACES.containsKey(place)) System.out.println("This place is too far away!");
        else System.out.println("This place doesn't exist!");
        
        return this.JOUEUR.getActualPlace();
    }

}