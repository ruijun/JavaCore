package leetcode.reverse;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * https://leetcode-cn.com/problems/reverse-integer/
 * https://leetcode-cn.com/problems/reverse-integer/solution/tu-jie-7-zheng-shu-fan-zhuan-by-wang_ni_ma/
 *
 * @author rj-liang
 * @date 2020/10/27 20:20
 */
public class Solution1 {
    public static int reverse(int x) {
        int res = 0;
        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE + " x=" + x);
        while (x != 0) {
            int t = x % 10;
            int newRes = res * 10 + t;
            System.out.println("x = " + x + " newRes=" + newRes + " t=" + t + " res=" + res);
            // 如果数字溢出，直接返回0
            // 两个数相加溢出只会变成负数。。不会异常 所以不能通过捕获异常的方式
            if ((newRes - t) / 10 != res) {
                return 0;
            }
            res = newRes;
            x = x / 10;
        }
        return res;
    }

    public static int reverse2(int num) {
        int res  = 0;
        while (num != 0) {
            if (res  < Integer.MIN_VALUE || res  >  Integer.MAX_VALUE) {
                return 0;
            }
            res  = res  * 10 + num % 10;
            num = num / 10;
        }
        return res;
    }
}
