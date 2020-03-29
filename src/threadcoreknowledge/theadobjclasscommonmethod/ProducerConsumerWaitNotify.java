package threadcoreknowledge.theadobjclasscommonmethod;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * description: use wait notify to implement a Producer/Consumer model
 */
public class ProducerConsumerWaitNotify {
    public static void main(String[] args) {
        EventStorage eventStorage = new EventStorage();
        Producer producer = new Producer(eventStorage);
        Consumer consumer = new Consumer(eventStorage);

        new Thread(producer).start();

        new Thread(consumer).start();

    }
}

class Producer implements Runnable {
    private EventStorage storage;

    public Producer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            storage.put();
        }
    }
}

class Consumer implements Runnable {
    private EventStorage storage;

    public Consumer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            storage.take();
        }
    }
}

class EventStorage {
    private int max;
    private LinkedList<Date> storage;

    public EventStorage(){
        max = 10;
        storage = new LinkedList<>();
    }

    public synchronized void put() {
        while (storage.size() == max) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        storage.add(new Date());
        System.out.println("Storage has " + storage.size() + " stuffs");
        notify(); // wake Producer
    }

    public synchronized void take() {
        while (storage.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Stuff " + storage.poll() + " is taken, size is" + storage.size());
        notify();
    }
}


