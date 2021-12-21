package com.techelevator;

import java.util.Scanner;

public class TempTest {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        //Parsing will put the String value into the double Data Type
        System.out.println("Please enter the temperature: ");
        String userInputTemp = userInput.nextLine();
        double tempNumber = Double.parseDouble(userInputTemp);

        //User will enter f,F,fahrenheit,Fahrenheit or c,C,celsius,Celcius
        System.out.println("Was the temperature in (C)elsius or (F)ahrenheit?");
        String degreeType = userInput.nextLine();

        //Conversion formula assign to a new variable
        double tempC = (tempNumber - 32) / 1.8;
        double tempF = (tempNumber * 1.8) + 32;

        //If the user input for degreeType = any of the conditions below, run the System.out.println
        if (degreeType == "f" || degreeType == "F" || degreeType == "fahrenheit" || degreeType == "Fahrenheit"){
            System.out.println(tempNumber + "F" + " is" + tempC + "C");
        }
        else if (degreeType == "c" || degreeType == "C" || degreeType == "celsius" || degreeType == "Celsius"){
            System.out.print(tempNumber + "C" + " is" + tempF + "F");
        }


    }
}


