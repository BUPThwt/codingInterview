/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 */

// @lc code=start
class Solution {
    // public void rotate(int[] nums, int k) {
    //     int n = nums.length;
    //     int[] numsCopy = new int[nums.length];
    //     for(int i = 0; i < n; i++){
    //         numsCopy[i] = nums[i];
    //     }
    //     int index = 0;
    //     for(int i = 0; i < n; i++){
    //         index = (i + k) % n;
    //         nums[index] = numsCopy[i];
    //     }
    // }

    int temp = 0;
    public void rotate(int[] nums, int k){
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end){
        while(start < end){
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
        
}
// @lc code=end

