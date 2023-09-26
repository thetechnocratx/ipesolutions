//  Write an application that searches through its command-line argument. If an argument is 
// found that does not begin with and upper case letter, display error message and terminate.

class caseSensitiveException extends RuntimeException {
    caseSensitiveException(String s) {
        super(s);
    }
}

public class q4 {
    public static void main(String[] args) {
        String s = args[0];
        char c = s.charAt(0);
        System.out.println(c);

        if (!(c >= 65 && c <= 90)) {
            throw new caseSensitiveException("INVALID UNPUT!!!");
        }

    }
}
