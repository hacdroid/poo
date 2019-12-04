package themanor;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({themanor.CreatureIT.class, themanor.ExitIT.class, 
    themanor.ItemIT.class, themanor.LockedDoorIT.class, themanor.PlaceIT.class, 
    themanor.PlayerIT.class, themanor.SpecialDoorIT.class, 
    themanor.ThingIT.class, themanor.WorldIT.class})
public class themanorAllTests {

}