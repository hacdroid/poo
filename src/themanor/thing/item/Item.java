package themanor.thing.item;

import themanor.World;
import themanor.exit.Exit;
import themanor.thing.Thing;
import themanor.thing.creature.Creature;


/**
 * Classe abstraite des items
 * @author alexa
 */
public abstract class Item extends Thing {
    
    
    /**
     * Constructeur d'un item ne faisant aucun dégats
     * @param name correspond au nom de l'item
     */
    public Item(String name){
        super(name,0);
    }

    
    /**
     * Constructeur d'un item cachant un autre item
     * @param name correspond au nom de l'item
     * @param itemHidden correspond à un item débloquable
     */
    public Item(String name, Thing itemHidden){
        super(name, itemHidden, 0);
    }


    /**
     * Constructeur d'un item
     * @param name correspond au nom de l'item
     * @param damage correspond au dégats de cet item en combat
     */
    public Item(String name, int damage){
        super(name,damage);
    }

    
    /**
     * Constructeur d'un item cachant un autre item
     * @param name correspond au nom de l'item
     * @param itemHidden correspond à un item débloquable
     * @param damage correspond au dégats de cet item en combat
     */
    public Item(String name, Thing itemHidden, int damage) {
        super(name, itemHidden,damage);
    }

    
    /**
     * Cette méthode réalise l'utilisation (ou non) qu'un item peut avoir seul.
     * On peut manger du pain par exemple.
     * @param w correspond au monde
     */
    public void use(World w){
        System.out.println("You cannot use it this way!");
    }

    
    /**
     * Cette méthode réalise l'utilisation (ou non) qu'un item peut avoir avec
     * un autre item.
     * On peut fabriquer une canne à pêche avec du fil et un baton.
     * @param w correspond au monde
     * @param i correspond au second item
     */
    public void use(World w,Item i){
        System.out.println("You cannot use both together.");
    }

    
    /**
     * Cette méthode réalise l'utilisation (ou non) qu'un item peut avoir sur
     * une créature en combat.
     * On peut frapper une chauve-souris avec un balai.
     * @param w correspond au monde
     * @param c correspond au monstre combattu
     */
    public void use(World w,Creature c){        

        if (!w.getJoueur().isInFight()) System.out.println("You start a fight with " + c.getName() + ", " + c.getHp() + " life points.\n");
        w.getJoueur().attack(c, DAMAGE);
        System.out.println("You hit the monster with " + this.getName() + "! He have " + c.getHp() + " life points.\n");
        if (!c.getIsOut()){
            c.attack(w.getJoueur());
            System.out.println("The creature attack you. You have now " + w.getJoueur().getHp() + " life points.\n"); 
        }
        if (!w.getJoueur().getIsOut() && !c.getIsOut()){
            w.getJoueur().setFight(true);                
        } else {
            w.getJoueur().setFight(false);
        }  
        if (c.getIsOut()){
            System.out.println("You have killed the " + c.getName() + "!");
            w.getJoueur().getActualPlace().getThings().remove(c.getName());
            if (c.haveAHiddenItem()){
                System.out.println("It was hiding a " + c.getItemHide().getName() + "!");
                w.getJoueur().getActualPlace().addThing(c.getItemHide());
                c.removeItemHide();
            }else System.out.println("\nNothing to unlock!");
            
        }
    }

    
    /**
     * Cette méthode réalise l'utilisation (ou non) qu'un item peut avoir sur
     * une destination.
     * Une clé pourra ouvrir la porte pour aller dans la cuisine par exemple.
     * @param w correspond au monde
     * @param e correspond à la sortie choisie
     */
    public void use(World w,Exit e){
        System.out.println("You cannot use it on a door!");
    }

    
    /**
     * On redéfinit la méthode toString pour chaque porte
     * @return le message type String
     */  
    @Override
    public abstract String toString();

}