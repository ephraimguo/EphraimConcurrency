package synchromized;

/**
 * description: Object lock
 */
public class SychronizedObjectCodeBlock2 implements Runnable{
    static SychronizedObjectCodeBlock2 instance = new SychronizedObjectCodeBlock2();
    Object lock1 = new Object();
    Object lock2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);

        t1.start();
        t2.start();
        /*try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        while (t1.isAlive() || t2.isAlive()) {

        }
        System.out.println("finished");

    }

    @Override
    public void run() {
        synchronized (lock1){
            System.out.println("LOCK1 I am object lock code block, name" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("LOCK1 I am object lock code block, name" + Thread.currentThread().getName() + " is FINISHED");
        }

        synchronized (lock2){
            System.out.println("LOCK2 I am object lock code block, name" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("LOCK2 I am object lock code block, name" + Thread.currentThread().getName() + " is FINISHED");
        }

        /*System.out.println("I am object lock code block, name" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("I am object lock code block, name" + Thread.currentThread().getName() + " is FINISHED");*/

    }
}
