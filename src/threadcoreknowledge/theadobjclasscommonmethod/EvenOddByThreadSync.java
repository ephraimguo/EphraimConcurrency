package threadcoreknowledge.theadobjclasscommonmethod;

/**
 * description: print even and odd alternatively by two Thread
 */
public class EvenOddByThreadSync {
    private static int count;
    private static final Object lock = new Object();

// 2 new thread
    // 1 only for odd, 1 only for even (bit calc)
    // use synchronized to communicate
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100) {
                    synchronized (lock) {
                        if ((count & 1) == 0) {
                            System.out.println(Thread.currentThread().getName() + " " + count++);
                        }
                    }
                }
            }
        }, "Even").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100) {
                    synchronized (lock) {
                        if ((count & 1) != 0) {
                            System.out.println(Thread.currentThread().getName() + " " + count++);
                        }
                    }
                }
            }
        }, "Odd").start();
    }
}
