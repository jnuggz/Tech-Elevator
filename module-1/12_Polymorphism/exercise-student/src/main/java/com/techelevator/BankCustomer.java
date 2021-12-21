package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class BankCustomer {

    private String name;
    private String address;
    private String phoneNumber;
    private List<Accountable> accounts = new ArrayList<Accountable>();

    //Method
    //Adds newAccount to the customer's list of accounts
    public void addAccount(Accountable newAccount){
    accounts.add(newAccount);
    }

    public Accountable[] getAccounts() {
        Accountable[] accountsList = new Accountable[accounts.size()];
        accountsList = accounts.toArray(accountsList);
        return accountsList;
    }

    public boolean isVip(){
        //need to implement credit - debt >= $25000 return true
        //return false
        int combinedBalance = 0;
        for (Accountable vip : accounts) {
            combinedBalance += vip.getBalance();
        }
        return (combinedBalance >= 25000);
    }

    //Getter
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    //Setter
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
