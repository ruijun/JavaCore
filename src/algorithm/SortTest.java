package algorithm;

import java.util.*;

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
        ArrayList<String> list = new ArrayList<>();
        list.add(null);
        Set<String> set = new HashSet<>();
        set.add(null);
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(null, null);
        Hashtable<Integer, String> hashtable = new Hashtable<>();
        hashtable.put(null, null);

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
        int[] arrs = {6, 12, 33, 33, 33, 33, 33, 87, 90, 97, 108, 561};
//        System.out.println("des出现次数: " + Find.binarySearchCount(arr1,33));
        bubbleSort(arrs);
        System.out.println("冒泡排序");
        for (int arr : arrs) {
            System.out.println(arr);
        }
    }

    public static void bubbleSort(int[] nums) {
        for (int i = nums.length - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                if (nums[j - 1] > nums[j]) {
                    swap(nums, j, j - 1);
                }
            }
        }
    }

    public static void quickSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }

        int index = partition(nums, low, high);
        quickSort(nums, low, index - 1);
        quickSort(nums, index + 1, high);

    }


    public static int partition (int[] nums, int low, int high) {

        int pivot = nums[low];
        while (low < high) {
            // 移动high指针
            while (low < high && nums[high] >= pivot) {
                high--;
            }

            // 填坑
            if (low < high) nums[low] = nums[high];

            while (low < high && nums[low] <= pivot) {
                low++;
            }

            // 填坑
            if (low < high) nums[high] = nums[low];
        }

        //基准数放到合适的位置
        nums[low] = pivot;
        return low;
    }

    public static int partition2 (int[] nums, int low, int high) {

        int pivot = nums[low];
        int start = low;

        while (low < high) {
            while (low < high && nums[high] >= pivot) high--;
            while (low < high && nums[low] <= pivot) low++;
            if (low >= high) break;
            swap(nums, low, high);
        }
        //基准值归位
        swap(nums,start,low);
        return low;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
