package reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.WeakHashMap;

/**
 * reference
 *
 * @author rj-liang
 * @date 2021/2/26 11:44
 */
public class TestReference {

    public static void main(String[] args) {
        try {
//            testWeakReference();
//            testSoftReference();

            testHashMap();
            testWeakHashMap();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testWeakReference() {
        Object o1 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        WeakReference<Object> s = new WeakReference<>(o1, referenceQueue);

        o1 = null;
        System.out.println(s.get());
        System.gc();
        System.out.println("After Gc");
        System.out.println(s.get());

        WeakReference pollRef = null;
        //弹出对列的引弱用
        while ((pollRef = (WeakReference) referenceQueue.poll()) != null) {
            System.out.println("pollRef的内存地址:" + pollRef.toString());
        }
    }


    public static void testSoftReference() throws InterruptedException {
        Object o1 = new Object();
        SoftReference<Object> s = new SoftReference<>(o1);
        o1 = null;
        System.out.println(s.get());
        System.gc();
        System.out.println("After Gc");
        System.out.println(s.get());


        List<byte[]> list = new ArrayList<>();
        try {
            for (int i = 0; i < 1000; i++) {
                byte[] b = new byte[1024 * 1024 * 10];
                list.add(b);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception-->" + s.get()); //null
        } finally {
            System.out.println("finally-->" + s.get()); //null

        }
    }

    public static void testHashMap() {
        HashMap<String, String> map = new HashMap<String, String>();
        String key = new String("k1");
        String value = "v1";
        map.put(key, value);
        System.out.println(map);

        key = null;
        System.gc();

        System.out.println(map);
    }

    public static void testWeakHashMap() throws InterruptedException {
        WeakHashMap<String, String> map = new WeakHashMap<String, String>();
        //String key = "weak";
        // 刚开始写成了上边的代码
        //思考一下，写成上边那样会怎么样？ 那可不是引用了
        String key = new String("weak");
        String value = "map";
        map.put(key, value);
        System.out.println(map);
        //去掉强引用
        key = null;
        System.gc();
        Thread.sleep(1000);
        System.out.println(map);
    }
}
