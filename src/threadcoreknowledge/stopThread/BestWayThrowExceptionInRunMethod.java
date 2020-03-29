package threadcoreknowledge.stopThread;

import sun.lwawt.macosx.CSystemTray;

/**
 * decription: run cannot throw checked expception, only can use try/catch
 */
public class BestWayThrowExceptionInRunMethod implements Runnable{
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new BestWayThrowExceptionInRunMethod());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }

    @Override
    public void run() {
        while (true && !Thread.currentThread().isInterrupted()) {
            System.out.println("go");

            try {
                throwInMethod();
            } catch (InterruptedException e) {
                // log  ?
                // stop ?
                System.out.println("save log");
                e.printStackTrace();
            }

        }
    }

    private void throwInMethod() throws InterruptedException {
        Thread.sleep(2000);
    }

    public void aVoid() throws Exception {
        /**
         * you can throw an exception in a normal method in method signature
         */
        throw new Exception("testing");
    }
}
