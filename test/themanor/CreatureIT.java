package themanor;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import themanor.thing.creature.Bat;
import themanor.thing.creature.Creature;
import themanor.thing.creature.Scarecrow;

public class CreatureIT {
    
    private Creature c1;
    private Creature c2;
    
    private World w;
    
    private Player p;
    
    private int initial_hp_creature;
    private int initial_hp_player;
    
    
    @Before
    public void setUp() {
        c1 = new Bat("bat");
        c2 = new Scarecrow("scarecrow");
        
        p = new Player("player", w);
        
        initial_hp_creature = c1.getHp();
        initial_hp_player = p.getHp();
    }
    
    
    @Test
    public void getIsOutTest1(){
        assertFalse(c1.getIsOut());
    }
    @Test
    public void getIsOutTest2(){
        c1.attacked(20);
        assertTrue(c1.getIsOut());
    }
    
    
    @Test
    public void getHpTest1(){
        assertSame(11, c1.getHp()); // LA BAT A 11 POINTS DE VIE
    }
    @Test
    public void getHpTest2(){
        assertSame(30, c2.getHp()); // LE SCARECROW A 30 POINTS DE VIE
    }
    @Test
    public void getHpTest3(){
        c1.attacked(20);
        assertSame(0, c1.getHp());
    }
    
    
    @Test
    public void attackedTest1(){
        c1.attacked(5);
        assertSame(initial_hp_creature - 5, c1.getHp());
    }
    @Test
    public void attackedTest2(){
        c1.attacked(-5);
        assertSame(initial_hp_creature, c1.getHp());
    }
    
    
    @Test
    public void attackTest1(){
        c1.attack(p);
        assertSame(initial_hp_player - 4, p.getHp()); // LA BAT INFLIGE 4 DEGATS
    }
    @Test
    public void attackTest2(){
        c2.attack(p);
        assertSame(initial_hp_player - 7, p.getHp()); // LE SCARECROW INFLIGE
                                                      // 7 DEGATS
    }
}
