import java.io.*;

class CountDigit5Occurrences {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Usage: java CountDigit5Occurrences <filename>");
            return;
        }

        String filename = args[0];
        int count = 0;
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = reader.readLine();
        while (line != null) {
            char ch[] = line.toCharArray();
            for (char c : ch) {
                if (c == '5') {
                    count++;
                }
            }
            line = reader.readLine();
        }
        System.out.println("Number of occurrences of digit 5 in the file: " + count);
    }
}