/*
 * @lc app=leetcode.cn id=392 lang=java
 *
 * [392] 判断子序列
 */

// @lc code=start
class Solution {
    // public boolean isSubsequence(String s, String t) {
    //     // dp[i][j]代表以i-1,j-1结尾的最长的字符相等数量
    //     int[][] dp = new int[s.length() + 1][t.length() + 1];
    //     for(int i = 1; i <= s.length(); i++){
    //         for(int j = 1; j <= t.length(); j++){
    //             if(s.charAt(i - 1) == t.charAt(j - 1)){
    //                 dp[i][j] = dp[i - 1][j - 1] + 1;
    //             }else{
    //                 dp[i][j] = dp[i][j - 1];
    //             }
    //         }
    //     }
    //     return dp[s.length()][t.length()] == s.length();
    // }

    // public boolean isSubsequence(String s, String t){
    //     if(s.length() == 0){
    //         return true;
    //     }
    //     int i = 0; int j = 0;
    //     while(i < s.length() && j < t.length()){
    //         if(s.charAt(i) == t.charAt(j)){
    //             i++;
    //         }
    //         j++;
    //     }
    //     return i == s.length();
    // }

    public boolean isSubsequence(String s, String t){
        if(s.length() == 0){
            return true;
        }
        int index = 0;
        for(int i = 0; i < t.length(); i++){
            if(t.charAt(i) == s.charAt(index)){
                index++;
            }
            if(index == s.length()){
                return true;
            }
        }
        return index == s.length();

    }
}
// @lc code=end

