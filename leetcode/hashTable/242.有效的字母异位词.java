/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] map = new int[26];
        for(char c : s.toCharArray()){
            map[c - 'a']++;
        }
        for(char c : t.toCharArray()){
            map[c - 'a']--;
        }
        for(int i = 0; i < map.length; i++){
            if(map[i] != 0){
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

