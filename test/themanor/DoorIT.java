package themanor;

import themanor.exit.Door;
import themanor.place.Place;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DoorIT {
    
    private Place p1;
    private Place p2;
    private Place p3;
    private Door d1;
    private Door d2;
    private Door d3;
    
    @Before
    public void setUp() {
        /* A METTRE DANS LE TEST DE PLACE
        p1 = new Hall("hall");
        p2 = new Office(null);
        
        d1 = new Door(p1);
        d2 = new Door(p2);
        d3 = new Door(p3);
        
        p1.addExit(null, d1);
        p1.addExit(p3.getName(), d3);
        p2.addExit("hall", d2);
        p3.addExit("hall", d1);
        */
    }
    
    @Test
    public void toStringTest(){
        System.out.println(d1.toString());
        
        assertNotNull(d1.getPlace().getName());
        assertNotNull(d2.getPlace().getName()); // NE MARCHE PAS
        /*
        RAJOUTER DANS LE CONSTRUCTEUR PLACE 
            if (name == null)
            {
                this.NAME = "unnamed";
            }
            else this.NAME = name
        */        
    }
}
