/*
 * @lc app=leetcode.cn id=312 lang=java
 *
 * [312] 戳气球
 */

// @lc code=start
class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n + 2];
        temp[0] = 1;
        temp[n + 1] = 1;
        for(int i = 0; i < nums.length; i++){
            temp[i + 1] = nums[i];
        }
        //dp[i][j]表示开区间（i，j）内获取的最大收益
        int[][] dp = new int[n + 2][n + 2];
        // len区间长度
        for(int len = 3; len <= n + 2; len++){
            // 开区间左边的起始点
            for(int i = 0; i <= n + 2 -len; i++){
                int res = 0;
                // k表示开区间内的气球。
                for(int k = i + 1; k < i + len - 1; k++){
                    res = Math.max(res, dp[i][k] + temp[i] * temp[k] * temp[i + len - 1] + dp[k][i + len - 1]);
                }
                dp[i][i + len - 1] = res;
            }
        }
        return dp[0][n + 1];
    }
}
// @lc code=end

