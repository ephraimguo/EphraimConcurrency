package threadcoreknowledge.theadobjclasscommonmethod;


/**
 * description: 3 threads, no.1 and no.2 will be blocked first, no.3 will try to wake them
 */
public class WaitNotifyNotifyAll implements Runnable {
    private static final Object resrcA = new Object();

    @Override
    public void run() {
        synchronized (resrcA) {
            System.out.println(Thread.currentThread().getName() + ", got resrcA lock");

            try {
                System.out.println(Thread.currentThread().getName() + ", waits to start( called wait() function )");
                resrcA.wait();

                System.out.println(Thread.currentThread().getName() + ", is over");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new WaitNotifyNotifyAll());
        Thread t2 = new Thread(new WaitNotifyNotifyAll());

        Thread t3 = new Thread(() -> {
            synchronized (resrcA){
//                resrcA.notifyAll();
                resrcA.notify();
                resrcA.notify();
                System.out.println("Thread notifier notify all done");
            }

        });

        t1.start();
        t2.start();
        Thread.sleep(200);
        t3.start();

    }

}
