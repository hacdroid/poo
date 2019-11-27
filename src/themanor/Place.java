package themanor;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

        
        @Override
        public String toString(){
            return "a " + this.getName() +"!";
        }

}