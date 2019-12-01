package themanor;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import themanor.exit.LockedDoor;
import themanor.place.Hall;
import themanor.place.Office;
import themanor.place.Place;

public class LockedDoorIT {
    
    private Place p1;
    private Place p2;
    
    private LockedDoor d1;
    private LockedDoor d2;
    
    private int code;   // CODE NON INITIALISE POUR LES TESTS
    
    
    @Before
    public void setUp() {
        p1 = new Hall("hall");
        p2 = new Office("office");
        
        d1 = new LockedDoor(p1, 1234);
        d2 = new LockedDoor(p1, code);
    }
    
    
    @Test
    public void openTest(){
        d1.open();
        assertFalse(d1.isOpen());
    }
    
    
    @Test
    public void openCodeTest1(){
        assertTrue(d1.open(1234));
    }
    @Test
    public void openCodeTest2(){
        assertFalse(d1.open(4846));
    }
    @Test
    public void openCodeTest3(){
        assertFalse(d1.open(code));
    }
    @Test
    public void openCodeTest4(){
        assertFalse(d2.open(47861));
    }
    @Test
    public void openCodeTest5(){
        assertTrue(d2.open(code));
    }
}
