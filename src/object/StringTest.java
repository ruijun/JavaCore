package object;

/**
 * 测试值传递还是引用传递
 *
 * Created by ruijun on 17-5-5.
 */
public class StringTest {
    public static void main(String[] args) {
        int num = 5;
        foo(num);
        System.out.println(num); // 5

        StringBuffer stringBuffer = new StringBuffer("Hello");
        foo(stringBuffer);
        System.out.println(stringBuffer); // Hello

        StringBuilder stringBuilder = new StringBuilder("Hello");
        foo(stringBuilder);
        System.out.println(stringBuilder); // Hello Jim

        String device1 = "iOS";
        foo(device1);
        System.out.println(device1); // iOS

        String device2 = new String("iOS");
        foo(device2);
        System.out.println(device2); // iOS

        String s1 = "window";
        String s2 = "win" + new String("dow");
        System.out.println(s1 == s2); // false
        System.out.println(s1.equals(s2)); // true

        String s = new String("abc");
        String s3 = "abc";
        String s4 = new String("abc");

        System.out.println(s == s3.intern()); // false
        System.out.println(s == s4.intern()); // false
        System.out.println(s3 == s4.intern()); // true

        String hello = "hello";
        String hel = "hel";
        String lo = "lo";

        System.out.println(hello == "hel" + "lo"); // true
        System.out.println(hello == "hel" + lo); // false
    }

    private static void foo(int value) {
        value += 2;
    }

    private static void foo(StringBuffer buffer) {
        buffer = new StringBuffer("");
        buffer.append(" Jim");
    }

    private static void foo(StringBuilder stringBuilder) {
        stringBuilder.append(" Jim");
    }

    private static void foo(String value) {
        value = "Android";
    }
}
