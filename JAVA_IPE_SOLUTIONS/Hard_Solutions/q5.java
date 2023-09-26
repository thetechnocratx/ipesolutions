// Write a complete program to accept N integer numbers from the command line. Raise and
// handle exceptions for following cases : - when a number is –ve
// - when a number is evenly divisible by 10
// - when a number is greater than 1000 and less than 2000
// - when a number is greater than 7000
// Skip the number if an exception is raised for it, otherwise add it to find total sum

class invalidException extends RuntimeException {
    invalidException(String s) {
        super(s);
    }
}

public class q5 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i < args.length; i++) {
            int n = Integer.parseInt(args[i]);

            if (n < 0) {
                try {
                    throw new invalidException("Negative value");
                } catch (invalidException e) {
                    continue;
                }
            }

            if (n % 10 == 0) {
                try {
                    throw new invalidException("Divisible by 10");
                } catch (invalidException e) {
                    continue;
                }

            }

            if (n > 1000 && n < 2000) {
                try {
                    throw new invalidException("number is greater than 1000 and less than 2000");
                } catch (invalidException e) {
                    continue;
                }

            }

            if (n > 7000) {
                try {
                    throw new invalidException("number is greater than 7000");
                } catch (invalidException e) {
                    continue;
                }

            } else
                sum = sum + n;
        }
        System.out.println("Sum = " + sum);
    }
}
