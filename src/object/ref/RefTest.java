package object.ref;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * object.ref
 *
 * @author rj-liang
 * @date 2021/1/26 10:53
 */
public class RefTest {

    public static void main(String[] args) {
        testRef2();
    }

    private static void testRef() {
        //user为强引用
        User user = new User("张三", 18);
        //创建弱引用并关联引用队列
        ReferenceQueue<User> queue = new ReferenceQueue<>();
        WeakReference<User> weakReference = new WeakReference<>(user, queue);

        //置空强引用，触发GC
        user = null;
        Runtime.getRuntime().gc();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //强制系统回收已经没有强引用的对象
        System.runFinalization();

        WeakReference pollRef = null;
        //弹出对列的引弱用
        while ((pollRef = (WeakReference) queue.poll()) != null) {
            System.out.println("pollRef的内存地址:" + pollRef.toString());
        }            System.out.println("pollRef等于weakReference？:" + weakReference.equals(pollRef));
    }

    private static void testRef2() {
        // 检测弱引用指向的对象是否存活来判断虚拟机是否真的执行了GC
        WeakReference<Object> sentinelRef = new WeakReference<>(new Object());
        triggerGc();
        if (sentinelRef.get() != null) {
            // System ignored our gc request, we will retry later.
            System.out.println("sentinelRef.get() != null");
        } else {
            System.out.println("sentinelRef.get() == null");
        }
    }

    private static void triggerGc() {
        System.out.println("triggering gc...");
        Runtime.getRuntime().gc();
        Runtime.getRuntime().runFinalization();
        System.out.println("gc was triggered.");

    }
}
