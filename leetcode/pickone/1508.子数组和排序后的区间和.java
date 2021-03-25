import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=1508 lang=java
 *
 * [1508] 子数组和排序后的区间和
 */

// @lc code=start
class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        // 队列中  第0位是指，第1位是表示原数组顺序中加到第几位了
        int MOD = 1_000_000_007;
        PriorityQueue<int[]> queue = new PriorityQueue<>(n, (a, b) -> Integer.compare(a[0], b[0]));
        long ans = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            queue.offer(new int[]{nums[i], i});
        }
        while(++count <= right && !queue.isEmpty()){
            int[] cur = queue.poll();
            if(count >= left){
                ans = (ans + cur[0]) % MOD;
            }
            if(cur[1] < n - 1){
                queue.offer(new int[]{cur[0] + nums[cur[1] + 1], cur[1] + 1});
            }
        }
        return Math.toIntExact(ans);
    }
}
// @lc code=end

