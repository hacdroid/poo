package themanor.exit;

import themanor.place.Place;

public class LockedDoor extends Exit {

    private final int CODE_KEY;
    
    
    public LockedDoor (Place voisin, int code){
       super(voisin);
       this.CODE_KEY = code;
    }
    
    
    @Override
    public String toString() {
        String desc = ""; 
        
        if (this.isOpen()) {
            desc = desc.concat("an unlocked");
        } else desc = desc.concat("a locked");
        
        desc = desc.concat(" door, it leads to " + this.getPlace().toString());
        return desc;
    }
        
    
    @Override
    public void open(){
    }
    
    public boolean open(int code){
        if (this.CODE_KEY == code){
            super.open();
            return true;
        }
        else{
            return false;
        }
    }
}