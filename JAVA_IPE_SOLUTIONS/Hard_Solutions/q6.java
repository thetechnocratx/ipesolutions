
/*
 *  write a program to enter the five subject marks out of 100 of student. 
 * If any subject marks is less than 35 then programm will generate exception
 */
import java.util.Scanner;

class failException extends RuntimeException {
    failException(String s) {
        super(s);
    }
}

public class q6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double marks[] = new double[5];
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter marks of subject " + (i + 1));
            marks[i] = sc.nextDouble();

            if (marks[i] < 35) {
                throw new failException("Sorry You are failed");
            } else {
                continue;
            }
        }
        System.out.println("Congratulations You have Passed This Semester!!");

    }
}
