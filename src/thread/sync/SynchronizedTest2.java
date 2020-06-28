package thread.sync;

/**
 * thread.sync
 *
 * @author rj-liang
 * @date 2020/6/28 15:34
 */
public class SynchronizedTest2 extends Thread {
    private String lock;
    private String name;

    public SynchronizedTest2(String name, String lock) {
        this.name = name;
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            for (int i = 0; i < 3; i++) {
                System.out.println(name + " run......");
            }
        }
    }

    public static void main(String[] args) {
        String lock = new String("test");
        for (int i = 0; i < 5; i++) {
            new SynchronizedTest2("ThreadTest_" + i, lock).start();
        }
    }
}
