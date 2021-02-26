package string;

/**
 * Created by Administrator on 2019/5/22.
 */
public class StringTest {
    public static void main(String[] args) {

        /**
         * (1)String s = new String("abc"); 这句,创建了两个对象..其内容都是"abc".注意,s不是对象,只是引用.只有new生成的才是对象.
         * 创建的流程是,首先括号里的"abc"先到String pool里看有没"abc"这个对象,没有则在pool里创建这个对象..所以这里就在pool创建了一个"abc"对象.
         * 然后通过new语句又创建了一个"abc"对象..而这个对象是放在内存的堆里. .这里的s指向堆里的对象.
         * (2)String s1 = "abc"; 这条语句,s1当然还是引用.没啥可说的.后面的"abc".其实就是上面括号里的"abc".执行的是相同的操作.即 在pool里查找有没"abc"这个对象.
         * 没有则创建一个...很显然,第一条语句在pool里已经创建了一个"abc".所以这条语句没有创建对象,s1指向的是pool中的"abc"
         * (3)String s2 = new String("abc"); 这条语句,其实和第一条是一样的,但是,因为第一条已经在pool中创建了"abc"这个对象,所以,这条语句创建了一个对象.
         * s2指向的是堆里的"abc".注意,虽然内容都是"abc",s与s2表示的是不同的对象
         * (4)接下来就很好说了.下面的三个==判断.(注意,==永远是判断内存地址是否相等) s与s1,一个指向堆里的对象,一个指向pool里的.很明显是不同的对象.
         * s与s2.上面说了,虽然都是指向堆里的对象,内容也是"abc",但是也不是相同的对象.s1与s2.一个指向pool,一个指向堆.也不是相同的对象.所以三个都返回false.
         *
         */

        String s = new String("abc");
        String s1 = "abc";
        String s2 = new String("abc");

//        System.out.println(s == s1);
//        System.out.println(s == s2);
//        System.out.println(s1 == s2);

        testIntern();
    }

    /**
     * String的 intern()方法就是扩充常量池的 一个方法；当一个String实例str调用intern()方法时，Java 查找常量池中 是否有相同Unicode的字符串常量，
     * 如果有，则返回其的引用，如果没有，则在常 量池中增加一个Unicode等于str的字符串并返回它的引用
     */
    private static void testIntern() {
        String s0 = "kvill";
        String s1 = new String("kvill");
        String s2 = new String("kvill");
        System.out.println(s0 == s1);
        System.out.println("**********");
        s1.intern();
        s2 = s2.intern(); //把常量池中“kvill”的引用赋给s2
        System.out.println(s0 == s1);
        System.out.println(s0 == s1.intern());
        System.out.println(s0 == s2);
    }
}
