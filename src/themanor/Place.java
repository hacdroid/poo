package themanor;

import java.util.ArrayList;
import java.util.List;

public abstract class Place {

	private List<Thing> listThing;
	private List<Exit> listExit;
        private final String NAME;

	public abstract String toString();

	public Place(String name) {
            this.listExit = new ArrayList<>();
            this.listThing = new ArrayList<>();
            this.NAME=name;
	}
        
        public String getName(){
            return this.NAME;
        }

	/**
	 * 
	 * @param item
	 */
	public void addThing(Thing item) {
            this.listThing.add(item);
	}
        
        public void addExit(Exit sortie){
            this.listExit.add(sortie);
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