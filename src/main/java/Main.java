import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 为了充分发挥GPU算力，需要尽可能多的将任务交给GPU执行，现在有一个任务数组，
 * 数组元素表示在这1秒内新增的任务个数且每秒都有新增任务，假设GPU最多一次执行n个任务，
 * 一次执行耗时1秒，在保证GPU不空闲情况下，最少需要多长时间执行完成
 *
 * 输入描述:
 *   第一个参数为GPU一次最多执行的任务个数，取值范围[1, 10000]
 *   第二个参数为任务数组长度，取值范围[1, 10000]
 *   第三个参数为任务数组，数字范围[1, 10000]
 * 输出描述:
 *   执行完所有任务最少需要多少秒
 *
 * 示例1：
 *   输入：
 *     3
 *     5
 *     1 2 3 4 5
 *   输出： 6
 *   说明： 一次最多执行3个任务，最少耗时6s
 *
 * 示例2：
 *   输入：
 *     4
 *     5
 *     5 4 1 1 1
 *   输出： 5
 *   说明： 一次最多执行4个任务，最少耗时5s
 *
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