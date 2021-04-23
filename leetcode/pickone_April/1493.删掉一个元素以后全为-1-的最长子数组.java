/*
 * @lc app=leetcode.cn id=1493 lang=java
 *
 * [1493] 删掉一个元素以后全为 1 的最长子数组
 */

// @lc code=start
class Solution {
    public int longestSubarray(int[] nums) {
        int start = 0;
        int end = 0;
        int maxLength = 0;
        int zeroCount = 0;
        while(end < nums.length){
            if(nums[end] == 0){
                zeroCount++;
            }
            while(zeroCount > 1){
                if(nums[start] == 0){
                    zeroCount--;
                }
                start++;
            }
            // 必须要删除一个元素，所以end++在最后，
            // 或者可以end++在前，  length处理的时候用end-start +1
            maxLength = Math.max(maxLength, end - start);
            end++;
        }
        return maxLength;
    }
}
// @lc code=end

