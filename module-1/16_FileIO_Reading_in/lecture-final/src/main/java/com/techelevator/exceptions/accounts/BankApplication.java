package com.techelevator.exceptions.accounts;

import java.util.Scanner;

public class BankApplication {

    private final static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        Account account = new CheckingAccount();

        System.out.println("Welcome to the Java Blue bank");
        showBalance(account);
        System.out.println();

        int amount = 0;

        while(true) {
            System.out.print("Amount to withdraw >>> ");
            String userInput = input.nextLine();

            try {
                amount = Integer.parseInt(userInput);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid amount");
            }
        }

        try {
            account.withdraw(amount);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
            System.out.println("Additional fee added: $" + e.getAdditionalFee());
        }


        System.out.println(amount + " was withdrawn");
        showBalance(account);


    }

    private static void showBalance(Account account) {
        System.out.println("Current Balance: " + account.getBalance());
    }

}
