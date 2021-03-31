/*
 * @lc app=leetcode.cn id=115 lang=java
 *
 * [115] 不同的子序列
 */

// @lc code=start
class Solution {
    public int numDistinct(String s, String t) {
        //dp[i][j]表示 以i-1结尾的s中以j-1结尾的t的个数
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for(int i = 0; i <= s.length(); i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i <= s.length(); i++){
            for(int j = 1; j <= t.length(); j++){
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
// @lc code=end

