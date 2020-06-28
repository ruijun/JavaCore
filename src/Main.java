import util.IDCardUtil;

import java.lang.String;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        System.out.println("有20个人要到河的对岸去，然后只有一个小船，一次只能载五个人。" + boat() + "次可以载完。");
//        System.out.println("9990=====>" + formatNumberText(RoundingMode.DOWN, 9990));
//        System.out.println("999999=====>" + formatNumberText(RoundingMode.DOWN, 999999));
//
//        System.out.println("9990=====>" + formatNumberText(RoundingMode.UP, 9990));
//        System.out.println("999999=====>" + formatNumberText(RoundingMode.UP, 999999));
//
//        System.out.println("9990=====>" + formatNumberText(RoundingMode.HALF_EVEN, 9990));
//        System.out.println("999999=====>" + formatNumberText(RoundingMode.HALF_EVEN, 999999));
//
//        System.out.println("9990=====>" + formatNumberText(RoundingMode.HALF_DOWN, 9990));
//        System.out.println("999999=====>" + formatNumberText(RoundingMode.HALF_DOWN, 999999));
//
//        System.out.println("9990=====>" + formatNumberText(RoundingMode.HALF_UP, 9990));
//        System.out.println("999999=====>" + formatNumberText(RoundingMode.HALF_UP, 999999));



        System.out.println("1000=====>" + formatNumberText(RoundingMode.FLOOR, 1000));
        System.out.println("1900=====>" + formatNumberText(RoundingMode.FLOOR, 1900));
        System.out.println("9990=====>" + formatNumberText(RoundingMode.FLOOR, 9990));
        System.out.println("9999=====>" + formatNumberText(RoundingMode.FLOOR, 9999));
        System.out.println("999999=====>" + formatNumberText(RoundingMode.FLOOR, 999999));
        System.out.println("99999999=====>" + formatNumberText(RoundingMode.FLOOR, 99999999));
        System.out.println("300,124,567=====>" + formatNumberText(RoundingMode.FLOOR, 300124567));
        System.out.println("100000=====>" + formatNumberText(RoundingMode.FLOOR, 100000));
        System.out.println("3,325,156=====>" + formatNumberText(RoundingMode.FLOOR, 3325156));
        System.out.println("123456=====>" + formatNumberText(RoundingMode.FLOOR, 123456));
        System.out.println("666=====>" + formatNumberText(RoundingMode.FLOOR, 666));
        System.out.println("4380=====>" + formatNumberText(RoundingMode.FLOOR, 4380));
        System.out.println("12,365=====>" + formatNumberText(RoundingMode.FLOOR, 12365));
        System.out.println("30000000000=====>" + formatNumberText(RoundingMode.FLOOR, 30000000000L));
        System.out.println("300,000,000,000=====>" + formatNumberText(RoundingMode.FLOOR, 300000000000L));
        long s1 = System.currentTimeMillis();
        System.out.println("9999999999999L=====>" + formatNumberText(RoundingMode.FLOOR, 9999999999999L));
        System.out.println("9999999999999L=====> time " + (System.currentTimeMillis() - s1));
        System.out.println("30,124,567=====>" + formatNumberText(RoundingMode.FLOOR, 30124567));
        System.out.println(" aaaaa " + 99999999 / 1000.d);
        System.out.println(" Test time1  " + testTime(57));
        System.out.println(" Test time2  " + testTime(132));
        System.out.println(" Test time2  " + testTime(120));
        System.out.println(" Test time2  " + testTime(11));
        System.out.println(" Test time2  " + testTime(5));
        System.out.println(" Test time2  " + testTime(3));
        System.out.println(" Test time2  " + testTime(300));
    }

    /**
     * 有20个人要到河的对岸去，然后只有一个小船，一次只能载五个人。几次可以载完？
     *
     * @return 次数
     *
     * by 糟糕的开发
     */

    public static int boat() {
        int peopleNum = 20; // 人数
        int count = 1;  // 次数
        while (true) {
            // 每次载5人
//            peopleNum -= 5;
            peopleNum = peopleNum -5;
            // 人数少于1，退出循环
            if (peopleNum <= 0) {
                break;
            }
            // 每次都要回来一个人
//            peopleNum += 1;
            peopleNum = peopleNum +1;
            // 次数加1
            count++;
        }
        return count;
    }
    /**
     * 数字规范化(人气，观众数等)
     *
     * @param originalNumber 原始数值
     * @return
     */
    public static String formatNumberText(RoundingMode roundingMode, long originalNumber) {
        return formatNumberText(roundingMode, originalNumber, false, 3);
    }

    /**
     * 数字规范化(人气，观众数等)，向下取正
     *
     * 三位数：666
     * 四位数：4.38K=4,380；
     * 五位数：12.3K=12,365；
     * 六位数：234k=234,561
     * 七位数：3.32M=3,325,156（百万）
     * 八位数：30.1M=30,124,567
     * 九位数：300M=300,124,567
     * 十位数：3.48B=3,480,000,000
     * 11位数：30.0B=30,000,000,000
     * 12位数：300B=300,000,000,000
     * 13位数：9.99B+=9999999999999
     *
     * @param originalNumber 原始数值
     * @param uppercase      大小写
     * @param total          一共多少位
     * @return
     */
    public static String formatNumberText(RoundingMode roundingMode, long originalNumber, boolean uppercase, int total) {
        if (originalNumber < 1000) {
            return String.format(Locale.ENGLISH, "%s%s", originalNumber + "", "");
        }

        double newNumber = originalNumber;
        int unitIndex = 0;
        final String[] units = {"", "K", "M", "B", "B+"};
        while (newNumber >= 1000.d && unitIndex < units.length) {
            newNumber /= 1000.d;
            unitIndex++;
            System.out.println("newNumber=====>" + newNumber + " unitIndex======>" + unitIndex);
        }

        String unit = uppercase ? units[unitIndex].toUpperCase() : units[unitIndex];

        // 通过截取的方式来判断整数的位数， 减去整数位数后，剩余的是小数位数
        String[] nums = String.valueOf(newNumber).split("\\.");

        NumberFormat numberFormat = NumberFormat.getInstance(Locale.ENGLISH);
        numberFormat.setRoundingMode(RoundingMode.DOWN);
        numberFormat.setMinimumFractionDigits(nums != null && nums.length > 1 ? Math.abs(total - nums[0].length()) : 0);
        numberFormat.setMaximumFractionDigits(nums != null && nums.length > 1 ? Math.abs(total - nums[0].length()) : 0);
        numberFormat.setMinimumIntegerDigits(nums != null && nums.length > 1 ? nums[0].length() : total);
        numberFormat.setMaximumIntegerDigits(nums != null && nums.length > 1 ? nums[0].length() : total);

        return String.format(Locale.ENGLISH, "%s%s", numberFormat.format(newNumber), unit);
    }

    public static int testTime(int durationGap) {
        double result = durationGap / 60.d;
        System.out.println(" result=" + result);
        return (int)Math.ceil(result);
    }


}
