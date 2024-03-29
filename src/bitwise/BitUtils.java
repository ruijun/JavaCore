package bitwise;

/**
 * Java 位运算的常用方法封装
 *
 * @autor rj-liang
 * @date 2017/7/24 上午7:47
 */
public class BitUtils {

    /**
     * 交换两个数
     * 异或：两个位相同为0，不同为1
     */
    public static void swap(){
        /**
         * 1010
         * 0011
         * 1001
         *
         *
         */
        int a = 10;
        int b = 5;

        a = a ^ b; // 1010 ^ 0011 = 1001
        b = b ^ a; // 0011 ^ 1001 = 1010
        a = a ^ b; // 1001 ^ 1010 = 0011

        System.out.println("a= " + a + " " + "b= " + b);
    }

    /**
     * 判断奇偶数
     * 与: 两个位都为1时，结果才为1
     * @param num
     * @return
     */
    public static boolean isOddNumber(int num) {
        // a&1 = 0偶数
        return (num & 1) == 1;
    }

    /**
     * 获取运算数指定位置的值
     * 例如： 0000 1011 获取其第 0 位的值为 1, 第 2 位 的值为 0
     *
     * @param source
     *            需要运算的数
     * @param pos
     *            指定位置 (0<=pos<=7)
     * @return 指定位置的值(0 or 1)
     */
    public static byte getBitValue(byte source, int pos) {
        return (byte) ((source >> pos) & 1);
    }


    /**
     * 将运算数指定位置的值置为指定值
     * 例: 0000 1011 需要更新为 0000 1111, 即第 2 位的值需要置为 1
     *
     * @param source
     *            需要运算的数
     * @param pos
     *            指定位置 (0<=pos<=7)
     * @param value
     *            只能取值为 0, 或 1, 所有大于0的值作为1处理, 所有小于0的值作为0处理
     *
     * @return 运算后的结果数
     */
    public static byte setBitValue(byte source, int pos, byte value) {

        byte mask = (byte) (1 << pos);
        if (value > 0) {
            source |= mask; //或：两个位都为0时，结果才为0
        } else {
            source &= (~mask);
        }

        return source;
    }


    /**
     * 将运算数指定位置取反值
     * 例： 0000 1011 指定第 3 位取反, 结果为 0000 0011; 指定第2位取反, 结果为 0000 1111
     *
     * @param source
     *
     * @param pos
     *            指定位置 (0<=pos<=7)
     *
     * @return 运算后的结果数
     */
    public static byte reverseBitValue(byte source, int pos) {
        byte mask = (byte) (1 << pos);
        return (byte) (source ^ mask);
    }


    /**
     * 检查运算数的指定位置是否为1
     *
     * @param source
     *            需要运算的数
     * @param pos
     *            指定位置 (0<=pos<=7)
     * @return true 表示指定位置值为1, false 表示指定位置值为 0
     */
    public static boolean checkBitValue(byte source, int pos) {

        source = (byte) (source >>> pos);

        return (source & 1) == 1;
    }

    /**
     * 入口函数做测试
     *
     * @param args
     */
    public static void main(String[] args) {

        // 取十进制 11 (二级制 0000 1011) 为例子
        byte source = 11;

        // 取第2位值并输出, 结果应为 0000 1011
        for (byte i = 7; i >= 0; i--) {
            System.out.printf("%d ", getBitValue(source, i));
        }

        // 将第6位置为1并输出 , 结果为 75 (0100 1011)
        System.out.println("\n" + setBitValue(source, 6, (byte) 1));

        // 将第6位取反并输出, 结果应为75(0100 1011)
        System.out.println(reverseBitValue(source, 6));

        // 检查第6位是否为1，结果应为false
        System.out.println(checkBitValue(source, 6));

        // 输出为1的位, 结果应为 0 1 3
        for (byte i = 0; i < 8; i++) {
            if (checkBitValue(source, i)) {
                System.out.printf("%d ", i);
            }
        }

    }
}

