
/*	
Write a program that counts number of characters, words, and lines in a text file. */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class FileWordCount {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: java FileWordCount <file_path>");
            return;
        }

        String filePath = args[0];
        int charCount = 0;
        int wordCount = 0;
        int lineCount = 0;

        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String line;
        while ((line = reader.readLine()) != null) {
            lineCount++;
            charCount += line.length();
            String[] words = line.trim().split("\\s+");
            wordCount += words.length;
        }

        reader.close();

        System.out.println("Number of characters: " + charCount);
        System.out.println("Number of words: " + wordCount);
        System.out.println("Number of lines: " + lineCount);
    }
}