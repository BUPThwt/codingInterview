/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solution {
    // dp
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for(int i = 1; i < prices.length; i++){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[prices.length - 1][1];
    }

    // 贪心
    // public int maxProfit(int[] prices){
    //     int profit = 0;
    //     for(int i = 1; i < prices.length; i++){
    //         profit += Math.max(0, prices[i] - prices[i - 1]);
    //     }
    //     return profit;
    // }
}
// @lc code=end

