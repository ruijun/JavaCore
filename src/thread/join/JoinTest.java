package thread.join;

/**
 * Created by Administrator on 2019/5/20.
 */
public class JoinTest {
    public static void main(String[] args) {
        Thread thread = new Thread(new JoinDemo());
        thread.start();
        System.out.println(Thread.currentThread().getName() + "==>" + thread.getState());

        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "第" + i + "次执行！");
            if (i >= 2)
                try {
                    // t1线程合并到主线程中，主线程停止执行过程，转而执行t1线程，直到t1执行完毕后继续。
//                    thread.join();
                    Thread.yield();
                    System.out.println(Thread.currentThread().getName() + "==>" + thread.getState());
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
    }
}

class JoinDemo implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "==>" + Thread.currentThread().getState());
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "第" + i + "次执行！");
        }
    }
}
