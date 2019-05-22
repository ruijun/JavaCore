package object.init;

/**
 * Enter the description
 *
 * @autor rj-liang
 * @date 17-7-21 上午9:33
 */
public class TestOrder {

    /**
     * 输出顺序
     *
     * Test--A
     * 静态初始化块
     * Test--B
     *
     */

    // 静态变量
    public static TestA a = new TestA();

    // 静态初始化块
    static {
        System.out.println("静态初始化块");
    }

    // 静态变量
    public static TestB b = new TestB();

    public static void main(String[] args) {
        new TestOrder();
    }
}

class TestA {
    public TestA() {
        System.out.println("Test--A");
    }
}

class TestB {
    public TestB() {
        System.out.println("Test--B");
    }
}