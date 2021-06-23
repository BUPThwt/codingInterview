import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=442 lang=java
 *
 * [442] 数组中重复的数据
 */

// @lc code=start
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int i = 1; i <= nums.length; i++){
            int num = Math.abs(nums[i - 1]);
            if(nums[num - 1] < 0){
                result.add(num);
            }else{
                nums[num - 1] = -nums[num - 1];
            }
        }
        return result;
    }
}
// @lc code=end

