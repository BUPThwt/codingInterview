/*
 * @lc app=leetcode.cn id=810 lang=java
 *
 * [810] 黑板异或游戏
 */

// @lc code=start
class Solution {
    public boolean xorGame(int[] nums) {
        //纯数学
        int num = 0 ;
        for(int i : nums){
            num ^= i;
        }
        return num == 0 || nums.length % 2 == 0;

    }
}
// @lc code=end

