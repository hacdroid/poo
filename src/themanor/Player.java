package themanor;

import java.util.ArrayList;
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
                List<String> ls = new ArrayList<>();
                Boolean isException = false;
                Scanner sc = new Scanner(System.in);
                System.out.println("Saisie : ");
                String commande = sc.next();
                String arg = sc.next();
                System.out.println("Vous avez saisi : " + commande +" " + arg);

                ls.add(arg);

                try {
                    this.command=Command.valueOf(commande);
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
            int nbArgs = 1;
            
            switch(this.command){
                case GO:
                    if (nbArgs==1){
                        this.actualPlace = this.WORLD.getPlaceVoisin(ls.get(0));
                    }
                    break;
                case HELP :
                    break;
                case LOOK:
                    break;
                case TAKE:
                    break;
                case QUIT:
                    break;
                case USE:
                    break;
                case INVENTORY:
                    break;
                case KILL:
                    this.hp=0;
                    break;
                default:
                    System.out.println("Cette commande ne semble pas exister...");
    

                
            }
            
            
            
            
            
	}

}