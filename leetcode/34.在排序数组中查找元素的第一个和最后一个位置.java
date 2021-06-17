/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        //第一个<= target的索引
        int left = binarySearch(nums, target);
        //第一个大于target的索引
        int right = binarySearch(nums, target + 1);
        if(left == nums.length || nums[left] != target){
            return new int[]{-1, -1};
        }
        return new int[]{left, right - 1};
    }

    // 查找第一个>=target的第一个
    private int binarySearch(int[] nums, int target){
        int low = 0;
        int high = nums.length;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(nums[mid] >= target){
                high = mid;
            }else {
                low = mid + 1;
            }
        }
        return low;
    }
}
// @lc code=end

