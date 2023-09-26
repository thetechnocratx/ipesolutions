
/* 
Write a program that counts the no. of words in a text file. The file name is passed as a
command line argument. The program should check whether the file exists or not. The
words in the file are separated by white space characters */
import java.io.*;

class WordCounter {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please provide the file name as a command line argument.");
            return;
        }

        try {
            String fileName = args[0];

            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            int wordCount = 0;
            String line = reader.readLine();
            while (line != null) {
                String[] words = line.split(" ");
                wordCount += words.length;
                line = reader.readLine();
            }
            System.out.println("Number of words in the file: " + wordCount);
        } catch (FileNotFoundException e) {
            System.out.println("The file does not exist.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        }
    }
}