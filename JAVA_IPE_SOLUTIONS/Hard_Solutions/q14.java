/*Write a program that reads in a list of words from the user and
stores them in a HashSet. The program should then prompt the
user for a prefix and output all the words in the set that start with
that prefix.
 */

import java.util.*;

public class q14 {
    public static void main(String[] args) {
        HashSet<String> words = new HashSet<>();
        Scanner sc = new Scanner(System.in);

        // Read words from user and stores them in to HashSet

        System.out.println("---------------------------------");
        while (true) {
            System.out.print("Enter Word ");
            String w = sc.nextLine();
            words.add(w);
            System.out.println("DO YOU WANT TO CONTINUE ? YES OR NO");

            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("NO")) {
                break;
            }
        }

        System.out.println("Enter prefix for the word that you want to search from HashSet ? ");
        String prefix = sc.next();
        for (String s : words) {
            if (s.startsWith(prefix)) {
                System.out.println("---> " + s);
            }
        }
    }
}