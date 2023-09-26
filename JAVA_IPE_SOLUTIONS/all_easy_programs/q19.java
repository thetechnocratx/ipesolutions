import java.io.*;

class FileCopy {
    public static void main(String[] args) throws IOException {
        // Check if the correct number of command-line arguments are provided
        if (args.length != 2) {
            System.out.println("Usage: java FileCopy <source-file> <destination-file>");
            return;
        }

        String sourceFileName = args[0];
        String destinationFileName = args[1];

        // Open the source file and read its content into a character array
        FileReader fileReader = new FileReader(sourceFileName);
        int fileSize = (int) new File(sourceFileName).length();
        char[] content = new char[fileSize];
        fileReader.read(content);
        fileReader.close();

        // Write the content from the character array to the destination file
        FileWriter fileWriter = new FileWriter(destinationFileName);
        fileWriter.write(content);
        fileWriter.close();

        System.out.println("File copied successfully.");
    }
}