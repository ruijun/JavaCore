package leetcode.codetop;

import java.util.Stack;

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

        int []numC = {1, 2, 3};
        solution.permute(numC);

        int []numD = {1, 2, 5};
        solution.coinChange(numD, 5);

        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagSize = 4;
        solution.badgeProblem(weight, value, bagSize);

        String numStr1 = "51189";
        String numStr2 = "967895";

        solution.addStrings(numStr1, numStr2);
        System.out.printf("numStr1 + numStr2=" + solution.addStrings(numStr1, numStr2));

        String numStr3 = "3[a]2[bc]";
        solution.decodeString(numStr3);

    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if(c == '(') {
                stack.push(')');
            } else if(c == '[') {
                stack.push(']');
            } else if(c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != c){
                return false;
            }
        }

        return true;
    }
}
