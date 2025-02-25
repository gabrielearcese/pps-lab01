package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.*;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    public static final boolean CONDITIONTRUE = true;
    public static final boolean CONDITIONFALSE = false;
    public static final int WRONGPIN = 55555;
    public static final int RIGHTPIN = 1234;
    private SmartDoorLockImplementation smartDoor;

    @BeforeEach
    void beforeEach(){
        smartDoor = new SmartDoorLockImplementation(CONDITIONFALSE,WRONGPIN);
    }

    @Test
    public void todo() {
        assertTrue(true);
    }

    @Test
    public void testSetPin(){
        assertTrue(CONDITIONTRUE);
        assertTrue(String.valueOf(RIGHTPIN).length() == 4);
        smartDoor.setPin(RIGHTPIN);
    }

    @Test
    public void testUnlock(){

    }
}
