package themanor;

public abstract class Exit {

	private Place voisin;
        private boolean isOpen;
        
        
        public Exit(Place voisin){
            this.voisin = voisin;
            this.isOpen = false;
        }
        
        
        public void open(){
            this.isOpen = true;
        }
        
        public boolean isOpen(){
            return this.isOpen;
        }
        
        public Place getVoisin (){
            return this.voisin;
        }

	public abstract String toString();
}