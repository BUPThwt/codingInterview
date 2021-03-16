import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1403 lang=java
 *
 * [1403] 非递增顺序的最小子序列
 */

// @lc code=start
class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int sum = 0;
        Arrays.sort(nums);
        for(int num : nums){
            sum += num;
        }
        int target = sum / 2 + 1;
        for(int i = nums.length - 1; i >= 0; i--){
            target -= nums[i];
            result.add(nums[i]);
            if(target <= 0){
                return result;
            }
        }
        return result;
    }
}
// @lc code=end

