package threadcoreknowledge.startThread;

/**
 * description: cannot invoke start() twice
 */
public class CantStartTwice {
    public static void main(String[] args) {
        Thread th = new Thread();
        th.start();
        th.start();

    }
}
