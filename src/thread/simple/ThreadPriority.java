package thread.simple;

/**
 * thread.simple
 *
 * @author rj-liang
 * @date 2020/6/28 17:21
 */
public class ThreadPriority {
    public static void main(String[] args) {
        ThreadPriority thread=new ThreadPriority();
        Thread t1 = thread.new MyThread1();
        Thread t2 = new Thread(thread.new MyRunnable());
        t1.setPriority(10);
        t2.setPriority(1);

        t2.start();
        t1.start();
    }

    class MyThread1 extends Thread {
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("线程1第" + i + "次执行！");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class MyRunnable implements Runnable {
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("线程2第" + i + "次执行！");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
