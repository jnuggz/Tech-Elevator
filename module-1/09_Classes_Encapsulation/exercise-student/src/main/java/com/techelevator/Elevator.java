package com.techelevator;

public class Elevator {

    //Member Variable
    private int currentFloor = 1;
    private int numberOfFloor;
    private boolean doorOpen;

    //Constructor
    public Elevator(int numberOfLevels){
        this.numberOfFloor = numberOfLevels;
    }

    //Method
    public void openDoor() {
        this.doorOpen = true;
    }

    public void closeDoor() {
        this.doorOpen = false;
    }

    public void goUp(int desiredFloor) {
        if (doorOpen = false && desiredFloor <= numberOfFloor) {
            if (desiredFloor >= currentFloor) {
                currentFloor = desiredFloor;
            }
        }
    }

    public void goDown(int desiredFloor) {
        if (doorOpen = false && currentFloor != 1) {
            desiredFloor = currentFloor;
        }
    }

    //Getter
    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public boolean isDoorOpen() {
        return doorOpen;
    }
}
