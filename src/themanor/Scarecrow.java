package themanor;

public class Scarecrow extends Creature {

    public Scarecrow() {
        super(30, 5);
    }

    public Scarecrow(Thing itemHidden) {
        super(30, 5, itemHidden);
    }


    @Override
    public String toString() {
        return "Il y a un épouvantail qui semble hostile. Il a " +
                this.getHp() + " point(s) de vie.";
    }
}