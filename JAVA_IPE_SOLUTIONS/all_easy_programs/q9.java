import java.util.Scanner;

class q9 extends Thread {
    public void run() {
        if (Thread.currentThread().getName().equals("AalphaThread")) {
            System.out.println("Alphabets from a to z");
            for (char i = 'a'; i <= 'z'; i++) {

                System.out.print(i + " ");

            }
        }

        if (Thread.currentThread().getName().equals("numberThread")) {
            System.out.println("Numbers from 1 to 100");
            for (int i = 1; i <= 100; i++) {

                System.out.print(i + " ");

            }
        }
    }
}

class runq9 {
    public static void main(String[] args) throws Exception {
        q9 t1 = new q9();
        t1.setName("AalphaThread");
        t1.start();

        t1.join();

        q9 t2 = new q9();
        t2.setName("numberThread");
        t2.start();
    }
}