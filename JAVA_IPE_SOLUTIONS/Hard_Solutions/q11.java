
/* 
Remove Duplicates from an ArrayList and keeing all Unique numbers.
Write a Java program to remove duplicates from an ArrayList. You need to implement a function that takes an ArrayList as input and returns an ArrayList with duplicates removed.
---------------------------------------------------------------*/
import java.util.ArrayList;
import java.util.Collections;

class RemoveDuplicates {
    public static ArrayList removeDuplicates(ArrayList numbers) // function that takes an ArrayList as input
    {
        ArrayList result = new ArrayList();

        for (Object item : numbers) {
            if (Collections.frequency(result, item) < 1) {
                result.add(item);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList numbers = new ArrayList();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(2);
        numbers.add(1);
        numbers.add(4);

        ArrayList uniqueNumbers = removeDuplicates(numbers);

        System.out.println("Original list: " + numbers);
        System.out.println("List with duplicates removed: " + uniqueNumbers);
    }
}
