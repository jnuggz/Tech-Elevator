package com.techelevator;

public class Airplane {

    //Member Variables
    private String planeNumber;
    private int totalFirstClassSeats;
    private int bookedFirstClassSeats;
    private int totalCoachSeats;
    private int bookedCoachSeats;

    //Constructor
    public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
        this.planeNumber = planeNumber;
        this.totalFirstClassSeats = totalFirstClassSeats;
        this.totalCoachSeats = totalCoachSeats;
    }

    //Derived Property
    public int getAvailableFirstClassSeats(){
        return totalFirstClassSeats - bookedFirstClassSeats;
    }

    public int getAvailableCoachSeats() {
        return totalCoachSeats - bookedCoachSeats;
    }

    //Method
    public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats) {
        boolean wasBooked = false;
        if (forFirstClass) {
            // book a first class seat
            // are there enough first class seats to add the ones being booked
            if (getAvailableFirstClassSeats() >= totalNumberOfSeats) {
                bookedFirstClassSeats += totalNumberOfSeats;
                wasBooked = true;
            }
        }else {
            // book a coach seat
            if (getAvailableCoachSeats() >= totalNumberOfSeats) {
                bookedCoachSeats += totalNumberOfSeats;
                wasBooked = true;
            }
        }
        return wasBooked;
    }

    //Getters
    public String getPlaneNumber() {
        return planeNumber;
    }

    public int getTotalFirstClassSeats() {
        return totalFirstClassSeats;
    }

    public int getBookedFirstClassSeats() {
        return bookedFirstClassSeats;
    }

    public int getTotalCoachSeats() {
        return totalCoachSeats;
    }

    public int getBookedCoachSeats() {
        return bookedCoachSeats;
    }
}
