/* 	
Write a java program which read numbers from number.txt file and store even number to even.txt and odd number into odd.txt file */

import java.io.*;

class NumberSorter {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new FileReader("number.txt"));
        BufferedWriter evenWriter = new BufferedWriter(new FileWriter("even.txt"));
        BufferedWriter oddWriter = new BufferedWriter(new FileWriter("odd.txt"));

        String line = reader.readLine();
        while (line != null) {
            int number = Integer.parseInt(line);
            if (number % 2 == 0) {
                evenWriter.write(Integer.toString(number));
                evenWriter.newLine();
                line = reader.readLine();
            } else {
                oddWriter.write(Integer.toString(number));
                oddWriter.newLine();
                line = reader.readLine();
            }
        }

        System.out.println("Numbers sorted and saved successfully!");
        evenWriter.close();
        oddWriter.close();

    }
}