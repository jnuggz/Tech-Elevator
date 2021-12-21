package com.techelevator.vehicle;

import java.util.Locale;

public class Bus {

    //Constant
    //final means value can't be assigned a second time
    //static means it belongs to the class and shared across all instances
    //to stand out that it is a constant, all Caps with underscore _
    private final static int TOTAL_SEATS = 40;

    //Member Variables or Instance Variables
    //holds the data and create object state
    //private hides it, can keep it from being seen by another class
    private String routeName;
    private int passengers;
    private int gallonsOfGas = 50;
    private boolean isDoorOpen = false;

    /*
        No Argument Constructor
        Provided by implicitly default as long as there is only 1 constructor
        Has no return type

        Once a constructor overload has been added, then the no argument constructor
        must be explicit in the code. If there are no other constructors (overloads)
        then the no-argument constructor is assumed by java.
     */
    public Bus() {

    }

    /*
        Constructor Overload provides values that can be set when instantiating
        the class into an object. Can have 0...n constructor overloads
     */
    public Bus(String routeName) {
        this.routeName = routeName;
        //Changing "routeName" after the = to cleanRouteName will apply the Private
        //Method of Upper Casing and -
    }

    public Bus(String routeName, int currentGas) {
        this.routeName = routeName;
        this.gallonsOfGas = currentGas;
    }


    /*
        Getters
        Gives access to retrieve the value
        Returns a value using this.
        Doesn't need Getter for everything
     */
    public String getRouteName() {
        return this.routeName;
    }

    public int getGallonsOfGas() {
        return this.gallonsOfGas;
    }

    //Getters for Boolean uses "is" instead of "get" at the beginning
    public boolean isDoorOpen() {
        return this.isDoorOpen;
    }

    /*
        Setter
        Gives access to change the values
        Uses void so it doesn't return any values
        Has to take an argument inside ()
     */
    public void setRouteName(String routeName) {
        //"this" refers to this instance of "String routeName" from the private class (purple text)
        //routeName after  the = refers to the variable routeName above (Line 68)
        //String name = routeName.replaceAll("", "-"); moved to line 81
        //this.routeName = name.toUpperCase();
        this.routeName = formatRouteName(routeName);
    }

    /*
        Encapsulated Setters
        Are setters that encapsulate the functionality behind more intuitive names
        Doesn't need to use "is" in front, only used after this
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
            of storing it. It NEVER stores the value.
        Doesn't need to store value because if you change a value, it changes the calculated value
        This is like a Getter
     */
    public int getRemainingSeats() {
        return TOTAL_SEATS - this.passengers;
    }

    /*
        Method
     */
    //This method will allow 1 passenger to enter the bus
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
            have different data types
     */
    public boolean board(int boardingPassengers) {
        if (this.isDoorOpen && getRemainingSeats() >= boardingPassengers) {
            this.passengers += boardingPassengers;
            return true;
        }
        return false;
    }

    /*
        Private Methods
        Only available in this class
     */
    private String formatRouteName(String routeName) {
        String name = routeName.replaceAll(" ", "-");
        return name.toUpperCase();
    }

    /*
        Function Overriding
        some methods will be "inherit" from other classes
        uses toString() and equals()
        Must provide an identical method signature as the one being overridden
    */


    @Override
    public String toString() {
        return "Route " + this.routeName + " is carrying " + this.passengers
                + " passengers";
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

    // can't return this.gallonsOfGas because it hasn't been created yet
    public static int getDistanceRemaining(int gallonsOfGas, int mpg){
        return gallonsOfGas * mpg;
    }

}

