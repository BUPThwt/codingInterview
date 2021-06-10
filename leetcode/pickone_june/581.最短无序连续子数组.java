import java.util.Arrays;
import java.util.Stack;
import java.util.logging.LogRecord;

/*
 * @lc app=leetcode.cn id=581 lang=java
 *
 * [581] 最短无序连续子数组
 */

// @lc code=start
class Solution {
    // public int findUnsortedSubarray(int[] nums) {
    //     Stack<Integer> stack = new Stack<>();
    //     int left = nums.length - 1;
    //     int right = 0;
    //     for(int i = 0; i < nums.length; i++){
    //         while(!stack.isEmpty() && nums[i] < nums[stack.peek()]){
    //             left = Math.min(left, stack.peek());
    //             stack.pop();
    //         }
    //         stack.push(i);
    //     }
    //     stack.clear();
    //     for(int i = nums.length - 1; i >= 0; i--){
    //         while(!stack.isEmpty() && nums[i] > nums[stack.peek()]){
    //             right = Math.max(right, stack.peek());
    //             stack.pop();
    //         }
    //         stack.push(i);
    //     }
    //     return right > left ? right - left + 1 : 0;
    // }

    public int findUnsortedSubarray(int[] nums){
        int[] num2 = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            num2[i] = nums[i];
        }
        Arrays.sort(num2);
        int left = nums.length - 1;
        int right = 0;
        for(int i = 0; i < nums.length; i++){
            if(num2[i] != nums[i]){
                left = Math.min(left, i);
                right = Math.max(right, i);
            }
        }
        return right > left ? right - left + 1 : 0;
    }
        
}
// @lc code=end

