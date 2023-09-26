/*
Write a program to create two threads, one thread will check whether given number is prime or not and second thread will print prime numbers
between 0 to 100
*/

import java.util.Scanner;

class QB152 extends Thread {
    int n;

    QB152() {

    }

    QB152(int n) {
        this.n = n;
    }

    public void run() {
        if (Thread.currentThread().getName().equals("checker")) {
            boolean flag = true;
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    flag = false;
                    System.out.println(n + " is not a prime number");
                    break;
                }
            }
            if (flag) {
                System.out.println(n + " is prime number");
            }
        }

        if (Thread.currentThread().getName().equals("printer")) {
            boolean flag = true;
            for (int j = 2; j <= 100; j++) {
                flag = true;
                for (int i = 2; i < j; i++) {
                    if (j % i == 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    System.out.println(j + " ");
                }
            }

        }
    }
}

class runQB152 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number");
        int n = sc.nextInt();

        QB152 t1 = new QB152(n);
        t1.setName("checker");
        t1.start();

        t1.join();

        QB152 t2 = new QB152();
        t2.setName("printer");
        t2.start();
    }
}