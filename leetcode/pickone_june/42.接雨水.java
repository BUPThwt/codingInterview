import java.util.Stack;

/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    // public int trap(int[] height) {
    //     Stack<Integer> stack = new Stack<>();
    //     int ans = 0;
    //     for(int i = 0; i < height.length; i++){
    //         while(!stack.isEmpty() && height[stack.peek()] < height[i]){
    //             int h = height[stack.peek()];
    //             stack.pop();
    //             if(stack.isEmpty()){
    //                 break;
    //             }
    //             int min = Math.min(height[stack.peek()], height[i]);
    //             int distance = i - stack.peek() - 1;
    //             ans += distance * (min - h);
    //         }
    //         stack.push(i);
    //     }
    //     return ans;
    // }


    // public int trap(int[] height){
    //     int ans = 0;
    //     for(int i = 1; i < height.length - 1; i++){
    //         int leftMax = 0;
    //         int rightMax = 0;
    //         for(int j = 0; j < i; j++){
    //             leftMax = Math.max(leftMax, height[j]);
    //         }
    //         for(int j = i + 1; j < height.length; j++){
    //             rightMax = Math.max(rightMax, height[j]);
    //         }
    //         int min = Math.min(leftMax, rightMax);
    //         if(min > height[i]){
    //             ans += min - height[i];
    //         }
    //     }
    //     return ans;
    // }

    public int trap(int[] height){
        int ans = 0;
        int length = height.length;
        int[] left = new int[length];
        int[] right = new int[length];
        for(int i = 1; i < height.length; i ++){
            left[i] = Math.max(left[i - 1], height[i -1]);
        }
        for(int i = length - 2; i >= 0; i--){
            right[i] = Math.max(right[i + 1], height[i + 1]);
        }
        for(int i = 1; i < length - 1; i ++){
            int min = Math.min(left[i], right[i]);
            if(min > height[i]){
                ans += min - height[i];
            }
        }
        return ans;
    }
}
// @lc code=end

