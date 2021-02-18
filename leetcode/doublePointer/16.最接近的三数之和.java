import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int result = 0;
        for(int i = 0; i < nums.length - 2; i ++){
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == target){
                    return target;
                }
                if(Math.abs(sum - target) < diff){
                    diff = Math.abs(sum - target);
                    result = sum;
                }
                if(sum > target){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return result;
    }
}
// @lc code=end

