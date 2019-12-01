package themanor;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import themanor.exit.Door;
import themanor.exit.Exit;
import themanor.exit.LockedDoor;
import themanor.place.Hall;
import themanor.place.Office;
import themanor.place.Place;

public class ExitIT {

    private Place p1;
    private Place p2;
    
    private Exit e1;
    private Exit e2;
    
    
    @Before
    public void setUp(){
        p1 = new Hall("hall");
        p2 = new Office("office");
        
        e1 = new Door(p1);              // OUVERTE PAR DEFAUT
        e2 = new LockedDoor(p2, 1234);  // FERMEE PAR DEFAUT
    }
    
    
    @Test
    public void isOpenTest1(){
        assertTrue(e1.isOpen());
    }
    @Test
    public void isOpenTest2(){
        assertFalse(e2.isOpen());
    }
    
    
    @Test
    public void getPlace(){
        assertSame(p1, e1.getPlace());
    }
}
