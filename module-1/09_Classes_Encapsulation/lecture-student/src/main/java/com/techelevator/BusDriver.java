package com.techelevator;

import com.techelevator.vehicle.Bus;

public class BusDriver {
    //psvm for shortcut
    //has to be static because its hasn't been instantiated
    public static void main(String[] args) {

        Bus busOne = new Bus();

        busOne.setRouteName("High Street");

        //Constructor Overload
        Bus busTwo = new Bus("2nd Street");
        Bus busThree = new Bus("Front Street", 8);

        //Below will print "HIGH-STREET"
        //Setter replaced all spaces with "-"
        //also sets all to Upper Case
        System.out.println( busOne.getRouteName() );

        //From Encapsulated Setters
        //This sets the door open
        busOne.openDoor();
        //This sets the door close
        busOne.closeDoor();

        System.out.println( busOne.getRemainingSeats() );

        //final
        //if x is assigned to 10 and your try to assign it again to 20, it will fail
        final int x;
        x = 10;

        //Linked to Method
        //Door has to be open in order to board (line 120)
        busOne.openDoor();
        busOne.board();
        //Method Overloading
        busOne.board(5);

        System.out.println("Print out of Bus");
        System.out.println( busOne );

        //Linked to @Override
        Bus busA = new Bus("abc");
        Bus busB = new Bus("abc");

        if (busA.equals(busB)){
            System.out.println("This is the same bus");
        }

        //the class Bus can use .getDistanceRemaining but not an object
        Bus.getDistanceRemaining(10, 7);
    }



}
