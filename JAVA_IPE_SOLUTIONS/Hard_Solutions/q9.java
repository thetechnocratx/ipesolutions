/* 
I have an Induction machine manufacturing company. My Manager wants to analyze some data of the induction machines of our manufacturing unit. 
What I have: List of machine's price. Note: each price is in Double. 
Write a java program that contains list of various machine's price. & do the following tasks. 
Task 1 - Create a list of 5 machine's price. [10000.0,55000.0,80000.0,25000.0,55000.0]
Task 2 - Find the maximum price from the list. 
Task 3 - sort the list.
-------------------------------------------------------------------------------*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MachinePriceAnalysis {
    public static void main(String[] args) {
        // Task 1 - Create a list of 5 machine's price
        List<Double> machinePrices = new ArrayList<>();
        machinePrices.add(10000.0);
        machinePrices.add(55000.0);
        machinePrices.add(80000.0);
        machinePrices.add(25000.0);
        machinePrices.add(55000.0);

        // Task 2 - Find the maximum price from the list
        double maxPrice = Collections.max(machinePrices);
        System.out.println("Maximum price: " + maxPrice);

        // Task 3 - Sort the list
        Collections.sort(machinePrices);
        System.out.println("Sorted list of machine prices: " + machinePrices);
    }
}