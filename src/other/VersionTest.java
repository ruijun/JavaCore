package other;

import java.util.Scanner;

/**
 * Enter the description
 *
 * @autor rj-liang
 * @date 17-7-20 上午9:08
 */
public class VersionTest {
    public static void main(String[] args) {
        String version1 = "2.2.2";
        String version2 = "2.01.2";

        System.out.println("输入版本号1：");
        version1 = new Scanner(System.in).nextLine();

        System.out.println("输入版本号2：");
        version2 = new Scanner(System.in).nextLine();

        System.out.println("version1:" + version1 + " version2:" + version2 + " " + Version.compareVersion2(version1, version2));
    }
}
