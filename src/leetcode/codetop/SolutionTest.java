package leetcode.codetop;

/**
 * Enter the description
 *
 * @autor rj-liang
 * @date 2021/8/10 11:20 上午
 */
public class SolutionTest {
    public static void main(String[] args) {
        int nums1[] = new int[]{1, 2, 3, 0, 0, 0};
        int nums2[] = new int[]{2, 5, 6};
        Solution solution = new Solution();
        solution.merge(nums1, 3, nums2, 3);

        int[] nums = {-1, 0, 1, 2, -1, -4};
        solution.threeSum(nums);

        int[] numA = {10, 9, 2, 5, 3, 7, 101, 18};
        solution.lengthOfLIS(numA);

        int[][] grid = { {1, 3, 1},
                         {1, 5, 1},
                         {4, 2, 1}};
        solution.minPathSum(grid);

    }
}
