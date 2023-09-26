import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class SumFromFile {
    public static void main(String[] args) throws IOException {
        String fileName = "Number.txt";

        int sum = 0;
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            int number = Integer.parseInt(line.trim());
            sum += number;
        }
        System.out.println("Sum of numbers in " + fileName + ": " + sum);
    }
}