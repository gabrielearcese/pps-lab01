package example;

import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;

public class Main {

    public static void main(String[] args) {
        int InitialBalance=0;
        int AmountDeposit=100;
        int AmountWithdraw30 =30;
        int AmountWithdraw80 =80;
        final AccountHolder accountHolder = new AccountHolder("Mario", "Rossi", 1);
        final BankAccount bankAccount = new SimpleBankAccount(accountHolder, InitialBalance);
        bankAccount.deposit(accountHolder.getId(), AmountDeposit);
        System.out.println("Current balance is " + bankAccount.getBalance());
        bankAccount.withdraw(accountHolder.getId(), AmountWithdraw30);
        System.out.println("Current balance is " + bankAccount.getBalance());
        bankAccount.withdraw(accountHolder.getId(), AmountWithdraw80);
        System.out.println("Current balance is " + bankAccount.getBalance());
    }
}
