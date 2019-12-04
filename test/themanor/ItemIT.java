package themanor;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import themanor.place.Hall;
import themanor.place.Place;
import themanor.thing.creature.Bat;
import themanor.thing.creature.Creature;
import themanor.thing.item.Broom;
import themanor.thing.item.Item;
import themanor.thing.item.Torch;

public class ItemIT {
    
    private Item i;
    
    private Creature c;
    
    private World w;
    
    private Place p;
    
    private int initial_hp_creature;
    private int initial_hp_player;
    
    
    @Before
    public void setUp() {
        w = new World();
        p = new Hall("hall");
        c = new Bat("bat", new Torch("torch"));        
        i = new Broom("broom");
        
        w.getJoueur().setActualPlace(p);
        p.addThing(c);
        
        initial_hp_creature = c.getHp();
        initial_hp_player = w.getJoueur().getHp();
    }
    
    
    @Test
    public void useTest1(){
        i.use(w, c);
        assertSame(initial_hp_creature - 10, c.getHp());
        // LE BROOM INFLIGE 10 DEGATS
    }
    @Test
    public void useTest2(){
        i.use(w, c);
        assertSame(initial_hp_player - 3, w.getJoueur().getHp()); 
        // LA BAT INFLIGE 3 DEGATS
    }
    @Test
    public void useTest3(){
        i.use(w, c);
        assertTrue(w.getJoueur().isInFight());
    }
    @Test
    public void useTest4(){
        i.use(w, c);
        i.use(w, c);
        assertSame(initial_hp_player - 3, w.getJoueur().getHp()); 
        // LA BAT N'ATTAQUE QU'UNE FOIS LE PLAYER
    }
    @Test
    public void useTest5(){
        i.use(w, c);
        i.use(w, c);
        assertFalse(w.getJoueur().isInFight()); 
    }
    @Test
    public void useTest6(){
        i.use(w, c);
        i.use(w, c);
        assertNull(w.getJoueur().getActualPlace().getThings().get(c.getName()));
    }
    @Test
    public void useTest7(){
        i.use(w, c);
        i.use(w, c);
        assertNotNull(w.getJoueur().getActualPlace().getItems().
                get(c.getItemHide().getName()));
    }
    @Test
    public void useTest8(){
        //i.use(w, c);
    }
}