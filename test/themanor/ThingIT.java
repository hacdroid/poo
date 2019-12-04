package themanor;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import themanor.thing.Thing;
import themanor.thing.creature.Bat;
import themanor.thing.item.Broom;
import themanor.thing.item.Item;
import themanor.thing.item.Torch;

public class ThingIT {
    
    private Thing t1;
    private Thing t2;
    
    private Item i1;
    private Item i2;
    
    
    @Before
    public void setUp(){
        i1 = new Broom("broom");
        
        t1 = new Bat("bat", i1);
        t2 = new Torch(null);
    }
    
    
    @Test
    public void getNameTest1(){
        assertSame("bat", t1.getName());
    }
    @Test
    public void getNameTest2(){
        assertNotNull(t2.getName());
    }
    
    
    @Test
    public void getItemHideTest1(){
        assertSame(i1, t1.getItemHide());
    }
    @Test
    public void getItemHideTest2(){
        assertNull(t2.getItemHide());
    }
    
    
    @Test
    public void removeItemHideTest1(){
        t1.removeItemHide();
        assertNull(t1.getItemHide());
    }
    @Test
    public void removeItemHideTest2(){
        t2.removeItemHide();
        assertNull(t2.getItemHide());
    }
}
