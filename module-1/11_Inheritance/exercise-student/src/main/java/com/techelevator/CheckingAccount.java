package com.techelevator;

public class CheckingAccount extends BankAccount{

    //Constructor
    public CheckingAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    //Method Override
    //If balance is below $0.00 and is less than -$100, a $10 overdraft fee is also charged
    //Checking balance can't be overdrawn by $100 or more.
    //If withdrawal request leaves the account $100 or more overdrawn, it fails and the balance
    //  remains the same

    @Override
    public int withdraw(int amountToWithdraw) {
        int overDraft = 10;
        if (getBalance() - amountToWithdraw < 0 && getBalance() - amountToWithdraw > (-100)) {
            //the amountToWithdraw should be added with overdraft so a larger amount can be withdrawn
           int withdrawWithOverdraft = amountToWithdraw + overDraft;
            // line below same as super.withdraw(amountToWithdraw + overdraft)
            return super.withdraw(withdrawWithOverdraft) ;
        }
        else if (getBalance() - amountToWithdraw <= (-100)){
            return getBalance();
        }
        else if (getBalance() - amountToWithdraw > 0) {
           return super.withdraw(amountToWithdraw);
        }
        return super.getBalance();
    }
}
