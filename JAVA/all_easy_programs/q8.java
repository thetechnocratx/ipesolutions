class MyThread extends Thread {
    public void run() {
        if (Thread.currentThread().getName().equals("odd")) {
            System.out.println("Odd Numbers....");
            for (int i = 1; i <= 100; i += 2) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        if (Thread.currentThread().getName().equals("even")) {
            System.out.println("even Numbers....");
            for (int i = 2; i <= 100; i += 2) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }
}

public class q8 {
    public static void main(String[] args) throws Exception {
        MyThread t1 = new MyThread();
        t1.setName("odd");

        MyThread t2 = new MyThread();
        t2.setName("even");

        t1.start();
        t1.join();
        t2.start();

    }
}