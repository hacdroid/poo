package themanor;

public abstract class Exit {

	private Place place;
        private boolean isOpen;
        
        
        public Exit(Place place){
            this.place = place;
            this.isOpen = false;
        }
        
        
        public void open(){
            this.isOpen = true;
        }
        
        public boolean isOpen(){
            return this.isOpen;
        }
        
        public Place getPlace (){
            return this.place;
        }

	public abstract String toString();
}