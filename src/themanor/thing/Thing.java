package themanor.thing;

public abstract class Thing {
    private final String NAME;
    private final Thing ITEMHIDE;

    public Thing(String name) {
        this.ITEMHIDE=null;
        this.NAME=name;
    }
        
    public Thing(String name,Thing itemHidden) {
        this.ITEMHIDE=itemHidden;
        this.NAME=name;
    }

    @Override
    public abstract String toString();
    
    public String getName(){
        return this.NAME;
    }

    public Thing getItemHide() {
        return ITEMHIDE;
    }
    
    
}