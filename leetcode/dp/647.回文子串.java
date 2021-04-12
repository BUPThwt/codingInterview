/*
 * @lc app=leetcode.cn id=647 lang=java
 *
 * [647] 回文子串
 */

// @lc code=start
class Solution {
    // public int countSubstrings(String s) {
    //     if(s.length() == 0){
    //         return 0;
    //     }
    //     boolean[][] dp = new boolean[s.length()][s.length()];
    //     int result = 0;
    //     for(int i = s.length() - 1; i >= 0; i--){
    //         for(int j = i; j < s.length(); j++){
    //             if(s.charAt(i) == s.charAt(j)){
    //                 if(j - i <= 1){
    //                     result++;
    //                     dp[i][j] = true;
    //                 }else{
    //                     if(i + 1 < s.length() && j - 1 >= 0 && dp[i + 1][j - 1]){
    //                         result++;
    //                         dp[i][j] = true;
    //                     }
    //                 }
    //             }
    //         }
    //     }
    //     return result;
    // }

    int length = 0;
    public int countSubstrings(String s){
        length = s.length();
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            count += extend(s, i, i);
            count += extend(s, i, i + 1);
        }
        return count;
    }

    private int extend(String s, int i, int j){
        int ans = 0;
        while(i >= 0 && j < length && s.charAt(i) == s.charAt(j)){
            ans++;
            i--;
            j++;
        } 
        return ans;
    }
}
// @lc code=end

