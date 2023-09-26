import java.util.HashMap;
import java.util.*;

public class q13 {
    public static void main(String[] args) {
        HashMap<String, String> phonebook = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String name, number;
        while (true) {
            System.out.println("Enter Name");
            name = sc.nextLine();

            System.out.println("Enter Number");
            number = sc.nextLine();
            phonebook.put(name, number);
            System.out.println("Do you want to add Data ? Enter Yes or No");
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("NO")) {
                break;
            }
        }

        System.out.println("Enter the name you want to search from phonebook ?");
        String searchName = sc.nextLine();
        String searchNumber = phonebook.get(searchName);
        if (searchNumber != null) {
            System.out.println("Phone Number of " + searchName + " = " + searchNumber);
        } else {
            System.out.println("Name is not there in phonebook");
        }
    }

}