class TenException extends RuntimeException {
    TenException(String s) {
        super(s);
    }
}

public class q6 {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("No arguments provided!");
            return;
        }
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        System.out.println(x + y);
        if (x + y == 10) {
            throw new TenException("INVALID INPUT!!!");
        }
    }
}
