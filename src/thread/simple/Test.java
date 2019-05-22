package thread.simple;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by Administrator on 2019/5/20.
 */
public class Test {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        Thread thread = new Thread(new Task());
        thread.start();

        MyCallable callable = new MyCallable();
        FutureTask<Integer> task = new FutureTask<>(callable);
        new Thread(task, "有返回值的线程").start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread() + "-->" + i);
        }
    }
}

class Task implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread() + "-->" + i);
        }
    }
}

class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int i = 0;
        for (; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
        return i;
    }
}
