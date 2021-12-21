package com.techelevator;

public class SavingsAccount extends BankAccount {

    //Constructor
    public SavingsAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public SavingsAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    //Method Override
    //If the current balance is less than $150 when a withdrawal is made, an additional $2 service
    // charge is withdrawn from the account
    //If a withdrawal is requested for more than the current balance, the withdrawal fails and
    // the balance remains the same. No fees are incurred


    @Override
    public int withdraw(int amountToWithdraw) {
        int additionalService = 2;
        if (getBalance() - amountToWithdraw < 150 && getBalance() - amountToWithdraw >= 0) {
            return super.withdraw(amountToWithdraw + additionalService);
        } else if (amountToWithdraw < getBalance()) {
            return super.withdraw(amountToWithdraw);
        }
        return getBalance();
    }
}





