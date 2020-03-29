package threadcoreknowledge.sixstates;

/**
 * description: New, Runnable, Terminated status
 *              these statuses are easier for Thread to experience
 */
public class NewRunnableTerminated implements Runnable{
    public static void main(String[] args) {
        Thread thread = new Thread(new NewRunnableTerminated());

        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());

        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(thread.getState());

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread.getState());

    }

    @Override
    public void run() {
        for (int i = 0; i < 1000 ; i++) {
            System.out.println(i);

        }

    }
}
