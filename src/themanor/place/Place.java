package themanor.place;

import java.util.HashMap;
import themanor.thing.item.Item;
import themanor.thing.creature.Creature;
import themanor.thing.Thing;
import java.util.LinkedHashMap;
import java.util.Map;
import themanor.exit.Exit;


/**
 * Classe abstraire des différentes salles
 * @author alexa
 */
public abstract class Place {
    private final Map<String,Thing> THINGS = new HashMap<>();
    private final String NAME;
    private final Map<String,Exit> EXITS =  new HashMap<>();
    public static boolean isElectricityOn;


    /**
     * Constructeur d'une salle caractérisée par un nom, des entités
     * et des portes sur des salles voisines
     * @param name correspond au nom de la salle
     */
    public Place(String name) {
        if (name == null) this.NAME="unnamed_room";
        else this.NAME=name;
        isElectricityOn=false;
    }


    /**
     * Méthode pour récupèrer le nom de la salle
     * @return le nom de type String
     */
    public String getName(){
        return this.NAME;
    }


    /**
     * Méthode pour ajouter des entités dans la liste
     * des entités présentent dans une salle
     * @param item correspond à l'entité à ajouter
     */
    public void addThing(Thing item) {
        this.THINGS.put(item.getName(), item);
    }


    /**
     * Méthode pour ajouter des sorties dans la liste
     * des sorties présentent dans une salle
     * @param name correspond au nom de la place voisine
     * @param sortie correspond à la sortie à ajouter
     */
    public void addExit(String name, Exit sortie){
        this.EXITS.put(name,sortie);
    }


    /**
     * Méthode pour récupèrer les entités de la salle
     * @return les entités de type Map
     */
    public Map<String,Thing> getThings(){
        return this.THINGS;
    }


    /**
     * Méthode pour récupérer les sorties de la salle
     * @return les sorties de type Map
     */
    public Map<String,Exit> getExits(){
        return this.EXITS;
    }


    /**
     * Méthode pour récupérer les sorties ouvertes de la salle
     * @return les sorties ouvertes de type Map
     */
    public Map<String,Exit> getOpenExits(){
        Map<String,Exit> me = new LinkedHashMap<>();
        for(Map.Entry<String, Exit> entry : this.EXITS.entrySet()){
            if (entry.getValue().isOpen()){
                me.put(entry.getKey(), entry.getValue());
            }
        }  
        return me;
    }


    /**
     * Méthode pour récupérer les Items (donc sans les créatures)
     * de la salle
     * @return les items sous forme de Map
     */
    public Map<String,Item> getItems(){
        Map<String,Item> mi = new LinkedHashMap<>();
        for(Map.Entry<String, Thing> entry : this.THINGS.entrySet()){
            if( entry.getValue() instanceof Item ){ 
                mi.put(entry.getKey(), (Item)entry.getValue());
            }
        }  
        return mi;
    }


    /**
     * Méthode pour récupérer les créatures de la salle
     * @return les créatures sous forme de Map
     */
    public Map<String,Creature> getCreatures(){
        Map<String,Creature> mc = new LinkedHashMap<>();
        for(Map.Entry<String, Thing> entry : this.THINGS.entrySet()){
            if( entry.getValue() instanceof Creature ){ 
                mc.put(entry.getKey(), (Creature)entry.getValue());
            }
        }  
        return mc;
    }


    /**
     * Méthode toString plus longue, on l'a nommé ainsi par convention
     * mais elle n'est pas lié au toString
     * @return un message de type String
     */
    public String toStringComplete()
    {
        String desc = "the " 
                + this.getName() 
                + "!\n\nThere, you can see "
                + this.getExits().size() 
                + " exit(s) :\n";

        for (String key : this.EXITS.keySet())
        {
            desc = desc.concat("- " 
                    + this.EXITS.get(key).toString()
                    + "\n");
        }
        
        if (!this.THINGS.isEmpty())
        {  
            desc = desc.concat("\nAnd also " 
                    + this.THINGS.size() 
                    + " entities :\n");

            for (String key : this.THINGS.keySet())
            {
                desc = desc.concat("- " 
                        + this.THINGS.get(key).toString()
                        + "\n");
            }
        }
        return desc;
    }


    /**
     * On redéfinit la méthode toString pour chaque porte
     * @return le message type String
     */
    @Override
    public String toString(){
        return "the " + this.getName() +"!";
    }
}
