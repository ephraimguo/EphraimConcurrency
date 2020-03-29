package threadcoreknowledge.sixstates;

import com.sun.deploy.net.proxy.ProxyUnavailableException;

/**
 * description: Blocked, Waiting, TimedWaiting
 *              these statuses are easier for Thread to experience
 */
public class BlockedWaitingTimedWaiting implements Runnable{
    public static void main(String[] args) {
        BlockedWaitingTimedWaiting runnable = new BlockedWaitingTimedWaiting();

        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread th1 = new Thread(runnable);
        Thread th2 = new Thread(runnable);

        th1.start();
        th2.start();

        System.out.println(th1.getState()); // TIMED_WAITING
        System.out.println(th2.getState()); // BLOCKED

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(th1.getState()); // WAITING

    }

    @Override
    public void run() {
        syn();

    }

    private synchronized void syn() {
        try {
            Thread.sleep(1000);
            wait();

        } catch (InterruptedException e) {
            e.printStackTrace();

        }

    }
}
