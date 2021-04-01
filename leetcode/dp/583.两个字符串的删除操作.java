/*
 * @lc app=leetcode.cn id=583 lang=java
 *
 * [583] 两个字符串的删除操作
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        // dp[i][j]  以i-1 j-1结尾的word1, word2相等最少需要删除的操作数
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        // 因为是以i-1结尾，等号不能少
        // 一方为0.另一方需要都删除。
        for(int i = 0; i <= word1.length(); i++){
            dp[i][0] = i;
        }
        for(int j = 0; j <= word2.length(); j++){
            dp[0][j] = j;
        }
        // 如果相等，则与dp[i - 1][j - 1]相等
        // 如果不相等，删除word1或者word2,或者二者都删除，取最小的。
        for(int i = 1; i <= word1.length(); i++){
            for(int j = 1; j <= word2.length(); j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 2, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
// @lc code=end

