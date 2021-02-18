import java.util.ArrayDeque;
import java.util.Deque;


/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < k; i++){
            while(!deque.isEmpty() && deque.peekLast() < nums[i]){
                deque.pollLast();
            }
            deque.offer(nums[i]);
        }
        int index = 0;
        ans[index++] = deque.peekFirst();
        for(int i = k; i < nums.length; i++){
            if(deque.peekFirst() == nums[i - k]){
                deque.pollFirst();
            }
            while(!deque.isEmpty() && deque.peekLast() < nums[i]){
                deque.pollLast();
            }
            deque.offer(nums[i]);
            ans[index++] = deque.peekFirst();
        }
        return ans;
    }
}
// @lc code=end

