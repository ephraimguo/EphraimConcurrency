package threadcoreknowledge.stopThread;

/**
 * description: stop a thread WITH sleep
 */
public class RightWayStopThreadWITHSleep {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            int num = 0;

            while (num <= 300 && Thread.currentThread().isInterrupted()) {
                if (num % 100 == 0) {
                    System.out.println(num + " is multiplication of 100 ");
                }

                num++;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread th = new Thread(runnable);
        th.start();
        Thread.sleep(500);
        th.interrupt();

    }
}
