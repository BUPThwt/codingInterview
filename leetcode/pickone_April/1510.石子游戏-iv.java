/*
 * @lc app=leetcode.cn id=1510 lang=java
 *
 * [1510] 石子游戏 IV
 */

// @lc code=start
class Solution {
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];
        // 初始化，只有0个石子的时候，是输的，所以dp[0]是false
        // 遍历n个石子
        for(int i = 0; i <= n; i++){
            // 非零平方  j*j
            for(int j = 1; j * j + i <= n; j++){
                // 拿走j*j   剩下i,如果剩i个的时候输的话，那alice拿走j*j就赢。
                if(!dp[i]){
                    dp[j * j + i] = true;
                }
            }
        }
        return dp[n];
    }
}
// @lc code=end

