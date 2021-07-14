package hook;

import java.lang.reflect.Method;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * HookThreadPool
 *
 * @author rj-liang
 * @date 2021/7/13 16:36
 */
public class HookThreadPool {
    private static final int CORE_POOL_SIZE = 4; //核心线程数
    private static final int MAXIMUM_POOL_SIZE = 4;    //最大线程数
    private static final int KEEP_ALIVE_TIME = 5;       //线程存活的周期

    private static final String THREAD_NAME_PREFIX = "HookHttpDnsThread-";
    private static final int THREAD_PRIORITY_BACKGROUND = 10;

    public static void hookThreadPool() {
        try {
            Class<?> httpDnsThreadPoolClass = Class.forName("hook.HttpDnsThreadPool");
            Method method = httpDnsThreadPoolClass.getMethod("setExecutorFactory", HttpDnsThreadPool.ExecutorFactory.class);
            method.invoke(httpDnsThreadPoolClass.getDeclaredConstructor().newInstance(), sExecutorFactory);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static HttpDnsThreadPool.ExecutorFactory sExecutorFactory = new HttpDnsThreadPool.ExecutorFactory() {
        @Override
        public ThreadPoolExecutor getThreadPool() {
            return new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS,
                    new LinkedBlockingQueue<Runnable>(200), sFactory) {
                {
                    allowCoreThreadTimeOut(true);
                }
            };
        }
    };

    private static final ThreadFactory sFactory = new ThreadFactory() {
        private final AtomicInteger mCount = new AtomicInteger(1);
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r, THREAD_NAME_PREFIX + mCount.getAndIncrement());
            thread.setPriority(THREAD_PRIORITY_BACKGROUND);
            return thread;
        }

    };
}
