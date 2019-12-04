/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package themanor.thing.item;

import themanor.World;
import themanor.thing.Thing;

/**
 * Classe d'une armoire électroniquement bloquée
 * @author alexa
 */
public class Wardrobe extends Item {
    private boolean lock = true;
    
    public Wardrobe(String name) {
        super(name);
    }

    public Wardrobe(String name, Thing itemHidden) {
        super(name, itemHidden);
    }
    

    /**
     * La méthode de récupérer une clé dans l'armoire
     * @param w correspond au monde
     */
    @Override
    public void use(World w) {
        if (lock){
            System.out.println("It seems to be electronically locked!");
        } else {
            System.out.println("There is the " + this.getItemHide().getName() + " into this wardrobe!");
            w.getJoueur().getActualPlace().getThings().remove(this.getName());
            w.getJoueur().getActualPlace().addThing(this.getItemHide());
        }   
    }

    
    /**
     * On redéfinit la méthode toString pour chaque porte
     * @return le message type String
     */      
    @Override
    public String toString() {
        return("an electronic wardrobe");
    }

    
    /**
     * Cette méthode permet à l'ordinateur de débloquer l'armoir
     */
    public void unlock() {
        this.lock = false;
    }
    
    
    /**
     * Cette méthode permet de vérifier si l'armoire est débloquée
     * @return un booléen
     */
    public boolean isLocked(){
        return this.lock;
    }
}
