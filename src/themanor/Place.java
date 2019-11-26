package themanor;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class Place {

	private List<Thing> listThing;
        private final String NAME;
        private final Map<String,Exit> EXITS;

	public abstract String toString();

	public Place(String name) {
            this.listThing = new ArrayList<>();
            this.NAME=name;
            this.EXITS = new LinkedHashMap<>();
	}
        
        public String getName(){
            return this.NAME;
        }


	public void addThing(Thing item) {
            this.listThing.add(item);
	}
        
        public void addExit(String name, Exit sortie){
            this.EXITS.put(name,sortie);
        }
        
        public List<Thing> getThings(){
            return this.listThing;
        }
        
        public Map<String,Exit> getExits(){
            return this.EXITS;
        }

	/**
	 * 
	 * @param item
	 */
	public void rmvThing(Thing item) {
		// TODO - implement Place.rmvThing
	throw new UnsupportedOperationException();
	}

}