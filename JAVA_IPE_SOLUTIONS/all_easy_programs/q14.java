import java.util.*;

public class q14 {
    public static void main(String[] args) {
        HashSet<Integer> uniqueValues = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter Integer Number ");
            int no = sc.nextInt();
            sc.nextLine();
            System.out.println("DO YOU WANT TO CONTINUE ? YES OR NO");
            uniqueValues.add(no);

            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("NO")) {
                break;
            }
        }
        int sum = 0;
        for (Integer i : uniqueValues) {
            sum = sum + i;
        }
        System.out.println("SUM = " + sum);
    }
}