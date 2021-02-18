/*
 * @lc app=leetcode.cn id=459 lang=java
 *
 * [459] 重复的子字符串
 */

// @lc code=start
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if(s.length() < 2){
            return false;
        }
        int[] next = new int[s.length()];
        kmp(next, s);
        int len = s.length();
        if(next[len - 1] != 0 && len % (len - next[len - 1]) == 0){
            return true;
        }
        return false;
    }

    private void kmp(int[] next, String s){
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
    }
}
// @lc code=end

