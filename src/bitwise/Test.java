package bitwise;

/**
 * 位运算测试
 *
 * @autor rj-liang
 * @date 2017/7/23 上午10:05
 */
public class Test {


    public static void main(String[] args) {
        swap();
        System.out.println("isOddNumber: " + isOddNumber(1));
    }

    /**
     * 交换两个数
     */
    public static void swap(){
        int a = 10;
        int b = 5;

        a = a ^ b;
        b = b ^ a;
        a = a ^ b;

        System.out.println("a= " + a + " " + "b= " + b);
    }

    public static boolean isOddNumber(int num) {
        // a&1 = 0偶数
        return (num & 1) == 1;
    }
}
