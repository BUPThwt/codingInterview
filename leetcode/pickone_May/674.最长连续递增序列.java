/*
 * @lc app=leetcode.cn id=674 lang=java
 *
 * [674] 最长连续递增序列
 */

// @lc code=start
class Solution {
    // public int findLengthOfLCIS(int[] nums) {
    //     if(nums.length <= 1){
    //         return nums.length;
    //     }
    //     int result = 0;
    //     int cur = 1;
    //     for(int i = 1; i < nums.length; i++){
    //         if(nums[i] > nums[i - 1]){
    //             cur++;
    //         }else{
    //             result = Math.max(result, cur);
    //             cur = 1;
    //         }
    //     }
    //     return Math.max(result, cur);
    // }

    // 滑动窗口
    public int findLengthOfLCIS(int[] nums){
        if(nums.length <= 1){
            return nums.length;
        }
        int result = 1;
        int left = 0;
        int right = 1;
        for(; right < nums.length; right++){
            while(right < nums.length && nums[right] > nums[right - 1]){
                right++;
            }
            result = Math.max(result, right - left);
            left = right;
        }
        return result;
    }
}
// @lc code=end

