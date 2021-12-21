package com.techelevator;

public class Television {

    private boolean isOn = false;
    private int currentChannel = 3;
    private int currentVolume = 2;

    public void turnOff() {
        this.isOn = false;
    }

    public void turnOn(){
        this.isOn = true;
        this.currentChannel = 3;
        this.currentVolume = 2;
    }

    /*
    changes the current channel to the value of
    newChannel
        — if the TV is on
        — if newChannel is between 3 and 18.
     */
    public void changeChannel(int newChannel) {
        if (this.isOn == true && (newChannel >= 3 && newChannel <= 18)) {
            this.currentChannel = newChannel;
        }
    }

    public void channelUp(){

    }

    public void channelDown(){

    }

    public void raiseVolume(){
        if (isOn && currentVolume < 10) {
            currentVolume++;
        }
    }

    public void lowerVolume(){
        if(isOn && currentVolume > 0) {
            currentVolume--;
        }
    }


    public boolean isOn() {
        return isOn;
    }

    public int getCurrentChannel() {
        return currentChannel;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }
}
