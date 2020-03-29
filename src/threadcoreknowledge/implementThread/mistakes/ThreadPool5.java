package threadcoreknowledge.implementThread.mistakes;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * using Thread Pool to creat new Threads
 */
public class ThreadPool5 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 1; i < 1000; i++) {
            executorService.submit(new Task());
        }
    }
}

class Task implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(500);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName());
    }
}
