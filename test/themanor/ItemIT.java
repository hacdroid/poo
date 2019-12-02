package themanor;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import themanor.thing.creature.Bat;
import themanor.thing.creature.Creature;
import themanor.thing.item.Broom;
import themanor.thing.item.Item;

public class ItemIT {
    
    private Item i;
    
    private Creature c;
    
    private World w;
    
    private int initial_hp_creature;
    private int initial_hp_player;
    
    
    @Before
    public void setUp() {
        w = new World();
        c = new Bat("bat");        
        i = new Broom("broom");
        
        initial_hp_creature = c.getHp();
        initial_hp_player = w.getJoueur().getHp();
    }
    
    
    @Test
    public void useTest1(){
        i.use(w, c);
        assertSame(initial_hp_creature - 10, c.getHp()); // LE BROOM INFLIGE 10
                                                         // DEGATS
    }
    @Test
    public void useTest2(){
        i.use(w, c);
        
    }
    @Test
    public void useTest3(){
        i.use(w, c);
        
    }
    @Test
    public void useTest4(){
        i.use(w, c);
        
    }
}