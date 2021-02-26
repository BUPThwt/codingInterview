/*
 * @lc app=leetcode.cn id=343 lang=java
 *
 * [343] 整数拆分
 */

// @lc code=start
class Solution {
    // 初始化太难想
    // public int integerBreak(int n) {
    //     if(n <= 3){
    //         return n - 1;
    //     }
    //     int[] dp = new int[n + 1];
    //     dp[1] = 1;
    //     dp[2] = 2;
    //     dp[3] = 3;
    //     for(int i = 4; i <= n; i ++){
    //         for(int j = 1; j < i; j++){
    //             dp[i] = Math.max(dp[i], dp[i - j] * dp[j]);
    //         }
    //     }
    //     return dp[n];
    // }

    public int integerBreak(int n){
        if(n == 1){
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for(int i = 3; i <= n; i++){
            for(int j = 1; j < i; j++){
                dp[i] = Math.max(dp[i], Math.max((i - j) * j, dp[i - j] * j));
            }
        }
        return dp[n];
    }
}
// @lc code=end

