import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {
    List<List<Integer>> result;
    Deque<Integer> path;
    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new ArrayList<>();
        path = new ArrayDeque<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backTracing(nums, used, path);
        return result;
    }

    private void backTracing(int[] nums, boolean[] used, Deque<Integer> path){
        if(path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){
                continue;
            }
            if(!used[i]){
                path.add(nums[i]);
                used[i] = true;
                backTracing(nums, used, path);
                used[i] = false;
                path.removeLast();
            }
        }
    }
}
// @lc code=end

