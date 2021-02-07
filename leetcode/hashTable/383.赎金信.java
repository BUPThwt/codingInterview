/*
 * @lc app=leetcode.cn id=383 lang=java
 *
 * [383] 赎金信
 */

// @lc code=start
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] words = new int[26];
        for(char c : magazine.toCharArray()){
            words[c - 'a']++;
        }
        for(char c : ransomNote.toCharArray()){
            words[c - 'a']--;
        }
        for(int i : words){
            if(i < 0){
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

