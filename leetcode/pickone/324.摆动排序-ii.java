import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=324 lang=java
 *
 * [324] 摆动排序 II
 */

// @lc code=start
class Solution {
    public void wiggleSort(int[] nums) {
        int[] help = nums.clone();
        Arrays.sort(help);
        int N = nums.length;
        for(int i = 1; i < nums.length; i += 2){
            nums[i] = help[--N];
        }
        for(int i = 0; i < nums.length; i += 2){
            nums[i] = help[--N];
        }
    }
}
// @lc code=end

