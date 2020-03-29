package threadcoreknowledge.stopThread;

/**
 * description:  stop thread with sleep && sleep in every iteration
 */
public class RightWayStopThreadWITHSleepEveryIteration {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            int num = 0;
            try {
                while (num <= 10000 && !Thread.currentThread().isInterrupted()) {
                    if (num % 100 == 0) {
                        System.out.println(num + " is multiplication of 100" );
                    }

                    Thread.sleep(10);
                    num++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread th = new Thread(runnable);
        th.start();
        Thread.sleep(10000);
        th.interrupt();

    }
}
