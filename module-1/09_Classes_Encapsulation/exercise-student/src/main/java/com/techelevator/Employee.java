package com.techelevator;

public class Employee {

    //Member Variables
    private int employeeId;
    private String firstName;
    private String lastName;
    private String department;
    private double annualSalary;

    //Constructor
    public Employee(int employeeId, String firstName, String lastName, double annualSalary) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.annualSalary = annualSalary;
    }

    //Derived Property
    public String getFullName() {
        return lastName + ", " + firstName;
    }

    //Method
    public void raiseSalary(double percent) {
        if (percent > 0.00) {
            double raiseAmount = annualSalary * percent/100;
            annualSalary += raiseAmount;
        }
    }

    //Setter
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    //Getter
    public int getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDepartment() {
        return department;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }
}
