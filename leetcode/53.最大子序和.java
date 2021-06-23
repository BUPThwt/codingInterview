/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 */

// @lc code=start
class Solution {
    // public int maxSubArray(int[] nums) {
    //     int[] dp = new int[nums.length];
    //     dp[0] = nums[0];
    //     int result = nums[0];
    //     for(int i = 1; i < nums.length; i++){
    //         dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
    //         result = Math.max(result, dp[i]);
    //     }
    //     return result;
    // }

    public int maxSubArray(int[] nums){
        int result = nums[0];
        int sum = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(sum < 0){
                sum = nums[i];
            }else{
                sum += nums[i];
            }
            result = Math.max(result, sum);
        }
        return result;
    }
}
// @lc code=end

