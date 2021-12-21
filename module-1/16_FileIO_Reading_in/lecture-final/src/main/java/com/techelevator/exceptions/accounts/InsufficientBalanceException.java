package com.techelevator.exceptions.accounts;

public class InsufficientBalanceException extends Exception {

    private int additionalFee;

    public InsufficientBalanceException(String message, int additionalFee) {
        super(message);
        this.additionalFee = additionalFee;
    }

    public int getAdditionalFee() {
        return this.additionalFee;
    }
}
