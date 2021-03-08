/*
 * @lc app=leetcode.cn id=188 lang=java
 *
 * [188] 买卖股票的最佳时机 IV
 */

// @lc code=start
class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices.length == 0 || k == 0){
            return 0;
        }
        int[][] dp = new int[prices.length][2 * k + 1];
        for(int i = 1; i < 2 * k; i+= 2){
            dp[0][i] = -prices[0];
        }
        for(int i = 1; i < prices.length; i++){
            for(int j = 0; j < 2 * k; j += 2){
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);
                dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);
            }
        }
        return dp[prices.length - 1][2 * k];
    }
}
// @lc code=end

