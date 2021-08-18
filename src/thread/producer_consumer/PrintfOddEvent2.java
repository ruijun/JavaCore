package thread.producer_consumer;

/**
 * 交替打印奇偶数
 *
 * @autor rj-liang
 * @date 2021/8/15 12:34 下午
 */
public class PrintfOddEvent2 {
    private static int count;
    private static Object lock = new Object();

    public static void main(String[] args) {
        new Thread(new PrinterRunnable(), "偶数线程，").start();
        new Thread(new PrinterRunnable(), "奇数线程，").start();
    }

    private static class PrinterRunnable implements Runnable {

        @Override
        public void run() {
            while (count <= 100) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + ":" + count++);
                    lock.notify();
                    if (count <= 100) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
