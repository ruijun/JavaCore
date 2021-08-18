package leetcode.codetop;

import util.Util;

import java.util.*;

/**
 * leetcode题目
 *
 * @autor rj-liang
 * @date 2021/8/7 11:31 下午
 */
public class Solution {

    /**
     * 股票买卖最佳时机
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
     * 贪心算法(最低点买，最高点卖)
     */
    public int maxProfit(int prices[]) {
        if (prices == null || prices.length == 0) return 0;
        int mp = 0; // 最高收益
        int min = prices[0]; // 最低价
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                // 设定相对最低价
                min = prices[i];
            } else if (mp < (prices[i] - min)) {
                // 设定最高盈利
                mp = prices[i] - min;
            }
        }
        return mp;
    }

    /**
     * 买卖股票最佳时机2
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
     */
    public int maxProfit2(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; ++i) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }

    /**
     * 无重复字符的最长子串
     * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
     * 滑动窗口
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                // 'dvdf' 遇到d相同时候，left应该要移到v的位置，所以要加+1
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            map.put(s.charAt(right), right);
            max = Math.max(max, right - left + 1);
        }
        return max;

    }

    /**
     * 两数之和
     * https://leetcode-cn.com/problems/two-sum
     * 一遍hash O(n)
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    /**
     * 回文数
     * https://leetcode-cn.com/problems/palindrome-number/
     * 取指定位数的数字
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int cur = 0;
        int num = x;
        while (num != 0) {
            cur = cur * 10 + num % 10;
            num /= 10;
        }
        return cur == x;
    }

    /**
     * 有效括号
     * https://leetcode-cn.com/problems/valid-parentheses/
     */
    public static boolean isValid(String s) {
        // 1.特判
        if (s.isEmpty()) return true;
        // 2.创建辅助栈
        Stack<Character> stack = new Stack<>();
        // 3.遍历
        for (char c : s.toCharArray()) {
            if (c == '(') {
                System.out.println("-------->1");
                stack.push(')');
            } else if (c == '[') {
                System.out.println("-------->2");
                stack.push(']');
            } else if (c == '{') {
                System.out.println("-------->3");
                stack.push('}');
            } else if (stack.isEmpty() || c != stack.pop()) {
                System.out.println("-------->4");
                return false;
            }
        }
        System.out.println("-------->5");
        // 4.返回
        return stack.isEmpty();
    }

    /**
     * 字符串相加
     * https://leetcode-cn.com/problems/add-strings/solution/zi-fu-chuan-xiang-jia-by-leetcode-solution/
     */
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            // ASCII码48就是'0'，也就是说'0'的值是48，而后依次是'1'到'9'。
            // 这样正好是char型减去48就是它对应的int值。
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.insert(0, result % 10);
            add = result / 10;
            i--;
            j--;
        }
        // 计算完以后的答案需要翻转过来
//        ans.reverse();
        return ans.toString();
    }

    /**
     * 最大子序和
     * https://leetcode-cn.com/problems/maximum-subarray/
     * 贪心算法
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int sum = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            sum = Math.max(sum, count); // 取区间累计的最大值（相当于不断确定最大子序终止位置）
            if (count <= 0) {
                count = 0; // 相当于重置最大子序起始位置，因为遇到负数一定是拉低总和
            }
        }
        return sum;
    }



    public int maxSubArray2(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    /**
     * 合并两个有序数组
     * 从后向前数组遍历
     * 因为nums1的空间都集中在后面，所以从后向前处理排序的数据会更好，节省空间，一边遍历一边将值填充进去
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int tail = m + n - 1;
        int cur;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                cur = nums2[p2--];
            } else if (p2 == -1) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        /**
         * 参数1是要被复制的数组
         * 参数2是被复制的数字开始复制的下标
         * 参数3是目标数组，也就是要把数据放进来的数组
         * 参数4是从目标数据第几个下标开始放入数据
         * 参数5表示从被复制的数组中拿几个数值放到目标数组中
         */
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    /**
     * 三数之和
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            int target = 0 - nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            if (nums[i] > 0) {
                break;
            }
            if (i == 0 || nums[i] != nums[i - 1]) {
                while (left < right) {
                    if (nums[left] + nums[right] == target) {
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (nums[left] + nums[right] < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return result;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (right > left && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    while (right > left && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    right--;
                    left++;
                }
            }
        }
        return result;
    }

    /**
     * 最长递增子序列
     * https://leetcode-cn.com/problems/longest-increasing-subsequence/
     * 动态规划
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        //初始化就是边界情况
        dp[0] = 1;
        int maxAns = 1;
        //自底向上遍历
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            //从下标0到i遍历
            for (int j = 0; j < i; j++) {
                //找到前面比nums[i]小的数nums[j],即有dp[i]= dp[j]+1
                if (nums[j] < nums[i]) {
                    //因为会有多个小于nums[i]的数，也就是会存在多种组合了嘛，我们就取最大放到dp[i]
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            //求出dp[i]后，dp最大那个就是nums的最长递增子序列啦
            maxAns = Math.max(maxAns, dp[i]);
        }
        return maxAns;
    }

    /**
     * 最小路径和
     * https://leetcode-cn.com/problems/minimum-path-sum/
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length, columns = grid[0].length;
        int[][] dp = new int[rows][columns];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < columns; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[rows - 1][columns - 1];
    }

    List<List<Integer>> res = new LinkedList<>();

    /**
     * 全排列
     */
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backTrace(nums, track);
        return res;
    }

    private void backTrace(int[] nums, LinkedList<Integer> track) {
        // 相等的时候，说明得到了一个全排列
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 如果已经存在该元素，就不添加
            if (track.contains(nums[i])) {
                continue;
            }

            // 选择元素
            track.add(nums[i]);
            backTrace(nums, track);
            // 撤销选择
            track.removeLast();
        }
    }

    /**
     * 零钱兑换
     * https://leetcode-cn.com/problems/coin-change/
     * 动态规划
     */
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    /**
     * 背包问题
     */
    public int badgeProblem(int []weights, int []values, int bagSize) {
        int wLen = weights.length;
        // 定义dp数组：dp[i][j]表示背包容量为j时，前i个物品能获得的最大价值
        int[][] dp = new int[wLen + 1][bagSize + 1];

        // 初始化：背包容量为0时，能获得的价值都为0
        for (int j = 0; j < weights[0]; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < weights.length; i++) {
            for (int j = 0; j <= bagSize; j++) {
                if (j < weights[i]) {
                    dp[i][j] = dp[i - 1][j]; // 背包内的价值依然和前面相同
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i]] + values[i]);
                }
            }
        }
        Util.printTwoIntArrays(dp);
        return -1;
    }
}
