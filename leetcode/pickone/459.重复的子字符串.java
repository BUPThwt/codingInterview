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
    //     String help = s + s;
    //     return help.substring(1, help.length() - 1).contains(s);
    // }

    public boolean repeatedSubstringPattern(String s){
        if(s.length() < 2){
            return false;
        }
        int[] next = new int[s.length()];
        kmp(next, s);
        // 如果是重复字符串，next有规律，比如abcabcabc  对应的是000123456
        // s.length - next[s.length - 1]正好是重复字段的长度
        return next[s.length() - 1] != 0 && (s.length() % (s.length() - (next[s.length() - 1]))) == 0;
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

