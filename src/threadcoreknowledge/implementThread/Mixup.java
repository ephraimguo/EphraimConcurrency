package threadcoreknowledge.implementThread;

/**
 * description: user Runnable and Thread at same time
 */
public class Mixup {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("I am from runnable");
            }
        }) {
            @Override
            public void run() {
                System.out.println("I am from Thread");
            }
        }.start();
    }
}
