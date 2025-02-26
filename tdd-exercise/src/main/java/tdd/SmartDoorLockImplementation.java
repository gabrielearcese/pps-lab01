package tdd;

import static java.sql.Types.NULL;

public class SmartDoorLockImplementation implements SmartDoorLock {

    public static final int MAXNUMBEROFTRY = 5;
    private boolean isLocked;
    private int pin;
    private int numberOfIncorrectPinInserted;
    private boolean isBlocked;

    public SmartDoorLockImplementation(boolean isLocked, int pin) {
        this.isLocked = isLocked;
        this.pin=pin;
    }

    @Override
    public void setPin(int pin) {
        if(!isLocked){
            if (String.valueOf(pin).length() == 4) {
                this.pin=pin;
                System.out.println("Pin changed");
            } else {
                System.out.println("Pin is to long.");
            }
        }
    }

    @Override
    public void unlock(int pin) {
        while(getFailedAttempts() <= MAXNUMBEROFTRY) {
            for (int i = 0; i < MAXNUMBEROFTRY; i++) {
                if (this.pin != pin) {
                    numberOfIncorrectPinInserted++;
                    setPin(pin);
                }else {
                    isLocked = false;
                    return;
                }
            }
        }
        isBlocked=true;
        isLocked=false;
    }

    @Override
    public void lock() throws Exception {
        this.isLocked=true;
        if(this.pin==NULL){
            throw new Exception("Pin is not setted");
        }
    }

    @Override
    public boolean isLocked() {
        return this.isLocked;
    }

    @Override
    public boolean isBlocked() {
        return this.isBlocked;
    }

    @Override
    public int getMaxAttempts() {
        return MAXNUMBEROFTRY;
    }

    @Override
    public int getFailedAttempts() {
        return numberOfIncorrectPinInserted;
    }

    @Override
    public void reset() {
        numberOfIncorrectPinInserted=0;
        isLocked=false;
        isBlocked=false;
        setPin(pin);
    }
}
