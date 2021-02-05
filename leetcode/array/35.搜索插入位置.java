/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution {
    // 只要遍历到nums[i]>= target，那么i就是应该插入的位置
    // 对于空数组或者target比任何都大时，返回数组长度。
    // public int searchInsert(int[] nums, int target) {
    //     for(int i = 0; i < nums.length; i++){
    //         if(nums[i] >= target){
    //             return i;
    //         }
    //     }
    //     return nums.length;
    // }

    // 根据区间来判断
    // public int searchInsert(int[] nums, int target) {
    //     int n = nums.length;
    //     int left = 0;
    //     int right = n;
    //     while(left < right){
    //         int middle = left + (right - left) / 2;
    //         if(nums[middle] < target){
    //             left = middle + 1;
    //         }else if(nums[middle] > target){
    //             right = middle;
    //         }else{
    //             return middle;
    //         }
    //     }
    //     return right;
    // }

    public int searchInsert(int[] nums, int target){
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while(left <= right){
            int middle = left + (right - left) / 2;
            if(nums[middle] < target){
                left = middle + 1;
            }else if(nums[middle] > target){
                right = middle - 1;
            }else{
                return middle;
            }
        }
        return right + 1;
    }



}
// @lc code=end

