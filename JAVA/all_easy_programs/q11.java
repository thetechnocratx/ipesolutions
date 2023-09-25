import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class q11 {
    public static void main(String[] args) {
        // Create the source ArrayList
        ArrayList<Integer> a1 = new ArrayList<>();
        a1.add(5);
        a1.add(2);
        a1.add(8);
        a1.add(1);
        a1.add(9);

        // Copy the source ArrayList into a new ArrayList
        ArrayList<Integer> b1 = new ArrayList<>(a1);

        // Sort the destination ArrayList
        Collections.sort(b1);

        // Display the sorted destination ArrayList
        System.out.println("Sorted Destination ArrayList: " + b1);

        // Search for an element in the destination ArrayList
		Scanner sc = new Scanner(System.in);
        int elementToSearch = sc.nextInt();
        if (b1.contains(elementToSearch)) {
            System.out.println("Element " + elementToSearch + " found in the destination ArrayList.");
        } else {
            System.out.println("Element " + elementToSearch + " not found in the destination ArrayList.");
        }
    }
}