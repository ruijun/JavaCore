package thread.sync;

/**
 * thread.sync
 *
 * @author rj-liang
 * @date 2021/7/13 14:29
 */
public class SynchronizedDemo {
    public synchronized void doSth(){
        System.out.println("Hello World");
    }

    public void doSth1(){
        synchronized (SynchronizedDemo.class){
            System.out.println("Hello World");
        }
    }
}
