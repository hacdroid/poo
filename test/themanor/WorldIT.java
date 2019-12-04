package themanor;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class WorldIT {
    
    private World w;
    
    
    @Before
    public void setUp() {
        w = new World();
    }
    
    
    @Test
    public void initGameTest(){
        assertSame(w.getLISTEPLACES().get("hall"), w.getJoueur().getActualPlace());
    }
    
    
    @Test
    public void getLISTEPLACESTest1(){
        assertFalse(w.getLISTEPLACES().isEmpty());
    }
    @Test
    public void getLISTEPLACESTest2(){
        assertTrue(w.getLISTEPLACES().containsKey("office"));
    }
    @Test
    public void getLISTEPLACESTest3(){
        assertFalse(w.getLISTEPLACES().containsKey(null));
    }
    @Test
    public void getLISTEPLACESTest4(){
        assertFalse(w.getLISTEPLACES().containsKey("street"));
    }
    
    
    @Test
    public void getJoueurTest(){
        assertNotNull(w.getJoueur());
    }
}