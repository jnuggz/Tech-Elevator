package com.techelevator.models;

public class HotelAddress {
    private String address;
    private String zip;
    private String thisIsSomethingExtra;

    public String getThisIsSomethingExtra() {
        return thisIsSomethingExtra;
    }

    public void setThisIsSomethingExtra(String thisIsSomethingExtra) {
        this.thisIsSomethingExtra = thisIsSomethingExtra;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
