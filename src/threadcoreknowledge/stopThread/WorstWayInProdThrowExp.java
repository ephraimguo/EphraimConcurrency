package threadcoreknowledge.stopThread;

/**
 * description: catch InterruptedException and throw in from the method signature
 *              and then will be forced to try catch in run() method
 */
public class WorstWayInProdThrowExp implements Runnable{
    public static void main(String[] args) throws InterruptedException {
        Thread th = new Thread(new WorstWayInProdThrowExp());

        th.start();
        Thread.sleep(1000);
        th.interrupt();
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("go");
            throwInMethod();
        }
    }

    private void throwInMethod() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
