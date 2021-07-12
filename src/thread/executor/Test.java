package thread.executor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * thread.executor
 *
 * @author rj-liang
 * @date 2021/6/24 11:16
 */
public class Test {
    private static final int CORE_POOL_SIZE = 4; //核心线程数
    private static final int MAXIMUM_POOL_SIZE = 4;    //最大线程数
    private static final int KEEP_ALIVE_TIME = 5;       //线程存活的周期
    private static final String THREAD_NAME_PREFIX = "HttpDnsThread-";

    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 1000; i++) {
            final int index = i;
            try {
                Thread.sleep(index * 100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(index + "--->" + Thread.currentThread().getName());
                }
            });
        }
        cachedThreadPool.shutdown();

    }

    private static final ThreadFactory sFactory = new ThreadFactory() {
        private final AtomicInteger mCount = new AtomicInteger(1);
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r, THREAD_NAME_PREFIX + mCount.getAndIncrement());
            thread.setPriority(10);
            return thread;
        }

    };

    private static ExecutorFactory sExecutorFactory = new ExecutorFactory() {
        @Override
        public ThreadPoolExecutor getThreadPool() {
            return new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS,
                    new LinkedBlockingQueue<Runnable>(), sFactory) {
                {
                    allowCoreThreadTimeOut(true);
                }
            };
        }
    };

    public interface ExecutorFactory {
        ThreadPoolExecutor getThreadPool();
    }

}
