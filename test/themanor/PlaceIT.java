package themanor;

import java.util.LinkedHashMap;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import themanor.exit.Door;
import themanor.place.Place;
import themanor.place.Hall;
import themanor.place.Office;
import themanor.thing.Thing;
import themanor.thing.creature.Bat;
import themanor.thing.creature.NPC;
import themanor.thing.item.Bread;

public class PlaceIT {
    
    private Place p1;
    private Place p2;
    
    private Door d1;
    private Door d2;
    
    private Thing t1;
    private Thing t2;
    private Thing t3;
    
    @Before
    public void setUp() {
        p1 = new Hall("hall");
        p2 = new Office(null);
        
        d1 = new Door(p1);
        d2 = new Door(p2);
        
        t1 = new Bat();
        t2 = new Bread();
        t3 = new NPC();
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
    public void addThingTest1(){
        p1.addThing("bat", t1);
        assertTrue(p1.getThings().containsKey("bat"));
    }    
    @Test
    public void addThingTest2(){
        p1.addThing("bat", t1);
        assertTrue(p1.getCreatures().containsKey("bat"));
    }    
    @Test
    public void addThingTest3(){
        p1.addThing("bat", t1);
        assertFalse(p1.getItems().containsKey("bat"));
    }    
    @Test
    public void addThingTest4(){
        p1.addThing("bread", t2);
        assertTrue(p1.getThings().containsKey("bread"));
    }    
    @Test
    public void addThingTest5(){
        p1.addThing("bread", t2);
        assertFalse(p1.getCreatures().containsKey("bread"));
    }    
    @Test
    public void addThingTest6(){
        p1.addThing("bread", t2);
        assertTrue(p1.getItems().containsKey("bread"));
    }
    @Test
    public void addThingTest7(){
        p1.addThing(null, t3);
        assertNotNull(p1.getThings());
    }    
    @Test
    public void addThingTest8(){
        p1.addThing(null, t3);
        assertNotNull(p1.getCreatures());
    }    
    @Test
    public void addThingTest9(){
        p1.addThing(null, t3);
        assertTrue(p1.getItems().isEmpty());
    }    
    /*
    Dans addThing :
        if (name = null)
            name = "CE QUE TU VEUX" OU name = (string)item
        this.things.put(name, item);
    */
    
    
    @Test
    public void addExitTest1(){
        p2.addExit(p1.getName(), d1);
        assertTrue(p2.getExits().containsKey(p1.getName()));
    }
    @Test
    public void addExitTest2(){
        p1.addExit(null, d2);
        assertTrue(p1.getExits().containsKey(null));
    }
    
    
    @Test
    public void getThingsTest1(){
        p1.addThing("bat", t1);
        assertTrue(p1.getThings().containsKey("bat"));
    }
}
