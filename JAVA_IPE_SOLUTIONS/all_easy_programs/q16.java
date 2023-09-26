import java.io.File;

class FileTypeChecker {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please provide the file or directory name as a command lineargument.");
            return;
        }

        String path = args[0];
        File file = new File(path);

        if (file.isFile()) {
            System.out.println("The given path is a file.");
            System.out.println("File size: " + file.length());
        } else if (file.isDirectory()) {
            System.out.println("The given path is a directory.");
            System.out.println("Files in the directory:");

            String files[] = file.list();

            for (String f : files) {
                System.out.println(f);
            }
        } else {
            System.out.println("The given path does not exist or is neither a file nor a directory.");
        }
    }
}