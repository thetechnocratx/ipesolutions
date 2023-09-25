class zeroException extends RuntimeException {
    zeroException(String s) {
        super(s);
    }
}

public class q5 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No arguments provided!");
            return;
        }
        String s = args[0];
        char c = s.charAt(0);
        System.out.println(c);
        if (c == '0') {
            throw new zeroException("INVALID INPUT!!!");
        }
    }
}

