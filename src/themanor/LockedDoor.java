package themanor;

public class LockedDoor extends Exit {

    private final int CODE_KEY;
    
    
    public LockedDoor (Place voisin, int code){
       super(voisin);
       this.CODE_KEY = code;
    }
    
    
    @Override
    public String toString() {
        String etat;
        
        if (this.isOpen()) etat = "ouverte, elle mène à " +
                this.getVoisin().toString();
        else etat = "fermée";
        
        return "Une porte est " + etat + ".";
    }
    
    @Override
    public void open(){
        System.out.println("ERROR CODE OPEN");
    }
    
    public void open(int code){
        if (this.CODE_KEY == code) super.open();
        else System.out.println("Ce n'est pas la bonne clé !");
    }
}