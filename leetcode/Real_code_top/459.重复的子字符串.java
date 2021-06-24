/*
 * @lc app=leetcode.cn id=459 lang=java
 *
 * [459] 重复的子字符串
 */

// @lc code=start
class Solution {
    // public boolean repeatedSubstringPattern(String s) {
    //     if(s.length() < 2){
    //         return false;
    //     }
    //     int[] next = kmp(s);
    //     if(next[s.length() - 1] != 0 && s.length() % (s.length() - next[s.length() - 1]) == 0){
    //         return true;
    //     }
    //     return false;
    // }

    // private int[] kmp(String s){
    //     int[] next = new int[s.length()];
    //     int j = 0; 
    //     next[0] = 0;
    //     for(int i = 1; i < s.length(); i++){
    //         while(j > 0 && s.charAt(i) != s.charAt(j)){
    //             j = next[j - 1];
    //         }
    //         if(s.charAt(i) == s.charAt(j)){
    //             j++;
    //         }
    //         next[i] = j;
    //     }
    //     return next;
    // }

    public boolean repeatedSubstringPattern(String s) {
        String ss = s + s;
        return ss.substring(1, ss.length() - 1).contains(s);
    }
}
// @lc code=end

