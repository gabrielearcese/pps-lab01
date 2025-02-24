import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest {

    private AccountHolder accountHolder;
    private BankAccount bankAccount;
    private int Balance=0;
    private int ExpectedBalance=0;
    private int AmountDeposit=100;
    private int AmountWithdraw=70;
    private int AmountDepositWrong=50;
    private int ExpectedWithdrawWithFee=29;
    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccount(accountHolder, Balance);
    }

    @Test
    void testInitialBalance() {
        assertEquals(ExpectedBalance, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(accountHolder.getId(), AmountDeposit);
        assertEquals(AmountDeposit, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        bankAccount.deposit(accountHolder.getId(), AmountDeposit);
        bankAccount.deposit(2, AmountDepositWrong);
        assertEquals(AmountDeposit, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        bankAccount.deposit(accountHolder.getId(), AmountDeposit);
        bankAccount.withdraw(accountHolder.getId(), AmountWithdraw);
        assertEquals(ExpectedWithdrawWithFee, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        bankAccount.deposit(accountHolder.getId(), AmountDeposit);
        bankAccount.withdraw(2, AmountWithdraw);
        assertEquals(AmountDeposit, bankAccount.getBalance());
    }


}
