
import java.util.*;

public class q15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        System.out.print("Enter the number of integers: ");
        int numIntegers = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character left by nextInt()

        for (int i = 0; i < numIntegers; i++) {
            System.out.print("Enter integer " + (i + 1) + ": ");
            int value = scanner.nextInt();
            priorityQueue.add(value);
        }

        System.out.println("Top three highest integers:");

        // Removing and displaying the top three highest integers
        for (int i = 0; i < 3; i++) {
            if (!priorityQueue.isEmpty()) {
                int highestInt = priorityQueue.poll();
                System.out.println(highestInt);
            } else {
                System.out.println("Not enough integers in the PriorityQueue.");
                break;
            }
        }

        scanner.close();
    }
}
