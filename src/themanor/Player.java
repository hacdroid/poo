package themanor;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private final String NAME;
	private List<Item> inventory;
	private Command command;
	private int hp;
	private Place actualPlace;

	/**
	 * 
	 * @param name
	 */
	public Player(String name, World w) {
		this.NAME=name;
                this.hp=20;
                this.inventory= new ArrayList<>();
                //actual Place
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
                    //mettre commande dans this.command
                    //executeCommand(List<String>);
                    
                    
                }
	}

	/**
	 * 
	 * @param ls
	 */
	public void executeCommand(List<String> ls) {

            switch(this.command){
                case GO:
                    
                    //SI IL Y A UN SEUL ARGUMENT
                    //   SI ELLE EST VOISINE
                    //       this.actualPlace=?;
                       // this.actualPlace.getName()
                    
                    
                    
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
                default:
                    System.out.println("Cette commande ne semble pas exister...");
    

                
            }
            
            
            
            
            
	}

}