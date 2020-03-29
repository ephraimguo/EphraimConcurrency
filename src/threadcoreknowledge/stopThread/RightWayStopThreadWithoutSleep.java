package threadcoreknowledge.stopThread;

/**
 * description: run withoout sleep and wait
 */
public class RightWayStopThreadWithoutSleep implements Runnable{
    public static void main(String[] args) throws InterruptedException {
        Thread th = new Thread(new RightWayStopThreadWithoutSleep());
        th.start();
        Thread.sleep(500);
        th.interrupt(); // thread will not stopped -> need check isInterrupted()

    }

    @Override
    public void run() {
        int num = 0;
        while (
                !Thread.currentThread().isInterrupted()
                         &&
                        num < Integer.MAX_VALUE / 2) {
            if (num % 10000 == 0) {
                System.out.println(num + " is magnification of 10000");
            }
            num++;
        }
        System.out.println("it is over");

    }
}
