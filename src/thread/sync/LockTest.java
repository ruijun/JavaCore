package thread.sync;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2019/5/20.
 */
public class LockTest {
    private List<Integer> arrayList = new ArrayList<Integer>();
    private Lock lock = new ReentrantLock();    //注意这个地方

    public static void main(String[] args) {
        final LockTest test = new LockTest();

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                test.insert(Thread.currentThread());
            }
        }, "ThreadA");

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                test.insert(Thread.currentThread());
            }
        }, "ThreadB");


        threadA.start();
        threadB.start();

    }

    public void insert(Thread thread) {
        try {
            lock.lockInterruptibly();
//            boolean result = lock.tryLock(1000, TimeUnit.MILLISECONDS);
//            System.out.printf("tryLock->" + result);
            System.out.println(thread.getName() + "得到了锁");
            for (int i = 0; i < 5; i++) {
                arrayList.add(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(thread.getName() + "释放了锁");
            lock.unlock();
        }
    }
}
