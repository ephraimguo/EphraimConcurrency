package threadcoreknowledge.stopThread.mistakes.volatiledemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * description: when Thread is in Blocked status, volatile is not able to stop thread
 * Producer's speed is fast, while consumer's speed is very slow
 * Once the blocking queue is full, Producer will be blocked and wait for consuming
 *
 * @Fix use interrupt to change volatile
 */
public class VolatileFixes {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue storage = new ArrayBlockingQueue<>(10);

        VolatileFixes body = new VolatileFixes();

        Producer producer = body.new Producer(storage);
        Thread pThread = new Thread(producer);
        pThread.start();
        Thread.sleep(1000);

        Consumer consumer = body.new Consumer(storage);
        while (consumer.needMoreNums()) {
            System.out.println(consumer.storage.take() + " is consumed");
            Thread.sleep(100);

        }

        System.out.println("Consumer does not need more data");
        // then producer will be stopped
        // producer.cancelled = true;

        pThread.interrupt();
        System.out.println(producer.cancelled);

    }

    class Producer implements Runnable {
        public volatile boolean cancelled = false;
        BlockingQueue storage;

        public Producer(BlockingQueue storage) {
            this.storage = storage;
        }

        @Override
        public void run() {
            int num = 0;
            try {
                while (num < 10000 && !Thread.currentThread().isInterrupted()) {
                    if (num % 100 == 0) {
                        System.out.println(num + " is 100 multi");
                        storage.put(num);
                    }
                    num++;
                    Thread.sleep(1);
                }

            } catch (Exception e) {
                e.printStackTrace();

            } finally {
                System.out.println("Producer stopped !!!");
            }
        }
    }

    class Consumer {
        BlockingQueue storage;

        public Consumer(BlockingQueue storage) {
            this.storage = storage;
        }

        public boolean needMoreNums() {
            if (Math.random() > 0.95) {
                return false;
            }

            return true;
        }
    }
}



