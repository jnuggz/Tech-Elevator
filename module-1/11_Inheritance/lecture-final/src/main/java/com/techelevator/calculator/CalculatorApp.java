package com.techelevator.calculator;

public class CalculatorApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calculator calc = new Calculator(0);
		ScientificCalculator sciCalc = new ScientificCalculator(0);
		TrignometricCalculator trigCalc = new TrignometricCalculator();

		// TrignometricCalculator IS-A ScientificCalculator
		// TrignometricCalculator IS-A Calculator
		// TrignometricCalculator IS-A Object


		Calculator trigAsRegularCalc = trigCalc;



		// Causes a ClassCastException because calc is NOT already a Trignometric Calculator
		//TrignometricCalculator regularCalcAsTrig = (TrignometricCalculator) calc;

		TrignometricCalculator regularCalcAsTrig = (TrignometricCalculator) trigAsRegularCalc;

		ScientificCalculator trigAsSciCalc = regularCalcAsTrig;


	}
	

}
