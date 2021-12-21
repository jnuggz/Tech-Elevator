package com.techelevator.farm;

public class Tractor implements Singable {

    public String getName() {
        return "Tractor";
    }

    public String getSound() {
        return "Rrrrrrr";
    }

    /*
        Argument is Object obj
        Everything can upcast to Object except primitives
    */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Tractor)) {
            return false;
        }
        Tractor other = (Tractor) obj;
        if (other.getName().equals(this.getSound())){
            return true;
        }
        return false;
    }
}
