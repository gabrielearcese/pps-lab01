import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest {

    public static final int BALANCE = 0;
    public static final int EXPECTEDBALANCE = 0;
    public static final int AMOUNTDEPOSITWRONG = 50;
    public static final int EXPECTEDWITHDRAWWITHFEE = 29;
    public static final int AMOUNTWITHDRAW = 70;
    public static final int AMOUNTDEPOSIT = 100;
    private AccountHolder accountHolder;
    private BankAccount bankAccount;
    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccount(accountHolder, BALANCE);
    }

    @Test
    void testInitialBalance() {
        assertEquals(EXPECTEDBALANCE, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(accountHolder.getId(), AMOUNTDEPOSIT);
        assertEquals(AMOUNTDEPOSIT, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        bankAccount.deposit(accountHolder.getId(), AMOUNTDEPOSIT);
        bankAccount.deposit(2, AMOUNTDEPOSITWRONG);
        assertEquals(AMOUNTDEPOSIT, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        bankAccount.deposit(accountHolder.getId(), AMOUNTDEPOSIT);
        bankAccount.withdraw(accountHolder.getId(), AMOUNTWITHDRAW);
        assertEquals(EXPECTEDWITHDRAWWITHFEE, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        bankAccount.deposit(accountHolder.getId(), AMOUNTDEPOSIT);
        bankAccount.withdraw(2, AMOUNTWITHDRAW);
        assertEquals(AMOUNTDEPOSIT, bankAccount.getBalance());
    }


}
