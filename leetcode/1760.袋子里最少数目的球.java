import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=1760 lang=java
 *
 * [1760] 袋子里最少数目的球
 */

// @lc code=start
class Solution {
    // 思路错的
    // public int minimumSize(int[] nums, int maxOperations) {
    //     PriorityQueue<Integer> queue = new PriorityQueue<Integer>(nums.length + maxOperations, (o1, o2) -> o2 - o1);
    //     for(int i = 0; i < nums.length; i++){
    //         queue.offer(nums[i]);
    //     }
    //     while(maxOperations > 0){
    //         maxOperations--;
    //         int num = queue.poll();
    //         queue.offer(num / 2);
    //         queue.offer(num - num / 2);
    //     }
    //     return queue.poll();
    // }

    public int minimumSize(int[] nums, int maxOperations){
        
}
// @lc code=end

