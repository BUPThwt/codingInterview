/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现 strStr()
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0){
            return 0;
        }
        int[] next = kmp(needle);
        int j = 0;
        for(int i = 0; i < haystack.length(); i++){
            while(j > 0 && haystack.charAt(i) != needle.charAt(j)){
                j = next[j - 1];
            }
            if(haystack.charAt(i) == needle.charAt(j)){
                j++;
            }
            if(j == needle.length()){
                return i - j + 1;
            }
        }
        return -1;
    }

    private int[] kmp(String s){
        int[] next = new int[s.length()];
        int j = 0;
        next[0] = 0;
        for(int i = 1; i < s.length(); i++){
            while(j > 0 && s.charAt(i) != s.charAt(j)){
                j = next[j - 1];
            }
            if(s.charAt(i) == s.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
// @lc code=end

