import jdk.jfr.Percentage;

/*
 * @lc app=leetcode.cn id=309 lang=java
 *
 * [309] 最佳买卖股票时机含冷冻期
 */

// @lc code=start
class Solution {
    // public int maxProfit(int[] prices) {
    //     if(prices.length == 0){
    //         return 0;
    //     }
    //     //0持有股票  1 持有现金   2持有现金，处于冷冻期
    //     int[][] dp = new int[prices.length][3];
    //     dp[0][0] = -prices[0];
    //     dp[0][1] = 0;
    //     dp[0][2] = 0;
    //     for(int i = 1; i < prices.length; i++){
    //         dp[i][0] = Math.max(dp[i - 1][0],  dp[i - 1][1] - prices[i]);
    //         dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2]);
    //         dp[i][2] = dp[i - 1][0] + prices[i];
    //     }
    //     return Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]);
    // }

    public int maxProfit(int[] prices){
        if(prices.length == 0){
            return 0;
        }
        // 0 买入
        // 1 卖出  之前也是卖出状态
        // 2 今天卖出的
        // 3 今天为冷冻期
        int[][] dp = new int[prices.length][4];
        dp[0][0] = -prices[0];
        for(int i = 1; i < prices.length; i++){
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][3]) - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            dp[i][2] = dp[i - 1][0] + prices[i];
            dp[i][3] = dp[i - 1][2];
        }
        return Math.max(dp[prices.length - 1][1], Math.max(dp[prices.length - 1][2], dp[prices.length - 1][3]));
    }
}
// @lc code=end

