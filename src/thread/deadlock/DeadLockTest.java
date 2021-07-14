package thread.deadlock;

/**
 * 死锁
 *
 *
 * @author rj-liang
 * @date 2021/7/13 10:37
 */
public class DeadLockTest {
    public static final String LOCK_1 = "lock1";
    public static final String LOCK_2 = "lock2";

    public static void main(String[] args) {
        testDeadLock();
        solveDeadLock();
    }

    /**
     * 造成死锁的原因可以概括成三句话:
     * 1当前线程拥有其他线程需要的资源
     * 2当前线程等待其他线程已拥有的资源
     * 3都不放弃自己拥有的资源
     */
    private static void testDeadLock() {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        synchronized (LOCK_1) {
                            System.out.println(Thread.currentThread().getName() + " 锁住 lock1");
                            Thread.sleep(1000);
                            synchronized (LOCK_2) {
                                System.out.println(Thread.currentThread().getName() + " 锁住 lock2");
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "ThreadA");

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        synchronized (LOCK_2) {
                            System.out.println(Thread.currentThread().getName() + " 锁住 lock2");
                            Thread.sleep(1000);
                            synchronized (LOCK_1) {
                                System.out.println(Thread.currentThread().getName() + " 锁住 lock1");
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "ThreadB");

        threadA.start();
        threadB.start();
    }

    /**
     * 死锁预防
     * 1以确定的顺序获得锁
     * 2超时放弃
     */
    private static void solveDeadLock() {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        synchronized (LOCK_1) {
                            System.out.println(Thread.currentThread().getName() + " 锁住 lock1");
                            Thread.sleep(1000);
                            synchronized (LOCK_2) {
                                System.out.println(Thread.currentThread().getName() + " 锁住 lock2");
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "ThreadA");

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        synchronized (LOCK_1) {
                            System.out.println(Thread.currentThread().getName() + " 锁住 lock1");
                            Thread.sleep(1000);
                            synchronized (LOCK_2) {
                                System.out.println(Thread.currentThread().getName() + " 锁住 lock2");
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "ThreadB");

        threadA.start();
        threadB.start();
    }
}
