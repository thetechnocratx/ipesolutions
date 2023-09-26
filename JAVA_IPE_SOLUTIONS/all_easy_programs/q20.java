import java.io.*;

class FileSearchAndRead {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: java FileSearchAndRead <filename>");
            return;
        }

        String fileName = args[0];
        File file = new File(fileName);

        if (!file.exists()) {
            System.out.println("File not found.");
            return;
        }

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }
}
