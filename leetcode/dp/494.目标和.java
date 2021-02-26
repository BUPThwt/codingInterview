/*
 * @lc app=leetcode.cn id=494 lang=java
 *
 * [494] 目标和
 */

// @lc code=start
class Solution {
    // x + y = sum;
    // x - y = S;
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum < S){
            return 0;
        }
        if((S + sum) % 2 == 1){
            return 0;
        }
        int target = (S + sum) / 2;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int i = 0; i < nums.length; i++){
            for(int j = target; j >= nums[i]; j--){
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}
// @lc code=end

