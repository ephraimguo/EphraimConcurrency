package threadcoreknowledge.stopThread;


/**
 * description: invoke Thread.currentThread().interrupt() to resume interrupted status,
 * for the next step of executions to be aware of the interruption
 *
 */
public class ResumeThreadFromInterrupt implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        Thread th = new Thread(new ResumeThreadFromInterrupt());
        th.start();
        th.sleep(2000);
        th.interrupt();
    }

    private void reInterrupt() {
        try {
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();

        }
    }

    @Override
    public void run() {
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted");
                break;
            }

            System.out.println("go");
            reInterrupt();
        }
    }
}
