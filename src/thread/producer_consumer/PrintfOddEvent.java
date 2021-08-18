package thread.producer_consumer;

/**
 * 交替打印奇偶数
 *
 * @autor rj-liang
 * @date 2021/8/15 12:34 下午
 */
public class PrintfOddEvent {
    private static int count;
    private static Object lock = new Object();

    public static void main(String[] args) {
        OddThread oddThread = new OddThread();
        oddThread.setName("奇数线程");
        EventThread eventThread = new EventThread();
        eventThread.setName("偶数线程");
        oddThread.start();
        eventThread.start();
    }

    private static class OddThread extends Thread {
        @Override
        public void run() {
            while (count < 100) {
                synchronized (lock) {
                    if (count % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + count++);
                    }
                }
            }
        }
    }

    private static class EventThread extends Thread {
        @Override
        public void run() {
            while (count < 100) {
                synchronized (lock) {
                    if (count % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + count++);
                    }
                }
            }
        }
    }
}
