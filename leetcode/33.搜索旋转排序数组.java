/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    // public int search(int[] nums, int target) {
    //     for(int i = 0; i < nums.length; i++){
    //         if(nums[i] == target){
    //             return i;
    //         }
    //     }
    //     return -1;
    // }

    public int search(int[] nums, int target){
        if(nums.length < 1){
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target){
                return mid;
            }
            // 前半部分有序
            if(nums[low] <= nums[mid]){
                // 在前半部分
                if(nums[low] <= target && target < nums[mid]){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }else{
                if(nums[mid] < target && target <= nums[high]){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
// @lc code=end

