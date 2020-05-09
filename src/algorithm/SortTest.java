package algorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * Enter the description
 *
 * @autor rj-liang
 * @date 17-5-22 上午11:27
 */
public class SortTest {
    public static void main(String[] args) {

        int[] arr1 = new int[50];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = new Random().nextInt(50) + 1;
        }

        long a = System.currentTimeMillis();
        Sort.bubbleSort1(arr1);
        long b = System.currentTimeMillis();
        System.out.println("冒泡耗时：" + (b - a) + "ms");
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }

//        int[] arr2 = new int[5000];
//        for (int i = 0; i < arr2.length; i++) {
//            arr2[i] = new Random().nextInt(5000) + 1;
//        }
//        long c = System.currentTimeMillis();
//        Sort.insertDirectlySort(arr2);
//        long d = System.currentTimeMillis();
//        System.out.println("快速排序耗时：" + (d - c) + "ms");
//        for (int i = 0; i < arr2.length; i++) {
//            System.out.println(arr2[i]);
//        }

//        int[] arr = {6, 12, 33, 87, 90, 97, 108, 561};
//        int[] arr1 = {38, 49, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};
//        Sort.bubbleSort2(arr1);
//        System.out.println("冒泡排序");
//        for (int a : arr1) {
//            System.out.println(a);
//        }

//        System.out.println("循环查找：" + (Find.binarySearchFind(arr, 87) + 1));
//        System.out.println("递归查找: " + Find.binarySearchFindWithRecursion(arr,6,0,arr.length-1));
//        System.out.println("大于des的最小数: " + Find.binarySearchMinFind(arr,50));
//        System.out.println("小于des条件的最大的数: " + Find.binarySearchMaxFind(arr,50));
//        System.out.println("" + 7 / 2 + " " + 7 % 2);
//
//        int[] arr1 = { 6, 12, 33, 33, 33, 33, 33, 87, 90, 97, 108, 561 };
//        System.out.println("des出现次数: " + Find.binarySearchCount(arr1,33));
    }
}
