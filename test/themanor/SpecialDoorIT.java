package themanor;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import themanor.exit.SpecialDoor;
import themanor.place.Hall;
import themanor.place.Office;
import themanor.place.Place;

public class SpecialDoorIT {
 
    private Place p1;
    private Place p2;
    
    private SpecialDoor d1;
    private SpecialDoor d2;
    
    
    @Before
    public void setUp(){
        p1 = new Hall("hall");
        p2 = new Office("office");
        
        d1 = new SpecialDoor(p1);
        d2 = new SpecialDoor(p2);
    }
    
    @Test
    public void openTest(){
        d1.open();
        assertTrue(d1.isOpen());
    }
}