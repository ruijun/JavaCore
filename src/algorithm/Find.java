package algorithm;

import java.util.Arrays;

/**
 * 查找算法
 *
 * @autor rj-liang
 * @date 2017/5/14 下午9:54
 */
public class Find {

    /**
     * 顺序查找平均时间复杂度 O(n)
     *
     * @param nums 数组（从这个数组中查找）
     * @param des  要查找的值
     * @return 查找结果（数组的下标位置）
     */
    public static int orderFind(int[] nums, int des) {
        if (nums == null || nums.length < 1)
            return -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == des) {
                return i;
            }
        }
        return -1;

    }

    /**
     * 二查查找算法，要求准确找到目标值，没有找到则是-1.
     * 此方法保证在相同元素都满足条件时，取到的是最大的下标
     * 时间复杂度 o(lgN)
     *
     * @param nums int型数组，要求有序
     * @return 找到，返回下标，没找到，返回-1
     */
    public static int binarySearchFind(int[] nums, int des) {
        int length = nums.length;
        System.out.println("length=" + length);
        // 定义最大索引和最小索引
        int low = 0;
        int high = length - 1;
        while (low <= high) {
            // 计算中间索引
            int mid = (low + high) / 2;
            System.out.println("mid=" + mid + ",low=" + low + ",high=" + high);
            System.out.println("nums=" + Arrays.toString(nums));
            if (nums[mid] == des) {
                return mid;
            } else if (nums[mid] < des) {
                // 在右边查找
                low = mid + 1;
            } else {
                // 在左边查找
                high = mid - 1;
            }

        }
        return -1;
    }

    /**
     * 递归方法实现二分查找法.
     * https://blog.csdn.net/weixin_38118016/article/details/89368351
     *
     * @param nums
     * @param des
     * @param low
     * @param high
     * @return
     */
    public static int binarySearchFindWithRecursion(int[] nums, int des, int low, int high) {
        while (low <= high) {
            // 计算中间索引
            int mid = (low + high) / 2;
            if (nums[mid] == des) {
                return mid;
            } else if (nums[mid] < des) {
                // 在右边查找
                return binarySearchFindWithRecursion(nums, des, mid + 1, high);
            } else {
                // 在左边查找
                return binarySearchFindWithRecursion(nums, des, low, mid - 1);
            }
        }
        return -1;
    }

    /**
     * 给定一个单调不降的数组，查找大于des条件的最小的数
     *
     * @param nums
     * @param des
     * @return 返回改数的下标
     */
    public static int binarySearchMinFind(int[] nums, int des) {
        int length = nums.length;
        int low = 0;
        int high = length - 1;
        int mid;
        while (low < high) {
            mid = (low + high) / 2;
            if (nums[mid] <= des) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if (nums[high] > des) return high;
        return -1;
    }

    /**
     * 给定一个单调不降的数组，查找小于des条件的最大的数
     *
     * @param nums
     * @param des
     * @return
     */
    public static int binarySearchMaxFind(int[] nums, int des) {
        int length = nums.length;
        int low = 0;
        int high = length - 1;
        int mid;
        int result = -1;
        while (low < high) {
            mid = low + (high - low + 1) / 2;
            if (nums[mid] < des) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        if (nums[low] < des) return low;
        return -1;
    }

    /**
     * 求等于target的最小元素位置
     *
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearchMin(int[] nums, int target){
        if(nums.length <= 0) return -1;

        int start = 0;
        int end = nums.length-1;
        // 二分查找变形
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] == target){
                // 如果中间元素左边元素等于目标元素
                if (mid - 1 >= 0 && nums[mid - 1] == target){
                    end = mid - 1;
                }
                else {
                    return mid;
                }
            }
            // 目标位于左半部分
            else if(nums[mid] > target){
                end = mid - 1;
            }
            // 目标位于右半部分
            else{
                start = mid + 1;
            }
        }

        return -1;
    }

    /**
     * 求等于target的最大元素位置
     *
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearchMax(int[] nums, int target){
        if(nums.length <= 0){
            return -1;
        }//if
        int start = 0;
        int end = nums.length - 1;
        // 二分查找变形
        while(start <= end){
            int mid = (start + end) / 2;
            // 中间元素等于目标
            if(nums[mid] == target){
                // 如果中间元素右边元素等于目标元素
                if(mid + 1 < nums.length && nums[mid + 1] == target){
                    start = mid + 1;
                }
                else{
                    return mid;
                }
            }
            else if(nums[mid] > target){
                end = mid -1;
            }
            else{
                start = mid + 1;
            }
        }

        return -1;
    }

    /**
     * 查找目标元素出现的次数
     *
     * @param nums
     * @param des
     * @return
     */
    public static int binarySearchCount(int[] nums, int des){
        int min = binarySearchMin(nums, des);
        int max = binarySearchMax(nums, des);
        // 没有
        if(min == -1){
            return 0;
        }

        int count = max - min + 1;
        return count;
    }

    public static int binarySearchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        while (left < right) {
            mid = (left + right) / 2;
            if (target <= nums[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}