package threadcoreknowledge.theadobjclasscommonmethod;

/**
 * description: print even and odd alternatively by two Thread
 */
public class EvenOddByThreadWaitNotify {
    private static int count = 0;
    private static Object lock = new Object();

    public static void main(String[] args) {
        AlterRunner runner = new AlterRunner();
        Thread thread1 = new Thread(runner);
        Thread thread2 = new Thread(runner);

        thread1.start();
        thread2.start();

    }
    // 1. get the lock, then print
    // 2. after printing, wake others, then wait()
    static class AlterRunner implements Runnable {
        @Override
        public void run() {
            while(count <= 100) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + " " + count++);
                    lock.notify();
                    if (count <= 100) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
