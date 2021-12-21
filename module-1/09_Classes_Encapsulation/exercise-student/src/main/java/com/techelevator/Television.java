package com.techelevator;

public class Television {

    private boolean isOn = false;
    private int currentChannel = 3;
    private int currentVolume = 2;

    //Methods
    public void turnOff() {
        this.isOn = false;
    }
    public void turnOn() {
        this.isOn = true;
        this.currentChannel = 3;
        this.currentVolume = 2;
    }

    /*
        Change the current channel to the value of the newChannel
        - if the TV on
        - if newChannel between 3 and 18
     */
    public void changeChannel(int newChannel) {
        if (this.isOn == true && (newChannel >= 3 && newChannel <= 18)) {
            this.currentChannel = newChannel;
        }
    }
    public void channelUp() {
        if (isOn == true) {
            currentChannel++;
        if (isOn & currentChannel > 18) {
            currentChannel = 3;
            }
        }
    }
    public void channelDown() {
        if (isOn == true) {
            currentChannel--;
        if (isOn && currentChannel < 3) {
            currentChannel = 18;
        }
        }
    }
    public void raiseVolume() {
        if (isOn == true && currentVolume < 10) {
            currentVolume++;
        }
    }
    public void lowerVolume() {
        if (isOn && currentVolume > 0)  {
            currentVolume--;
        }
    }

    //Getter
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