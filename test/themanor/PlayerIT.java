package themanor;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import themanor.place.Hall;
import themanor.thing.creature.Bat;
import themanor.thing.creature.Creature;

public class PlayerIT {
    
    private Player p;
    
    private World w;
    
    private Hall h;
    
    private Creature c;
    
    private int initial_hp_player;
    private int initial_hp_creature;
    
    
    @Before
    public void setUp() {
        p = new Player("player", w);
        c = new Bat("bat");
        h = new Hall("hall");
        
        initial_hp_player = p.getHp();
        initial_hp_creature = c.getHp();
    }
    
    
    @Test
    public void getIsOutTest1(){
        assertFalse(p.getIsOut());
    }
    @Test
    public void getIsOutTest2(){
        p.attacked(40);
        assertTrue(p.getIsOut());
    }
    
    
    @Test
    public void attacked_getHpTest1(){
        p.attacked(10);
        assertSame(initial_hp_player - 10, p.getHp());
    }
    @Test
    public void attacked_getHpTest2(){
        p.attacked(-10);
        assertSame(initial_hp_player, p.getHp());
    }
    
    
    @Test
    public void attackTest1(){
        p.attack(c, 5);
        assertSame(initial_hp_creature - 5, c.getHp());
    }
    @Test
    public void attackTest2(){
        p.attack(c, -5);
        assertSame(initial_hp_creature, c.getHp());
    }
    
    
    @Test
    public void setActual_getActualPlacePlaceTest(){
        p.setActualPlace(h);
        assertSame(h, p.getActualPlace());
    }
    
    
    @Test
    public void getNameTest(){
        assertSame("player", p.getName());
    }
    
    
    @Test
    public void addHpTest1(){
        p.addHp(10);
        assertSame(initial_hp_player + 10, p.getHp());
    }
    @Test
    public void addHpTest2(){
        p.addHp(-10);
        assertSame(initial_hp_player, p.getHp());
    }
    
    
    @Test
    public void getInventoryTest1(){
        assertTrue(p.getInventory().isEmpty());
    }
    
    
    @Test
    public void setFight_isInFightTest(){
        p.setFight(true);
        assertTrue(p.isInFight());
    }
    
    
    @Test
    public void isInFightTest(){
        assertFalse(p.isInFight());
    }
}
