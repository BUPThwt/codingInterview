import java.util.Arrays;

import jdk.nashorn.internal.runtime.arrays.IntElements;

/*
 * @lc app=leetcode.cn id=1509 lang=java
 *
 * [1509] 三次操作后最大值与最小值的最小差
 */

// @lc code=start
class Solution {
    public int minDifference(int[] nums) {
        if(nums.length <= 4){
            return 0;
        }
        int n = nums.length;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        // 有4种方案，移除3个最小值；移除2最小，1最大；移除1最小，2最大；移除3最大
        for(int i = 0; i <= 3; i++){
            min = Math.min(nums[n - 1 - i] - nums[3 - i], min);
        }
        return min;
    }
}
// @lc code=end

