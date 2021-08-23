import java.util.LinkedList;

import javafx.scene.chart.StackedAreaChart;

/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length < 2){
            return nums;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        for(int i = 0; i < nums.length; i++){
            while(!queue.isEmpty() && nums[queue.peekLast()] < nums[i]){
                queue.pollLast();
            }
            queue.add(i);
            if(i - k >= queue.peek()){
                queue.poll();
            }
            if(i - k + 1 >= 0){
                result[i - k + 1] = nums[queue.peek()];
            }
        }
        return result;
    }
}
// @lc code=end

