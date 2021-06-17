/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int result = nums[0];
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        for(int i = 1; i < nums.length; i++){
            dp[i][0] = Math.min(nums[i], Math.min(dp[i - 1][0] * nums[i], dp[i - 1][1] * nums[i]));
            dp[i][1] = Math.max(nums[i], Math.max(dp[i - 1][0] * nums[i], dp[i - 1][1] * nums[i]));
            result = Math.max(result, dp[i][1]);
        }
        return result;

    }
}
// @lc code=end

