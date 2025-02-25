package tdd;

public class SmartDoorLockImplementation implements SmartDoorLock {

    public static final int MAXNUMBEROFTRY = 5;
    private boolean isOpen;
    private int pin;
    private int numberOfIncorrectPinInserted;
    private boolean isBlocked;

    public SmartDoorLockImplementation(boolean isOpen, int pin) {
        this.isOpen = isOpen;
        this.pin=pin;
    }

    @Override
    public void setPin(int pin) {
        if(isOpen){
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
        while(numberOfIncorrectPinInserted<= MAXNUMBEROFTRY) {
            for (int i = 0; i < numberOfIncorrectPinInserted; i++) {
                if (this.pin != pin) {
                    numberOfIncorrectPinInserted++;
                    setPin(pin);
                } else {
                    isOpen = true;
                    break;
                }
            }
        }
        isBlocked=true;
        isOpen=false;
    }

    @Override
    public void lock() {

    }

    @Override
    public boolean isLocked() {
        return false;
    }

    @Override
    public boolean isBlocked() {
        return false;
    }

    @Override
    public int getMaxAttempts() {
        return 0;
    }

    @Override
    public int getFailedAttempts() {
        return 0;
    }

    @Override
    public void reset() {

    }
}
