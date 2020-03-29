package threadcoreknowledge.startThread;

/**
 * description: compare start() and run()
 */
public class StartAndRun {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName());
        };

        runnable.run(); // main

        new Thread(runnable).start(); // thread-0
    }


}
