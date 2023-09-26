import java.io.*;

class FileCopy {
    public static void main(String[] args) throws IOException {
        // Provide the paths for file1.txt and file2.txt
        String sourcePath = "file1.txt";
        String destinationPath = "file2.txt";

        // Open the input and output streams
        FileInputStream inputStream = new FileInputStream(sourcePath);
        FileOutputStream outputStream = new FileOutputStream(destinationPath);

        // Copy the content from file1 to file2
        int data;
        while ((data = inputStream.read()) != -1) {
            outputStream.write(data);
        }

        // Close the streams
        inputStream.close();
        outputStream.close();

        System.out.println("Content of file1.txt has been copied to file2.txt.");
    }
}