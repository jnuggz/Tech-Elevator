package com.techelevator;

public class BankAccount implements Accountable{

    private String accountHolderName;
    private String accountNumber;
    private int balance;

    //Constructors
    public BankAccount(String accountHolder, String accountNumber) {
        this.accountHolderName = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public BankAccount(String accountHolder, String accountNumber, int balance) {
        this.accountHolderName = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    //Method
    //Allow BankAccount to transfer money to another BankAccount
    public int transferTo(BankAccount destinationAccount, int transferAmount) {
        //withdraw transfer amount from this account
        withdraw(transferAmount);
        //deposit transfer amount to destination account
        destinationAccount.deposit(transferAmount);
        //return the remaining balance
        return balance;
    }

    //Getter
    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public int deposit(int amountToDeposit) {
        balance = balance + amountToDeposit;
        return balance;
    }

    public int withdraw(int amountToWithdraw) {
        balance = balance - amountToWithdraw;
        return balance;
    }

}
