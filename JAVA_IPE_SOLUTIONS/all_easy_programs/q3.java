import java.util.Scanner;

class MyException extends RuntimeException {
    MyException(String s) {
        super(s);
    }
}

class ExceptionDemo {
    void compute(int a) {
        if (a % 7 == 0 && a % 5 != 0) {
            throw new MyException("Entry Error !!!");
        } else {
            System.out.println("Valid Input");
        }
    }
}

class q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExceptionDemo ob = new ExceptionDemo();
        System.out.println("Enter any integer input");
        int n = sc.nextInt();

        ob.compute(n);
    }
}
