import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1371 lang=java
 *
 * [1371] 每个元音包含偶数次的最长子字符串
 */

// @lc code=start
class Solution {
    public int findTheLongestSubstring(String s) {
        int[] status = new int[32];
        Arrays.fill(status, Integer.MAX_VALUE);
        status[0] = -1;
        int ans = 0;
        int cur = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            switch(ch){
                case 'a': cur ^= 1; break;
                case 'e': cur ^= 2; break;
                case 'i': cur ^= 4; break;
                case 'o': cur ^= 8; break;
                case 'u': cur ^= 16; break;
            }
            if(status[cur] == Integer.MAX_VALUE){
                status[cur] = i;
            }else{
                ans = Math.max(ans, i - status[cur]);
            }
        }
        return ans;
    }
}
// @lc code=end

