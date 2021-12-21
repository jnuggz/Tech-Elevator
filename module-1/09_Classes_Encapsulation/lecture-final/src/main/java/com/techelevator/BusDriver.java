package com.techelevator;

import com.techelevator.vehicle.Bus;


public class BusDriver {

    //psvm
    public static void main(String[] args) {

        Bus busOne = new Bus();
        busOne.setRouteName("High Street");

        Bus busTwo = new Bus("2nd Street");

        Bus busThree = new Bus("Front Street", 8);


        System.out.println( busOne.getRouteName() );

        busOne.openDoor();
        busOne.closeDoor();

        System.out.println( busOne.getRemainingSeats() );

        final int x;
        x = 10;


        busOne.openDoor();
        busOne.board();
        busOne.board(5);

        System.out.println("Print out of Bus");
        System.out.println( busOne );

        Bus busA = new Bus("abc");
        Bus busB = new Bus("abc");

        if (busA.equals(busB)) {
            System.out.println("This is the same bus");
        }

        Bus.getDistanceRemaining(10, 7);
    }
}
