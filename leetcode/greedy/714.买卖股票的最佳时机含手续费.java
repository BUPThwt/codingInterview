/*
 * @lc app=leetcode.cn id=714 lang=java
 *
 * [714] 买卖股票的最佳时机含手续费
 */

// @lc code=start
class Solution {
    // public int maxProfit(int[] prices, int fee) {
    //     int profit = 0;
    //     int min = prices[0];
    //     for(int i = 1; i < prices.length; i++){
    //         if(prices[i] < min){
    //             min = prices[i];
    //         }
    //         if(prices[i] - min > fee){
    //             profit += prices[i] - min - fee;
    //             min = prices[i] - fee;
    //         }
    //     }
    //     return profit;
    // }

    public int maxProfit(int[] prices, int fee){
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for(int i = 1; i < prices.length; i++){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
        }
        return dp[prices.length - 1][1];
    } 
}
// @lc code=end

