package threadcoreknowledge.implementThread;

/**
 * desciption: user Runnable to creat thread
 */
public class RunnableStart implements Runnable {

    public static void main(String[] args) {
        Thread t = new Thread(new RunnableStart());
        t.start();
    }

    @Override
    public void run() {
        System.out.println("Run thread -> Runnable interface method");
    }
}
