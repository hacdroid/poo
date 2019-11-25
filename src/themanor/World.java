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
        
        this.initPlace();
        this.initExit();
        this.initThing();
    }
    
    
   private void initPlace(){
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
        
        
        this.JOUEUR.setActualPlace(hall);
   }
   
   private void initExit(){
       
       this.LISTEPLACES.get(0).addExit();
       
       
       
       
       
       
       
   }
   
   
   
   private void initThing(){
        this.LISTEPLACES.get(0).addThing(new Bread());
        this.LISTEPLACES.get(0).addThing(new Broom());

        this.LISTEPLACES.get(1).addThing(new NPC(new Key())); //bottle d'eau contre clé
        
        this.LISTEPLACES.get(2).addThing(new Detergent());
        
        this.LISTEPLACES.get(3).addThing(new Chair(new Stick()));
        Thing armoire = new Wardrobe();
        this.LISTEPLACES.get(3).addThing(armoire);
        
        this.LISTEPLACES.get(4).addThing(new Bottle());
       
        this.LISTEPLACES.get(5).addThing(new Bat(new Electricmeter(new Key())));
        
        this.LISTEPLACES.get(6).addThing(new Computer(armoire)); //CONNAIT L'ARMOIRE
        
        this.LISTEPLACES.get(7).addThing(new Dust(new Key()));
        this.LISTEPLACES.get(7).addThing(new SpecialDoorSocle()); //AJOUTER SPECIAL DOOR
        
        this.LISTEPLACES.get(8).addThing(new Plants(new Wire())); 
        
        this.LISTEPLACES.get(9).addThing(new Map());
        
        this.LISTEPLACES.get(10).addThing(new Key());
  
        this.LISTEPLACES.get(11).addThing(new Torch());
        
        this.LISTEPLACES.get(12).addThing(new Scarecrow(new Fountain()));
        this.LISTEPLACES.get(12).addThing(new PoisonedLake(new Goldring()));
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