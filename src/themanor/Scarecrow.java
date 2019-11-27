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
        return "a scarecrow which seems hostile. It has " +
                this.getHp() + " life points.";
    }
}