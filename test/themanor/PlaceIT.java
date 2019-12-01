package themanor;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import themanor.exit.Door;
import themanor.exit.LockedDoor;
import themanor.place.Place;
import themanor.place.Hall;
import themanor.place.Office;
import themanor.thing.Thing;
import themanor.thing.creature.Bat;
import themanor.thing.item.NPC;
import themanor.thing.item.Bread;

public class PlaceIT {
    
    private Place p1;
    private Place p2;
    
    private Door d1;
    private Door d2;
    private LockedDoor d3;
    
    private Thing t1;
    private Thing t2;
    private Thing t3;

    
    @Before
    public void setUp() {
        p1 = new Hall("hall");
        p2 = new Office(null);
        
        d1 = new Door(p1);
        d2 = new Door(p2);
        d3 = new LockedDoor(p2, 1234);
        
        t1 = new Bat("bat");
        t2 = new Bread("bread");
        t3 = new NPC(null);
    }

    
    @Test
    public void getNameTest1(){
        assertNotNull(p1.getName());
    }    
    @Test
    public void getNameTest2(){
        assertNotNull(p2.getName());
    }
    
    
    @Test
    public void addThing_getThingsTest1(){
        p1.addThing(t1);
        assertTrue(p1.getThings().containsKey(t1.getName()));
    }
    @Test
    public void addThing_getThingsTest2(){
        p1.addThing(t2);
        assertTrue(p1.getThings().containsKey(t2.getName()));
    }
    @Test
    public void addThing_getThingsTest3(){
        p1.addThing(t3);
        assertTrue(p1.getThings().containsKey((t3.getName())));
    }
    
    
    @Test
    public void addThing_getCreaturesTest1(){
        p1.addThing(t1);
        assertTrue(p1.getCreatures().containsKey(t1.getName()));
    }
    @Test
    public void addThing_getCreaturesTest2(){
        p1.addThing(t2);
        assertFalse(p1.getCreatures().containsKey(t2.getName()));
    }
    @Test
    public void addThing_getCreaturesTest3(){
        p1.addThing(t3);
        assertFalse(p1.getCreatures().containsKey((t3.getName())));
    }
    
    
    @Test
    public void addThing_getItemsTest1(){
        p1.addThing(t1);
        assertFalse(p1.getItems().containsKey(t1.getName()));
    }
    @Test
    public void addThing_getItemsTest2(){
        p1.addThing(t2);
        assertTrue(p1.getItems().containsKey(t2.getName()));
    }
    @Test
    public void addThing_getItemsTest3(){
        p1.addThing(t3);
        assertTrue(p1.getItems().containsKey((t3.getName())));
    }
    
    
    @Test
    public void addExitTest1(){
        p2.addExit(p1.getName(), d1);
        assertTrue(p2.getExits().containsKey(p1.getName()));
    }
    @Test
    public void addExitTest2(){
        p1.addExit(p2.getName(), d2);
        assertTrue(p1.getExits().containsKey(p2.getName()));
    }
    
    
    @Test
    public void getThingsTest(){
        assertTrue(p1.getThings().isEmpty());
    }
    
    
    @Test
    public void getCreaturesTest(){
        assertTrue(p1.getCreatures().isEmpty());
    }
    
    
    @Test
    public void getItemsTest(){
        assertTrue(p1.getItems().isEmpty());
    }
    
    
    @Test
    public void getExitsTest1(){
        assertTrue(p1.getExits().isEmpty());
    }
    @Test
    public void getExitsTest2(){
        p1.addExit(p2.getName(), d2);
        assertFalse(p1.getExits().isEmpty());
    }
    
    
    @Test
    public void getOpenExitsTest1(){
        assertTrue(p1.getOpenExits().isEmpty());
    }
    @Test
    public void getOpenExitsTest2(){
        p1.addExit(p2.getName(), d2);
        assertFalse(p1.getOpenExits().isEmpty());
    }
    @Test
    public void getOpenExitsTest3(){
        p1.addExit(p2.getName(), d3);
        assertTrue(p1.getOpenExits().isEmpty());
    }
}