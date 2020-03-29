package threadcoreknowledge.theadobjclasscommonmethod;

/**
 * description: prove wait only release current lock
 */
public class WaitNotifyRlsOwnMonitor {
    private static volatile Object r1 = new Object();
    private static volatile Object r2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (r1) {
                    System.out.println("Thread A got r1 lock");

                    synchronized (r2) {
                        System.out.println("Thread A r2 lock");

                        try {
                            System.out.println("Thread A rls r1 lock");
                            r1.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }

            synchronized (r1) {
                System.out.println("Thread 2 got r1 lock");

                System.out.println("Thread 2 is trying to get r2 lock");
                synchronized (r2) {
                    System.out.println("Thread2 got r2 lock");
                }
            }

        });

        thread1.start();
        thread2.start();


    }
}

