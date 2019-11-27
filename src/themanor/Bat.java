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
        return "There is a big black bat flying in this room. It's got " +
                this.getHp() + " life point.";
    }
}

//Test de commentaire de hugo ! 