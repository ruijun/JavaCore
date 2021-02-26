package classloader;

/**
 * Enter the description
 *
 * @autor rj-liang
 * @date 17-5-17 上午10:58
 */
public class Test {

    static {
        System.out.println("静态初始化块执行了！");
    }

    public static void main(String[] args) {
        System.out.println("Hello Word!!");
    }
}
