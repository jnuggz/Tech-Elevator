package com.techelevator;

public class BankAccount {

    private String accountHolderName;
    private String accountNumber;
    private int balance;

    //Constructors
    public BankAccount(String accountHolderName, String accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
    }

    public BankAccount(String accountHolderName, String accountNumber, int balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    //Methods
    //Adds amountToDeposit to the current balance, and returns the new balance of the bank account
    public int deposit(int amountToDeposit) {
        return balance += amountToDeposit;
    }

    //Subtracts amountToWithdraw from the current balance, and returns the new balance of the bank account'
    public int withdraw(int amountToWithdraw) {
        return balance -= amountToWithdraw;
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
}