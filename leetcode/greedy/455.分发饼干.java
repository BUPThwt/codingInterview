import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=455 lang=java
 *
 * [455] 分发饼干
 */

// @lc code=start
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int index = 0;
        for(int i = 0; i < s.length; i++){
            if(s[i] >= g[index]){
                index++;
            }
            if(index >= g.length){
                break;
            }
        }
        return index;
    }
}
// @lc code=end

