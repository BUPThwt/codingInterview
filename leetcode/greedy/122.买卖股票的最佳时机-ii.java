/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
// class Solution {
//     public int maxProfit(int[] prices) {
//         int profit = 0;
//         for(int i = 1; i < prices.length; i++){
//             profit += Math.max(prices[i] - prices[i - 1], 0);
//         }
//         return profit;
//     }
// }

class Solution{
    public int maxProfit(int[] prices){
        int[][] dp = new int[prices.length][2];
        // 买股票
        dp[0][0] = -prices[0];
        // 持现金
        dp[0][1] = 0;
        for(int i = 1; i < prices.length; i++){
            // 昨天买股票，和昨天持现金今天买入
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            // 昨天持现金，和昨天买股票今天卖出
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[prices.length - 1][1];
    }
}
// @lc code=end

