class negativeException extends RuntimeException {
    negativeException(String s) {
        super(s);
    }
}

public class q4 {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            char c = s.charAt(0);
            System.out.println(c);
            if (c == '-') {
                throw new negativeException("INVALID UNPUT!!!");
            }
        }

    }
}
