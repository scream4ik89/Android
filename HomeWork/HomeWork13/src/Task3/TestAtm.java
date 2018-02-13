package Task3;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestAtm extends Assert {
    Main main = new Main();
    Atm atm;
    @Before
    public void before(){
        atm = new Atm();
    }
    @After
    public void after(){
        atm = null;
    }
    @Test
    public void testAddMoney() {
    atm.addMoney(200);

    assertTrue(atm.getCount_20() == 0);
    assertTrue(atm.getCount_50() == 0);
    assertTrue(atm.getCount_100() == 2);

        atm.addMoney(280);
        assertTrue(atm.getCount_20() == 4);
        assertTrue(atm.getCount_50() == 0);
        assertTrue(atm.getCount_100() == 2);

        atm.addMoney(70);
        assertTrue(atm.getCount_20() == 1);
        assertTrue(atm.getCount_50() == 1);
        assertTrue(atm.getCount_100() == 0);


}



}
