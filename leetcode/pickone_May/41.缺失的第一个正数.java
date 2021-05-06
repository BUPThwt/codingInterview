/*
 * @lc app=leetcode.cn id=41 lang=java
 *
 * [41] 缺失的第一个正数
 */

// @lc code=start
class Solution {
    // 空间复杂度不符合，超时了
    // public int firstMissingPositive(int[] nums) {
    //     int max = Integer.MIN_VALUE;
    //     for(int num : nums){
    //         max = Math.max(max, num);
    //     }
    //     if(max <= 0){
    //         return 1;
    //     }
    //     int[] hash = new int[max];
    //     for(int num : nums){
    //         if(num > 0 && num != max){
    //             hash[num] = 1;
    //         }
    //     }
    //     for(int i = 1; i < hash.length; i++){
    //         if(hash[i] == 0){
    //             return i;
    //         }
    //     }
    //     return max + 1;
    // }


    public int firstMissingPositive(int[] nums){
        int length = nums.length;
        for(int i = 0; i < length; i++){
            while(nums[i] > 0 && nums[i] <= length && nums[nums[i] - 1] != nums[i]){
                swap(nums, nums[i] - 1, i);
            }
        }
        for(int i = 0; i < length; i++){
            if(nums[i] != i + 1){
                return i + 1;
            }
        }
        return length + 1;

    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end

