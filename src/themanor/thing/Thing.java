package themanor.thing;

public abstract class Thing {
    private final String NAME;
    private Thing itemHide;
    protected final int DAMAGE;

    public Thing(String name, int damage) {
        this.itemHide=null;
        this.NAME=name;
        this.DAMAGE=damage;
    }
        
    public Thing(String name,Thing itemHidden, int damage) {
        this.itemHide=itemHidden;
        this.NAME=name;
        this.DAMAGE=damage;
    }

    @Override
    public abstract String toString();
    
    public String getName(){
        return this.NAME;
    }

    public Thing getItemHide() {
        return itemHide;
    }
    
    public void removeItemHide(){
        this.itemHide=null;
    }
    
}