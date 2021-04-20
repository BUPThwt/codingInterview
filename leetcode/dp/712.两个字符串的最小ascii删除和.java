/*
 * @lc app=leetcode.cn id=712 lang=java
 *
 * [712] 两个字符串的最小ASCII删除和
 */

// @lc code=start
class Solution {
    // 公共子字符串的变种
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        // 初始化
        for(int i = 1; i <= s1.length(); i++){
            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
        }
        for(int j = 1; j <= s2.length(); j++){
            dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);
        }
        for(int i = 1; i <= s1.length(); i++){
            for(int j = 1; j <= s2.length(); j++){
                // 相等不用删
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    // 不相等，选择删s1 还是 s2
                    dp[i][j] = Math.min(dp[i - 1][j] + s1.codePointAt(i - 1), dp[i][j - 1] + s2.codePointAt(j - 1));
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
// @lc code=end

