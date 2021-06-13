/*
 * @lc app=leetcode.cn id=647 lang=java
 *
 * [647] 回文子串
 */

// @lc code=start
class Solution {
    // public int countSubstrings(String s) {
    //     int result = 0;
    //     boolean[][] dp = new boolean[s.length()][s.length()];
    //     for(int i = s.length() - 1; i >= 0; i--){
    //         for(int j = i; j < s.length(); j++){
    //             if(s.charAt(i) == s.charAt(j)){
    //                 if(j - i <= 1){
    //                     result++;
    //                     dp[i][j] = true;
    //                 }else if(dp[i + 1][j - 1]){
    //                     result++;
    //                     dp[i][j] = true;
    //                 }
    //             }
    //         }
    //     }
    //     return result;
    // }

    public int countSubstrings(String s) {
        int result = 0;
        for(int i = 0; i < s.length(); i++){
            result += extend(s, i, i, s.length());
            result += extend(s, i, i + 1, s.length());
        }
        return result;
    }

    private int extend(String s, int start, int end, int length){
        int res = 0;
        while(start >= 0 && end < length && s.charAt(start) == s.charAt(end)){
            start --;
            end++;
            res++;
        }
        return res;
    }
}
// @lc code=end

