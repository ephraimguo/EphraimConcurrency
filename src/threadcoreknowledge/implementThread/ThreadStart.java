package threadcoreknowledge.implementThread;

/**
 * description: use Thread class to run a thread
 */
public class ThreadStart extends Thread{
    public static void main(String[] args) {
        Thread t = new ThreadStart();
        t.start();

    }

    @Override
    public void run() {
        System.out.println("Run a thread -> by class Thread");
    }
}
