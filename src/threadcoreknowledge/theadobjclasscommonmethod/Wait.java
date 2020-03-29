package threadcoreknowledge.theadobjclasscommonmethod;

/**
 * description: wait and notify method demo
 * 1. sequence of code
 * 2. wait release lock
 */
public class Wait {
    public static Object object = new Object();

    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();
        Thread3 t3 = new Thread3();

        t1.start();
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();

        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t3.start();

    }

    static class Thread1 extends Thread {

        @Override
        public void run() {
            synchronized (object) {
                System.out.println(Thread.currentThread().getName() + " thread 1 is running");

                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Thread " + Thread.currentThread().getName() + " get the lock");

                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Thread " + Thread.currentThread().getName() + " get the lock again");
            }

        }
    }

    static class Thread2 extends Thread {

        @Override
        public void run() {
            synchronized (object) {
                object.notify();
                System.out.println("Thread " + Thread.currentThread().getName() + " invoked notify");

            }

        }
    }

    static class Thread3 extends Thread {

        @Override
        public void run() {
            synchronized (object) {
                object.notify();
                System.out.println("Thread " + Thread.currentThread().getName() + " invoked notify");

            }

        }
    }

}
