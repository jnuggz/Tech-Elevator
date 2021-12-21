package com.techelevator.farm;

public class Tractor implements Singable {

    public String getName() {
        return "Tractor";
    }

    public String getSound() {
        return "Rrrrrrrrr";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Tractor)) {
            return false;
        }
        Tractor other = (Tractor) obj;
        if (this.getName().equals(other.getName())
                && this.getSound().equals(other.getSound())) {
            return true;
        }
        return false;
    }
}
