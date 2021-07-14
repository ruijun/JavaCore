package hook;

/**
 * hook
 *
 * @author rj-liang
 * @date 2021/7/13 17:01
 */
public class TestHook {
    public static void main(String[] args) {
        HookThreadPool.hookThreadPool();

        HttpDnsThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("currentThread->" + Thread.currentThread().getName());
                System.out.printf("HttpDnsThreadPool run-->");
            }
        });


    }
}
