import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Anchor
 */
public class Main {
    private static final List<Integer> LIST = new ArrayList(100);
    private final static Object FULL = new Object();
    private final static Object EMPTY = new Object();
    private final static int CAPACITY = 10;
    private static volatile int size = 0;

    public static void main(String[] args) throws InterruptedException {
        new Producer().start();
        Thread.sleep(TimeUnit.SECONDS.toSeconds(1));
        new Consumer().start();
        int[][] a = {{1,2,3},{1,2,3},{1,2,3}};

    }

    static class Producer extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                synchronized (FULL) {
                    if (LIST.size() > CAPACITY) {
                        try {
                            FULL.wait();
                            EMPTY.notify();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    LIST.add(i);
                    size++;
                }
            }
        }
    }

    static class Consumer extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                synchronized (EMPTY) {
                    if (LIST.size() == 0) {
                        try {
                            EMPTY.wait();
                            FULL.notify();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("consume item: " + LIST.get(size - 1));
                    size--;
                }
            }
        }
    }
}