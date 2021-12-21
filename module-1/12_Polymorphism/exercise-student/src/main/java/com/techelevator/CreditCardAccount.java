package com.techelevator;

public class CreditCardAccount implements Accountable {

    //Member Variables
    //These properties are declared throughout the entire scope
    private String accountHolder;
    private String accountNumber;
    private int debt = 0;

    public CreditCardAccount(String accountHolder, String accountNumber) {
        // request accountHolder name
        // requires accountNumber
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
    }

    //Method
    //solving for what goes inside getBalance
    //When you check your balance, it should show debt as negative
    public int getBalance() {
        //get debt as a negative number
        int negativeDebt = debt * (-1);
        return negativeDebt;
        //could also do return debt * (-1); (derived)
        //could also do return -debt;
    }

    public int pay(int accountToPay){
        //remove amountToPay from debt
        //debt - amountToPay
        return debt -= accountToPay;
        //return new total owed
    }

    public int charge(int amountToCharge){
        //add amount to charge to amount owed
        //return new total amount owed
        return debt += amountToCharge;
    }

    //Getter
    public String getAccountHolder() {
        return accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getDebt() {
        return debt;
    }
}
