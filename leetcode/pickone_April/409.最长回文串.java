import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=409 lang=java
 *
 * [409] 最长回文串
 */

// @lc code=start
class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        boolean hasOdd = false;
        int count = 0;
        for(char c : map.keySet()){
            if(!hasOdd){
                hasOdd = map.get(c)%2 == 1;
            }
            count += map.get(c) / 2;
        }
        return count * 2 + (hasOdd ? 1 : 0);
    }
}
// @lc code=end

