/*
 * @lc app=leetcode.cn id=376 lang=java
 *
 * [376] 摆动序列
 */

// @lc code=start
class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length < 2){
            return nums.length;
        }
        int result = 1;
        int preDiff = 0;
        int curDiff = 0;
        for(int i = 1; i < nums.length; i++){
            curDiff = nums[i] - nums[i - 1];
            if((preDiff <= 0 && curDiff > 0) || (preDiff >= 0 && curDiff < 0)){
                result++;
                preDiff = curDiff;
            }
        }
        return result;
    }
}
// @lc code=end

