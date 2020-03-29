package threadcoreknowledge.stopThread;

/**
 * description : if put try...catch... block in while, interrupt will lose function
 *
 */
public class CantInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () ->{
            int num = 0;
            while (num <= 10000) {
                if (num % 100 == 0) {
                    System.out.println(num + " is multiplication of 100");
                }

                num++;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread th = new Thread(runnable);
        th.start();
        Thread.sleep(5000);
        th.interrupt();
    }

}
