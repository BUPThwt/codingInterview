import jdk.jfr.Percentage;

/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    // 只允许买卖一次
    // public int maxProfit(int[] prices) {
    //     if(prices.length == 0){
    //         return 0;
    //     }
    //     int[][] dp = new int[prices.length][2];
    //     // 持有股票
    //     dp[0][0] = -prices[0];
    //     // 持有现金
    //     dp[0][1] = 0;
    //     for(int i = 1; i < prices.length; i++){
    //         dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
    //         dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
    //     }
    //     return dp[prices.length - 1][1];
    // }

    public int maxProfit(int[] prices){
        int result = 0;
        int low = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++){
            low = Math.min(prices[i], low);
            result = Math.max(result, prices[i] - low);
        }
        return result;
    }
}
// @lc code=end

