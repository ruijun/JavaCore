package hook;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * HttpDnsThreadPool
 *
 * @author rj-liang
 * @date 2021/7/13 16:34
 */
public class HttpDnsThreadPool {
    private final static String TAG = "HttpDnsThreadPool";
    private static final int CORE_POOL_SIZE = 4; //核心线程数
    private static final int MAXIMUM_POOL_SIZE = 4;    //最大线程数
    private static final int KEEP_ALIVE_TIME = 5;       //线程存活的周期
    private static final String THREAD_NAME_PREFIX = "HttpDnsThread-";
    private static final int THREAD_PRIORITY_BACKGROUND = 10;


    private static final ThreadFactory sFactory = new ThreadFactory() {
        private final AtomicInteger mCount = new AtomicInteger(1);
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r, THREAD_NAME_PREFIX + mCount.getAndIncrement());
            thread.setPriority(THREAD_PRIORITY_BACKGROUND);
            return thread;
        }

    };
    private static ThreadPoolExecutor sThreadPool;

    public static void execute(Runnable runnable) {
        if (runnable != null) {
            getThreadPoolExecutor().execute(runnable);
        }
    }

    public static Future submit(Runnable runnable) {
        if (runnable != null) {
            return getThreadPoolExecutor().submit(runnable);
        }
        return null;
    }

    public static ThreadPoolExecutor getThreadPoolExecutor() {
        if (sThreadPool == null) {
            synchronized (HttpDnsThreadPool.class) {
                if (sThreadPool == null) {
                    sThreadPool = sExecutorFactory.getThreadPool();
                }
            }
        }
        return sThreadPool;
    }

    private static synchronized void setExecutorFactory(ExecutorFactory sExecutorFactory) {
        HttpDnsThreadPool.sExecutorFactory = sExecutorFactory;
    }

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
