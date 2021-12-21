package com.techelevator;

public class FlowerShopOrder extends Module1CodingAssessment {

    //Member Variables
    private String bouquetType;
    private int numberOfRoses;
    private double subTotal;

    //Constructor
    public FlowerShopOrder (String bouquetType, int numberOfRoses) {
        this.bouquetType = bouquetType;
        this.numberOfRoses = numberOfRoses;
    }

    //delivery fee = $3.99 if zipcode is between 20000 and 29999
    //delivery fee = $6.99 if zipcode is between 30000 and 39999
    //delivery fee = $0    if zipcode is between 10000 and 19999
    //delivery fee = $19.99 if zipcode doesn't meet requirements
    //same-day delivery = $5.99
    int waivedFee = 0;
    double sameDayDelivery = 5.99;
    double deliveryFeeOne = 3.99;
    double deliveryFeeTwo = 6.99;
    double deliveryFeeThree = 19.99;

    //Method
//    public double deliver(boolean sameDayDelivery, String zipcode){
//        if (sameDayDelivery){
//            return subTotal = sameDayDelivery;
//        } else if (zipcode
//    }

    @Override
    public String toString(){
        return "Order -" + this.bouquetType + " " + this.numberOfRoses + " roses "
                + this.subTotal;
    }

    //Getters and Setters
    public String getBouquetType() {
        return bouquetType;
    }

    public void setBouquetType(String bouquetType) {
        this.bouquetType = bouquetType;
    }

    public int getNumberOfRoses() {
        return numberOfRoses;
    }

    public void setNumberOfRoses(int numberOfRoses) {
        this.numberOfRoses = numberOfRoses;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
}
