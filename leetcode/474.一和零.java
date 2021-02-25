/*
 * @lc app=leetcode.cn id=474 lang=java
 *
 * [474] 一和零
 */

// @lc code=start
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for(int i = 0; i < strs.length; i++){
            int zero = 0;
            int one = 0;
            for(char c : strs[i].toCharArray()){
                if('0' == c){
                    zero++;
                }else{
                    one++;
                }
            }
            for(int j = m; j >= zero; j--){
                for(int k = n; k >= one; k--){
                    dp[j][k] = Math.max(dp[j][k], dp[j - zero][k - one] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
// @lc code=end

