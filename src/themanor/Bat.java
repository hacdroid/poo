package themanor;

public class Bat extends Creature {
    
    public Bat(){
        super(10, 1);
    }
    
    public Bat(Thing itemHidden) {
        super(10, 1, itemHidden);
    }
    
    
    @Override
    public String toString() {
        return "Il y a une chauve-souris qui semble hostile. Elle a " +
                this.getHp() + " point(s) de vie.";
    }
}

//Test de commentaire de hugo ! 