package themanor.place;

import themanor.thing.item.Item;
import themanor.thing.creature.Creature;
import themanor.thing.Thing;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import themanor.exit.Exit;

public abstract class Place {

	//private List<Thing> listThing;
        private Map<String,Thing> things;
        private final String NAME;
        private final Map<String,Exit> EXITS;



	public Place(String name) {
            //this.listThing = new ArrayList<>();
            this.NAME=name;
            this.EXITS = new LinkedHashMap<>();
            this.things = new Hashtable<>();
	}
        
        public String getName(){
            return this.NAME;
        }


	public void addThing(String name, Thing item) {
            //this.listThing.add(item);
            this.things.put(name, item);
	}
        
        public void addExit(String name, Exit sortie){
            this.EXITS.put(name,sortie);
        }
        
        public Map<String,Thing> getThings(){
            return this.things;
        }
        
        public Map<String,Exit> getExits(){
            return this.EXITS;
        }
        
        public Map<String,Exit> getOpenExits(){
            Map<String,Exit> me = new LinkedHashMap<>();
            for(Map.Entry<String, Exit> entry : this.EXITS.entrySet()){
                if (entry.getValue().isOpen()){
                    me.put(entry.getKey(), entry.getValue());
                }
            }  
            return me;
        }

        public Map<String,Item> getItems(){
            Map<String,Item> mi = new LinkedHashMap<>();
            for(Map.Entry<String, Thing> entry : this.things.entrySet()){
                if( entry.getValue() instanceof Item ){ 
                    mi.put(entry.getKey(), (Item)entry.getValue());
                }
            }  
            return mi;
        }
        
        public Map<String,Creature> getCreatures(){
            Map<String,Creature> mc = new LinkedHashMap<>();
            for(Map.Entry<String, Thing> entry : this.things.entrySet()){
                if( entry.getValue() instanceof Creature ){ 
                    mc.put(entry.getKey(), (Creature)entry.getValue());
                }
            }  
            return mc;
        }
        
        
        
        @Override
        public String toString(){
            return "the " + this.getName() +"!";
        }


        
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
            if (!this.things.isEmpty())
            {  
                desc = desc.concat("\nAnd also " 
                        + this.things.size() 
                        + " entities :\n");
                
                for (String key : this.things.keySet())
                {
                    desc = desc.concat("- " 
                            + this.things.get(key).toString()
                            + "\n");
                }
            }
            return desc;
        }
}
