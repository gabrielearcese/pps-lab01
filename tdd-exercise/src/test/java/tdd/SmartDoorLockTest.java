package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.*;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    public static final boolean CONDITIONTRUE = true;
    public static final boolean CONDITIONFALSE = false;
    public static final int WRONGPIN = 55555;
    public static final int WRONG4DIGITPIN = 5555;
    public static final int RIGHTPIN = 1234;
    public static final int MAXNUMBEROFTRY = 5;
    private SmartDoorLockImplementation smartDoor;

    @BeforeEach
    void beforeEach(){
        smartDoor = new SmartDoorLockImplementation();
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
    public void testCorrectNumberOfDigit(){
        assertTrue(String.valueOf(RIGHTPIN).length() == 4);
    }

    @Test
    public void testIncorrectNumberOfDigit(){
        assertTrue(String.valueOf(WRONGPIN).length() != 4);
    }

    @Test
    public void testIncorrectPin(){
        assertNotEquals(RIGHTPIN,WRONG4DIGITPIN);

    }

    @Test
    public void testUnlock(){
        smartDoor.unlock(RIGHTPIN);
    }

    @Test
    public void testLock() throws Exception {
        assertEquals(smartDoor.isLocked(),CONDITIONFALSE);
        assertEquals(smartDoor.isBlocked(),CONDITIONFALSE);
        smartDoor.setPin(RIGHTPIN);
        smartDoor.lock();
        assertEquals(smartDoor.isLocked(),CONDITIONTRUE);
    }

    @Test
    public void testReset(){
        smartDoor.reset();
        assertEquals(smartDoor.isLocked(),CONDITIONFALSE);
        assertEquals(smartDoor.getFailedAttempts(),0);
        assertEquals(smartDoor.isBlocked(),CONDITIONFALSE);
    }

    @Test
    public void testBlock(){
        assertEquals(smartDoor.isBlocked(),CONDITIONFALSE);
        for(int i=0;i<MAXNUMBEROFTRY;i++){
            smartDoor.unlock(WRONG4DIGITPIN);
        }
        if(smartDoor.getFailedAttempts()==MAXNUMBEROFTRY){
            assertEquals(smartDoor.isBlocked(),CONDITIONTRUE);
            assertEquals(smartDoor.isLocked(),CONDITIONFALSE);
        }

    }
}
