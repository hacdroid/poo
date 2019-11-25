package themanor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class World {

    private final List<Place> LISTEPLACES;
    private final Player JOUEUR;

    public World() {
        System.out.println("Veuillez entrer votre pseudonyme :");
        this.JOUEUR = new Player(new Scanner(System.in).nextLine(),this);
        this.LISTEPLACES = new ArrayList<>();
        
        this.initGame();
    }
    
    
   private void initGame(){
        Place hall = new Hall("hall");
        Place bureau = new Office("bureau");
        Place sd_bain = new Bathroom("sd_bain");
        Place sa_manger = new Lunchroom("sa_manger");
        Place cuisine = new Kitchen("cuisine");
        Place debarras = new Storeroom("débarras");
        Place sd_vie = new Livingroom("sd_vie");
        Place chambre1 = new Bedroom("chambre1");
        Place chambre2 = new Bedroom("chambre2");
        Place sejour = new Loundge("séjour");
        Place reserve = new Reserve("réserve");
        Place garage = new Garage("garage");
        Place jardin = new Garden("jardin");
        Place dehors = new Outside("dehors");
        
        /*
        Initialisation des sorties
        */
        hall.addExit(new LockedDoor(dehors,4));
        hall.addExit(new Door(bureau));
        hall.addExit(new Door(sd_vie));
        hall.addExit(new Door(sa_manger));
        
        bureau.addExit(new LockedDoor(sd_bain,3));
        bureau.addExit(new Door(sd_vie));
        bureau.addExit(new Door(hall));
        
        sd_bain.addExit(new Door(bureau));
        
        sa_manger.addExit(new Door(hall));
        sa_manger.addExit(new Door(cuisine));
        
        cuisine.addExit(new Door(sa_manger));
        
        debarras.addExit(new Door(sd_vie));
        
        sd_vie.addExit(new Door(hall));
        sd_vie.addExit(new Door(bureau));
        sd_vie.addExit(new Door(reserve));
        sd_vie.addExit(new Door(sejour));
        sd_vie.addExit(new Door(chambre1));
        
        chambre1.addExit(new Door(sd_vie));
        chambre1.addExit(new SpecialDoor(reserve));
        chambre1.addExit(new LockedDoor(chambre2,5));
        
        chambre2.addExit(new Door(chambre1));
        
        sejour.addExit(new Door(sd_vie));
        sejour.addExit(new Door(jardin));
        
        reserve.addExit(new Door(chambre1));
        
        garage.addExit(new Door(jardin));
        
        jardin.addExit(new LockedDoor(garage,1));
        jardin.addExit(new Door(sejour));
        
        /*
        Initialisation des items et créatures
        */
        hall.addThing(new Bread());
        hall.addThing(new Broom());

        bureau.addThing(new NPC(new Key(1))); //bottle d'eau contre clé
        
        sd_bain.addThing(new Detergent());
        
        sa_manger.addThing(new Chair(new Stick()));
        sa_manger.addThing(new Wardrobe(new Key(5)));
        
        cuisine.addThing(new Bottle());
       
        debarras.addThing(new Bat(new Electricmeter(new Key(3))));
        
        sd_vie.addThing(new Computer(sa_manger.getThings().get(1))); //CONNAIT L'ARMOIRE
        
        chambre1.addThing(new Dust(new Key(2)));
        chambre1.addThing(new SpecialDoorSocle(chambre1.getExits().get(1))); //AJOUTER SPECIAL DOOR
        
        chambre2.addThing(new Plants(new Wire())); 
        
        sejour.addThing(new Map());
        
        reserve.addThing(new Key(4));
  
        garage.addThing(new Torch());
        
        jardin.addThing(new Scarecrow(new Fountain()));
        jardin.addThing(new PoisonedLake(new Goldring()));
        
        /*
        Memorisation des différents lieux du jeu avec leurs attributs
        */        
        this.LISTEPLACES.add(hall);
        this.LISTEPLACES.add(bureau);
        this.LISTEPLACES.add(sd_bain);
        this.LISTEPLACES.add(sa_manger);
        this.LISTEPLACES.add(cuisine);
        this.LISTEPLACES.add(debarras);
        this.LISTEPLACES.add(sd_vie);
        this.LISTEPLACES.add(chambre1);
        this.LISTEPLACES.add(chambre2);
        this.LISTEPLACES.add(sejour);
        this.LISTEPLACES.add(reserve);
        this.LISTEPLACES.add(garage);
        this.LISTEPLACES.add(jardin);
        this.LISTEPLACES.add(dehors);
        
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