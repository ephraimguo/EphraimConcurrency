package threadcoreknowledge.stopThread.mistakes.volatiledemo;


/**
 * description: why volatile looks okay
 */
public class VolatileSeemsOkay implements Runnable{
    private volatile boolean cancelled = false;

    public static void main(String[] args) throws InterruptedException {
        VolatileSeemsOkay v = new VolatileSeemsOkay();
        Thread th = new Thread(v);

        th.start();
        Thread.sleep(5000);
        v.cancelled = !v.cancelled;
    }

    @Override
    public void run() {
        int num = 0;
        try {
            while (num < 10000 && !cancelled) {
                if (num % 100 == 0) {
                    System.out.println(num + " is 100 multi");
                }
                num++;
                Thread.sleep(1);

            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
