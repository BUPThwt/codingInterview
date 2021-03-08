/*
 * @lc app=leetcode.cn id=714 lang=java
 *
 * [714] 买卖股票的最佳时机含手续费
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        // 买股票
        dp[0][0] = -prices[0];
        // 持现金
        dp[0][1] = 0;
        for(int i = 1; i < prices.length; i++){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
        }
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
    }


    // public int maxProfit(int[] prices, int fee){
    //     int maxProfit = 0;
    //     int minPrice = prices[0];
    //     for(int i = 1; i < prices.length; i++){
    //         minPrice = Math.min(minPrice, prices[i]);
    //         if(prices[i] > minPrice + fee){
    //             maxProfit += prices[i] - minPrice - fee;
    //             minPrice = prices[i] - fee;
    //         }
    //     }
    //     return maxProfit;
    // }
}
// @lc code=end

