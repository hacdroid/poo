package themanor.thing;


/**
 * Classe abstraite des entités du jeu
 * @author alexa
 */
public abstract class Thing {
    private final String NAME;
    private Thing itemHide;
    protected final int DAMAGE;

    
    /**
     * Constructeur des entités
     * @param name correspond au nom de l'entité
     * @param damage correspond au dégat causé par l'entité contre une créature
     */
    public Thing(String name, int damage) {
        this.itemHide=null;
        if (name==null) this.NAME="unnamed";
        else this.NAME=name;
        this.DAMAGE=damage;
    }
     
    
    /**
     * Constructeur des entités
     * @param name correspond au nom de l'entité
     * @param itemHidden correspond à un item débloquable par la suite
     * @param damage correspond au dégat causé par l'entité contre une créature
     */
    public Thing(String name,Thing itemHidden, int damage) {
        this.itemHide=itemHidden;
        if (name==null) this.NAME="unnamed";
        else this.NAME=name;
        this.DAMAGE=damage;
    }

    
    /**
     * Méthode pour récupèrer le nom de l'item
     * @return le nom de type String
     */
    public String getName(){
        return this.NAME;
    }

    
    /**
     * Cette méthode donne l'item débloquable
     * @return l'entité de type Thing
     */
    public Thing getItemHide() {
        return itemHide;
    }
    
    
    /**
     * Cette méthode retire l'item débloquable
     */
    public void removeItemHide(){
        this.itemHide=null;
    }
    
    
    /**
     * On redéfinit la méthode toString pour chaque porte
     * @return le message type String
     */    
    @Override
    public abstract String toString();
}