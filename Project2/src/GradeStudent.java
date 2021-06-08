/* This class was created by PhoiNguyen on 04/15/2021 */

import java.util.Scanner;

public class GradeStudent {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        begin();

        /* Begin midterm section input */
        System.out.println("Midterm: ");
        System.out.print("Weight (0-100)? ");
        int midtermWeight = input.nextInt();
        // Call midterm method and save value return in variable midtermWeightScore
        double midtermWeightedScore = midterm(midtermWeight, input);
        /* End midterm section input */

        /* Begin finalterm section input */
        System.out.println("Final: ");
        System.out.print("Weight (0-100)? ");
        int finalWeight = input.nextInt();
        // Call finalterm method and save value return in variable finaltermWeightScore
        double finaltermWeightScore = finalterm(finalWeight, input);
        /* End finalterm section input*/

        /* Begin homework section input */
        System.out.println("Homework: ");
        System.out.print("Weight (0-100)? ");
        int homeworkWeight = input.nextInt();
        while (homeworkWeight != (100 - midtermWeight - finalWeight)) {
            System.out.print("Please check weight again. Total must be 100. ");
            homeworkWeight = input.nextInt();
        }
        //Call homework method and save value in variable homeworkWeight
        double homeworkWeightScore = homework(homeworkWeight, input);
        /* End homework section input */

        /* Finally report */
        report(midtermWeightedScore, finaltermWeightScore, homeworkWeightScore);
    }

    public static void begin() {
        System.out.println("This program reads exam/homework scores and reports your overall course grade.");
    }

    public static double midterm(int midtermWeight, Scanner input) {
        System.out.print("Score earned? ");
        int midtermScore = input.nextInt();
        System.out.print("Were scores shifted (1=yes, 2=no)? ");
        int midtermShifted = input.nextInt();
        int midtermTotalPoint = midtermScore;
        if (midtermShifted == 1) {
            System.out.print("Shift amount? ");
            int midtermShiftAmount = input.nextInt();
            midtermTotalPoint += midtermShiftAmount;
        }

        /* Check if the total points are greater than 100 */
        if (midtermTotalPoint > 100) {
            midtermTotalPoint = 100;
        }
        System.out.println("Total points = " + midtermTotalPoint + "/ 100");
        double midtermWeightedScore = Math.round((double) midtermTotalPoint * midtermWeight / 100 * 10) / 10.0;
        System.out.println("Weigthed score = " + midtermWeightedScore);
        System.out.println();
        return midtermWeightedScore;
    }

    public static double finalterm(double finalWeight, Scanner input) {
        System.out.print("Score earned? ");
        int finalScore = input.nextInt();
        System.out.print("Were scores shifted (1=yes, 2=no)? ");
        int finalShifted = input.nextInt();
        int finalTotalPoint = finalScore;
        if (finalShifted == 1) {
            System.out.print("Shift amount? ");
            int finalShiftAmout = input.nextInt();
            finalTotalPoint += finalShiftAmout;
        }

        /* Check if the total points are greater than 100 */
        if (finalTotalPoint > 100) {
            finalTotalPoint = 100;
        }
        System.out.println("Total points = " + finalTotalPoint + "/ 100");
        double finalWeightedScore = Math.round((double) finalTotalPoint * finalWeight / 100 * 10) / 10.0;
        System.out.println("Weigthed score = " + finalWeightedScore);
        System.out.println();
        return finalWeightedScore;
    }

    public static double homework(double homeworkWeight, Scanner input) {

        // User input assignments' score
        System.out.print("Number of assignments? ");
        int numberOfAssignment = input.nextInt();
        int totalAssignmentScore = 0;
        int totalAssignmentMaxScore = 0;
        for (int i = 1; i <= numberOfAssignment; i++) {
            System.out.print("Assignment " + i + " score and max? ");
            totalAssignmentScore += input.nextInt();
            totalAssignmentMaxScore += input.nextInt();
        }

        /* Check if the total of assignment points are greater than 150 */
        if (totalAssignmentScore > 150) {
            totalAssignmentScore = 150;
        }
        if (totalAssignmentMaxScore > 150) {
            totalAssignmentMaxScore = 150;
        }

        // User input section attend
        System.out.print("How many sections did you attend? ");
        int numberOfSectionAttend = input.nextInt();

        /* Check if the section points are greater than 30 */
        if (numberOfSectionAttend > 6) {
            numberOfSectionAttend = 6;
        }
        int sectionPoint = numberOfSectionAttend * 5;

        // Print out score
        int homeworkTotalPoint = totalAssignmentScore + sectionPoint;
        int homeworkTotalMaxPoint = totalAssignmentMaxScore + 30;
        System.out.println("Section points = " + sectionPoint + "/ 30");
        System.out.println("Total points = " + homeworkTotalPoint + "/" + homeworkTotalMaxPoint);
        double homeworkWeightedScore = Math.round((double) homeworkTotalPoint / homeworkTotalMaxPoint * homeworkWeight * 10) / 10.0;
        System.out.println("Weigthed score = " + homeworkWeightedScore);
        System.out.println();
        return homeworkWeightedScore;
    }

    public static void report(double midtermScore, double finaltermScore, double homeworkScore) {
        double overallPercent = midtermScore + finaltermScore + homeworkScore;
        System.out.println("Overall Percentage = " + overallPercent);
        double grade = 0.0;

        /* check which grade will fall back */
        if (overallPercent >= 85.0) {
            grade = 3.0;
        } else if (overallPercent >= 75.0) {
            grade = 2.0;
        } else if (overallPercent >= 60.0) {
            grade = 0.7;
        } else {
            grade = 0.0;
        }
        System.out.println("Your grade will be at least: " + grade);
        System.out.println("<< Your custom grade message here >>");
    }

}
