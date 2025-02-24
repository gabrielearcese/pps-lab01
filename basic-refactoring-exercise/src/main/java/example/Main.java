package example;

import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;

public class Main {


    public static final int BALANCE = 0;
    public static final int AMOUNTDEPOSIT = 100;
    public static final int AMOUNTWITHDRAW30 = 30;
    public static final int AMOUNTWITHDRAW80 = 80;

    public static void main(String[] args) {

        final AccountHolder accountHolder = new AccountHolder("Mario", "Rossi", 1);
        final BankAccount bankAccount = new SimpleBankAccount(accountHolder, BALANCE);
        bankAccount.deposit(accountHolder.getId(), AMOUNTDEPOSIT);
        System.out.println("Current balance is " + bankAccount.getBalance());
        bankAccount.withdraw(accountHolder.getId(), AMOUNTWITHDRAW30);
        System.out.println("Current balance is " + bankAccount.getBalance());
        bankAccount.withdraw(accountHolder.getId(), AMOUNTWITHDRAW80);
        System.out.println("Current balance is " + bankAccount.getBalance());
    }
}
