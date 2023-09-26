import java.io.File;

class FileInfo {
    public static void main(String[] args) {
        // Specify the path to the file
        String filePath = "path_to_your_file";

        // Create a File object
        File file = new File(filePath);

        // Print the name of the file
        System.out.println("Name: " + file.getName());

        // Print the length of the file in bytes
        System.out.println("Length: " + file.length() + " bytes");

        // Print the read/write permissions of the file
        System.out.println("Readable: " + file.canRead());
        System.out.println("Writable: " + file.canWrite());
    }
}
