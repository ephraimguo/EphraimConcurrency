package threadcoreknowledge.stopThread.mistakes;

/**
 * description: use stop() to stop a Thread, will coz Thread stopped immediately
 * will coz dirty data
 */
public class StopMethod implements Runnable{
    public static void main(String[] args) {
        Thread th = new Thread(new StopMethod());
        th.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        th.stop();
    }

    @Override
    public void run() {
        // simulate a troop of army,
        // every troop has 10 soldier.
        // assign weapon unit -> troops
        // call the soldier to receive the weapon
        for (int i = 0; i < 5; i++) {
            System.out.println("troop " + i + " start assigning weapons");
            for (int j = 0; j < 10; j++) {
                System.out.println("soldier " + j + " got weapon");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("troop " + i + " done for assigning weapons");
        }
    }
}
