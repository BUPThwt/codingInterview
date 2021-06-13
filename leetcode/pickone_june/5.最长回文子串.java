/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        if(s.length() <= 1){
            return s;
        }
        int length = 1;
        int start = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++){
            dp[i][i] = true;
        }
        for(int i = s.length() - 1; i >= 0; i--){
            for(int j = i + 1; j < s.length(); j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(j - i < 3){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }else{
                    dp[i][j] = false;
                }
                if(dp[i][j] && j - i + 1 > length){
                    start = i;
                    length = j - i + 1;
                }
            }
        }
        return s.substring(start, start + length);
    }
}
// @lc code=end

