package thread.producer_consumer;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 交替打印奇偶数
 *
 * @autor rj-liang
 * @date 2021/8/15 12:34 下午
 */
public class PrintfOddEvent3 {
    private static int count;
    private static volatile boolean flag;
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(new EventRunnable(), "偶数线程").start();
        new Thread(new OddRunnable(), "奇数线程").start();
    }

    private static class OddRunnable implements Runnable {

        @Override
        public void run() {
            while (count <= 100) {
                if (flag) {
                    try {
                        lock.lock();
                        System.out.println(Thread.currentThread().getName() + ":" + count++);
                        flag = false;
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }
    }

    private static class EventRunnable implements Runnable {

        @Override
        public void run() {
            while (count <= 100) {
                if (!flag) {
                    try {
                        lock.lock();
                        System.out.println(Thread.currentThread().getName() + ":" + count++);
                        flag = true;
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }
    }
}
