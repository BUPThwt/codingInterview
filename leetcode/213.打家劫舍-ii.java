import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

/*
 * @lc app=leetcode.cn id=213 lang=java
 *
 * [213] 打家劫舍 II
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int val1 = robRange(nums, 0, nums.length - 2);
        int val2 = robRange(nums, 1, nums.length - 1);
        return Math.max(val1, val2);
    }

    private int robRange(int[] nums, int start, int end){
        if(start == end){
            return nums[start];
        }
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        for(int i = start + 2; i <= end; i++){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[end];
    }
}
// @lc code=end

