package themanor.thing.item;

import themanor.World;
import themanor.exit.Exit;
import themanor.exit.LockedDoor;
import themanor.interfaces.Takable;


/**
 * Classe d'une clé 
 * qui utilise un code pour débloquer une porte
 * @author alexa
 */
public class Key extends Item implements Takable {
    private final int CODE;
    
    public Key(String name, int code) {
        super(name,4);
        this.CODE=code;
    }

    
    /**
     * Cette méthode donne des indications sur l'utilisation du clé
     * @param w correspond au monde
     */
    @Override
    public void use(World w) {
        System.out.println("You need to specify the door place to use.");
    }
    
    
    /**
     * Cette méthode permet d'ouvrir une porte avec une clé ayant le bon code
     * @param w correspond au monde
     * @param e correspond à la sortie choisie
     */
    @Override
    public void use(World w,Exit e){
        if (e instanceof LockedDoor){
            if (!((LockedDoor)e).isOpen()){
                if(((LockedDoor) e).open(CODE)){
                    System.out.println("You opened the door!\nNow, you can go to the " + e.getPlace().getName());
                    w.getJoueur().getInventory().remove(this.getName());
                } else{
                    System.out.println("You did not use the right key to open this door...");
                }
            } else System.out.println("Door already open..."); //NORMALEMENT N'ATTEINT JAMAIS CET ENDROIT!
  
        } else super.use(w, e);

    }


    /**
     * On redéfinit la méthode toString pour chaque porte
     * @return le message type String
     */  
    @Override
    public String toString() {
        return("the key" + this.CODE);
    }
}