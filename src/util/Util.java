package util;

import java.util.Arrays;
import java.util.List;

/**
 * Enter the description
 *
 * @autor rj-liang
 * @date 2021/8/17 10:47 上午
 */
public class Util {
    public static void swap(int[] A, int i, int j) {
        if (i != j) {
            A[i] ^= A[j];
            A[j] ^= A[i];
            A[i] ^= A[j];
        }
    }

    private static String bitBinary(String binaryString, int bit) {
        String tempString = binaryString;
        StringBuilder stringBuilder = new StringBuilder(bit);
        if (tempString.length() < bit) {
            for (int i = 0, length = bit - tempString.length(); i < length; i++) {
                stringBuilder.append("0");
            }
            stringBuilder.append(tempString);
            tempString = stringBuilder.toString();
        }
        stringBuilder.delete(0, tempString.length());
        for (int i = 0; i < tempString.length(); i++) {
            stringBuilder.append(tempString.charAt(i));
            if ((i + 1) % 8 == 0) stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    public static String bitInt32(int num) {
        return bitBinary(Integer.toBinaryString(num), 32);
    }

    public static String bitLong64(long num) {
        return bitBinary(Long.toBinaryString(num), 64);
    }

    public static void printTwoObjectArrays(Object[][] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                System.out.println(arrays[i][j]);
            }
        }
    }

    public static void printTwoCharArrays(char[][] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                System.out.print(arrays[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void printTwoIntArrays(int[][] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                System.out.print(arrays[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void printTwoLongArrays(long[][] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                System.out.print(arrays[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void printList(List<List<Integer>> mList) {
        for (int i = 0; i < mList.size(); i++) {
            System.out.println(Arrays.toString(mList.get(i).toArray()));
        }
    }

    private static String addCharPre(String string, int count) {
        StringBuilder stringBuilder = new StringBuilder(count);
        if (string == null || string.length() == 0) {
            stringBuilder.append(" ", 0, count);
            return stringBuilder.toString();
        }
        for (int i = string.length(); i < count; i++) {
            stringBuilder.insert(0, " ");
        }
        return stringBuilder.toString();
    }

    private static String addCharAfter(String string, int count) {
        StringBuilder stringBuilder = new StringBuilder(count);
        if (string == null || string.length() == 0) {
            stringBuilder.append(" ", 0, count);
            return stringBuilder.toString();
        }
        for (int i = string.length(); i < count; i++) {
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
