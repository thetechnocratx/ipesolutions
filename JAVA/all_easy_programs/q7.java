class GreetingThread implements Runnable {
    private String greeting;
    private int delay;

    public GreetingThread(String greeting, int delay) {
        this.greeting = greeting;
        this.delay = delay;
    }

    public void run() {
        try {
            while (true) {
                System.out.println(greeting);
                Thread.sleep(delay);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class q7 {
    public static void main(String[] args) {
        GreetingThread r1 = new GreetingThread("Good Morning", 1000);
        Thread morningThread = new Thread(r1);
        GreetingThread r2 = new GreetingThread("Good Afternoon", 3000);
        Thread afternoonThread = new Thread(r2);

        morningThread.start();
        afternoonThread.start();
    }
}