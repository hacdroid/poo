package themanor;

public abstract class Thing {
    private Thing itemHide;

    public Thing() {
        this.itemHide=null;
    }
        
    public Thing(Thing itemHidden) {
        this.itemHide=itemHidden;
    }

    public abstract String toString();
}