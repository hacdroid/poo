package themanor.thing.item;

import themanor.World;
import themanor.interfaces.Takable;
import themanor.thing.Thing;


/**
 * Classe d'un balai
 * @author alexa
 */
public class Broom extends Item implements Takable{

    public Broom(String name) {
        super(name,10);
    }

    public Broom(String name, Thing itemHidden) {
        super(name, itemHidden,10);
    }
    
    
    /**
     * Méthode d'un balai qui retire de la poussière pour faire 
     * apparaitre un objet caché
     * @param w correspond au monde
     * @param i correspond à la poussière
     */
    @Override
    public void use(World w,Item i){
        if (i instanceof Dust){
            System.out.println("You sweep the dust... ");
            if(i.haveAHiddenItem()){
                System.out.println("There was " + i.getItemHide().getName() + " under the dust!\nThere is now, a key on the ground.");
                w.getJoueur().getActualPlace().addThing(i.getItemHide());
                i.removeItemHide();
            }else System.out.println("\nNothing to unlock!");
            w.getJoueur().getActualPlace().getThings().remove(i.getName());
        }else{
            super.use(w, i);
        }
    }
    

    /**
     * On redéfinit la méthode toString pour chaque porte
     * @return le message type String
     */  
    @Override
    public String toString() {
        return("an old broom");
    }
}