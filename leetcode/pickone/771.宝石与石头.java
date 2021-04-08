import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=771 lang=java
 *
 * [771] 宝石与石头
 */

// @lc code=start
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int ans = 0;
        Set<Character> set = new HashSet<>();
        for(char c : jewels.toCharArray()){
            set.add(c);
        }
        for(char s : stones.toCharArray()){
            if(set.contains(s)){
                ans++;
            }
        }
        return ans;
    }
}
// @lc code=end

