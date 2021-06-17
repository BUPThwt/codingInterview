/*
 * @lc app=leetcode.cn id=518 lang=java
 *
 * [518] 零钱兑换 II
 */

// @lc code=start
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int i = 0; i < coins.length; i++){
            for(int j = 1; j <= amount; j++){
                if(j - coins[i] >= 0){
                    dp[j] += dp[j - coins[i]];
                }
            }
        }
        return dp[amount];
    }
}
// @lc code=end

