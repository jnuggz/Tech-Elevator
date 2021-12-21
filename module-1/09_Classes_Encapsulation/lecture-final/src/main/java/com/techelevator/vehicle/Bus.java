package com.techelevator.vehicle;

public class Bus {

    private final static int TOTAL_SEATS = 40;

    private String routeName;
    private int passengers;
    private int gallonsOfGas = 50;
    private boolean isDoorOpen = false;

    /*
        No Argument constructor
        Provided by implicitly default as long as there is only 1 constructor.

        Once a constructor overload has been added, then the no argument constructor
        must be explicit in the code.  If there are no other constructors (overloads),
        then the no-argument constructor is assumed by java.
     */
    public Bus() {

    }

    /*
    Constructor Overload provides values that can be set when instantiating
    the class into an object.  Can have 0...n constructor overloads
     */
    public Bus(String routeName) {
        this.routeName = formatRouteName(routeName);
    }

    public Bus(String routeName, int currentGas) {
        this.routeName = formatRouteName(routeName);
        this.gallonsOfGas = currentGas;
    }


    /*
     Getters
     */
    public String getRouteName() {
        return this.routeName;
    }
    public int getGallonsOfGas() {
        return this.gallonsOfGas;
    }
    public boolean isDoorOpen() {
        return this.isDoorOpen;
    }

    /*
     Setter
     */
    public void setRouteName(String routeName) {
        this.routeName = formatRouteName(routeName);
    }


    /*
        Encapsulated Setters
        Are setters that encapsulate the functionality behind more intuitive names
     */
    public void openDoor() {
        this.isDoorOpen = true;
    }

    public void closeDoor() {
        this.isDoorOpen = false;
    }

    public void addGas(int gallons) {
        this.gallonsOfGas += gallons;
    }

    /*
        Derived Property - calculates the value it returns instead
             of storing it.  It NEVER stores the value.
     */
    public int getRemainingSeats() {
        return TOTAL_SEATS - this.passengers;
    }


    /*
     Method
     */
    public boolean board() {
        if (this.isDoorOpen && getRemainingSeats() >= 1) {
            this.passengers += 1;
            return true;
        }
        return false;
    }

    /*
    Method Overloading
    Methods with the same name and return type and different arguments
        Have either a different number of arguments AND/OR the arguments
        have different data types.
     */
    public boolean board(int boardingPassengers) {
        if (this.isDoorOpen && getRemainingSeats() >= boardingPassengers) {
            this.passengers += boardingPassengers;
            return true;
        }
        return false;
    }

    private String formatRouteName(String routeName) {
        String name = routeName.replaceAll(" ", "-");
        return name.toUpperCase();
    }

    @Override
    public String toString() {
        return "Route " + this.routeName + " is carrying "
                + this.passengers + " passengers";
    }

    @Override
    public boolean equals(Object obj) {
        Bus other = (Bus) obj;
        if (this.routeName.equals(other.getRouteName()) &&
                this.gallonsOfGas == other.getGallonsOfGas()) {
            return true;
        }
        return false;
    }

    public static int getDistanceRemaining(int gallonsOfGas, int mpg) {
        return gallonsOfGas * mpg;
    }
}
