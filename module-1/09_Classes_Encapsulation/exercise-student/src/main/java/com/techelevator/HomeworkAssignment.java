package com.techelevator;

public class HomeworkAssignment {

    private int earnedMarks;
    private int possibleMarks;
    private String submitterName;

    //Constructor
    public HomeworkAssignment(int possibleMarks, String submitterName) {
        this.possibleMarks = possibleMarks;
        this.submitterName = submitterName;
    }

    //Derived Property
    public String getLetterGrade() {
        double percentage = (double)earnedMarks / (double)possibleMarks;
        if (percentage >= 0.90) {
            return "A";
        }else if (percentage >= 0.80 && percentage <= 0.89) {
            return "B";
        }else if (percentage >= 0.70 && percentage <= 0.79) {
            return "C";
        }else if (percentage >= 0.60 && percentage <= 0.69) {
            return "D";
        }
        return "F";
    }

    //Setter
    public void setEarnedMarks(int earnedMarks) {
        this.earnedMarks = earnedMarks;
    }

    //Getters
    public int getEarnedMarks() {
        return earnedMarks;
    }

    public int getPossibleMarks() {
        return possibleMarks;
    }

    public String getSubmitterName() {
        return submitterName;
    }
}
