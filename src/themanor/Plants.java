package themanor;

public class Plants extends Creature {

    public Plants() {
        super(20, 3);
    }

    public Plants(Thing itemHidden) {
        super(20, 5, itemHidden);
    }

    @Override
    public String toString() {
        return "Il y a une plante carnivore qui semble hostile. Elle a " +
                this.getHp() + " point(s) de vie.";
    }
}