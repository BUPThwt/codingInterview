/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= 2; j++){
                if(i - j >= 0){
                    dp[i] += dp[i - j];
                }
            }
        }
        return dp[n];
    }
}
// @lc code=end

