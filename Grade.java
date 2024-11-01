package codeSoft;

import java.util.ArrayList;
import java.util.Scanner;

public class Grade {
    private final Scanner scan = new Scanner(System.in);
    private int noOfSub;
    private final ArrayList<Integer> marks = new ArrayList<>();
    private final String sName;
    private boolean isSet = false;

    public Grade(String sName) {
        this.sName = sName;
    }

    public void setMarks() {
        System.out.print("Enter no. of subjects: ");
        noOfSub = scan.nextInt();

        for (int i = 0; i < noOfSub; i++) {
            System.out.print("Enter " + (i + 1) + " subject marks: ");
            marks.add(scan.nextInt());
        }
        isSet = true;
    }

    public void getData() {
        if (!isSet) {
            System.out.println("please Set marks first!, then call the function again");
            return;
        }

        System.out.println("\n\nMarks details for " + sName);
        calc();
    }

    private void calc() {
        float totalMarks = 0;

        for (int mark : marks) {
            totalMarks += mark;
        }

        double percentage = Math.floor((totalMarks / (100 * noOfSub)) * 100);

        System.out.println("\nYou Got " + (totalMarks) + " out of " + (100 * noOfSub));
        System.out.println("Percentage: " + percentage + "%");
        System.out.println("Average Marks: " + totalMarks / noOfSub);
        System.out.println("Grade: " + getGrade(percentage));
    }

    private String getGrade(double per) {
        if (per >= 90 && per <= 100) {
            return "A+";
        } else if (per >= 85 && per <= 89) {
            return "A";
        } else if (per >= 80 && per <= 84) {
            return "A-";
        } else if (per >= 75 && per <= 79) {
            return "B+";
        } else if (per >= 70 && per <= 74) {
            return "B";
        } else if (per >= 65 && per <= 69) {
            return "C+";
        } else if (per >= 60 && per <= 64) {
            return "C";
        } else if (per >= 55 && per <= 59) {
            return "D+";
        } else if (per >= 50 && per <= 54) {
            return "D";
        } else if (per >= 40 && per <= 49) {
            return "E";
        } else if (per >= 0 && per <= 39) {
            return "F";
        } else {
            return "invalid";
        }
    }
}