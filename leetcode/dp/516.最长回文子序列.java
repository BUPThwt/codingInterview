/*
 * @lc app=leetcode.cn id=516 lang=java
 *
 * [516] 最长回文子序列
 */

// @lc code=start
class Solution {
    public int longestPalindromeSubseq(String s) {
        int length = s.length();
        if(length < 2){
            return length;
        }
        int[][] dp = new int[length][length];
        // 初始化
        for(int i = 0; i < length; i++){
            dp[i][i] = 1;
        }
        // 推导公式需要dp[i + 1][j - 1],  所以需要从大到小遍历
        for(int i = s.length() - 1; i >= 0; i--){
            for(int j = i + 1; j < s.length(); j++){
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][length - 1];
    }
}
// @lc code=end

