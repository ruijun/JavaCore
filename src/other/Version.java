package other;

/**
 * Enter the description
 *
 * @autor rj-liang
 * @date 17-7-20 上午9:07
 */
public class Version {
    /**
     * 比较版本号的大小,前者大则返回一个正数,后者大返回一个负数,相等则返回0
     *
     * @param version1
     * @param version2
     * @return
     */
    public static int compareVersion(String version1, String version2) {
        if (version1 == null || version1.equals("") || version2 == null || version2.equals("")) {
            return 0;
        }

        version1 = version1.replaceAll("[a-zA-Z]", "");
        version2 = version2.replaceAll("[a-zA-Z]", "");
        String[] versionArray1 = version1.split("\\.");// 注意此处为正则匹配，不能用"."；
        String[] versionArray2 = version2.split("\\.");

        int idx = 0;
        int minLength = Math.min(versionArray1.length, versionArray2.length);// 取最小长度值
        int diff = 0;
        while (idx < minLength
//                && (diff = versionArray1[idx].length() - versionArray2[idx].length()) == 0 // 先比较长度
                && (diff = versionArray1[idx].compareTo(versionArray2[idx])) == 0) { // 再比较字符
            ++idx;
        }
        // 如果已经分出大小，则直接返回，如果未分出大小，则再比较位数，有子版本的为大；
        diff = (diff != 0) ? diff : versionArray1.length - versionArray2.length;
        return diff;
    }

    /**
     * 比较版本号的大小,前者大则返回一个正数,后者大返回一个负数,相等则返回0
     * 例如：2.3.0 > 2.3  2.03.1 == 2.3.1
     *
     * @param version1
     * @param version2
     * @return
     */
    public static int compareVersion2(String version1, String version2) {
        if (version1 == null || version2 == null)
            return 0;

        // 处理版本号中带有字符串的情况
        version1 = version1.replaceAll("[a-zA-Z]", "");
        version2 = version2.replaceAll("[a-zA-Z]", "");

        // 以"."为分割点进行截取
        String[] versionArray1 = version1.split("\\.");
        String[] versionArray2 = version2.split("\\.");

        int length1 = versionArray1.length;
        int length2 = versionArray2.length;

        int diff = 0;

        while (diff < length1 || diff < length2) {
            try {
                long num1 = diff < length1 ? Long.parseLong(versionArray1[diff]) : -1;
                long num2 = diff < length2 ? Long.parseLong(versionArray2[diff]) : -1;
                if (num1 > num2)
                    return 1;
                else if (num1 < num2)
                    return -1;
                else
                    ++diff;
            } catch (Exception e) {
                // 如果出现异常，返回任意大小
                return -1;
            }

        }

        return 0;

    }
}
