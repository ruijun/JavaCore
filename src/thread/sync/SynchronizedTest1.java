package thread.sync;

/**
 * thread.sync
 *
 *
 * @author rj-liang
 * @date 2020/6/28 15:34
 */
public class SynchronizedTest1 implements Runnable{
    @Override
    public synchronized void run() {
        for(int i = 0 ; i < 3 ; i++){
            System.out.println(Thread.currentThread().getName() + "run......");
        }
    }

    public static void main(String[] args) {
        Runnable synchronizeRunnable = new SynchronizedTest1();
        for(int i = 0 ; i < 5 ; i++){
            new Thread(synchronizeRunnable,"Thread_" + i).start();
        }
    }
}
