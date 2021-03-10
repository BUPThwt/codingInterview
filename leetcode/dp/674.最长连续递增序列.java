import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=674 lang=java
 *
 * [674] 最长连续递增序列
 */

// @lc code=start
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length < 2){
            return nums.length;
        }
        int ans = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i - 1]){
                dp[i] = dp[i - 1] + 1;
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }


    // 贪心
    // public int findLengthOfLCIS(int[] nums){
    //     if(nums.length <= 1){
    //         return nums.length;
    //     }
    //     int ans = 1;
    //     int count = 1;
    //     for(int i = 1; i < nums.length; i++){
    //         if(nums[i] > nums[i - 1]){
    //             count++;
    //         }else{
    //             count = 1;
    //         }
    //         ans = Math.max(count, ans);
    //     }
    //     return ans;
    // }
}
// @lc code=end

