import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[nums.length];
        backTracing(nums, used, result, path);
        return result;
    }

    private void backTracing(int[] nums, boolean[] used, List<List<Integer>> result, Deque<Integer> path){
        if(nums.length == path.size()){
            result.add(new ArrayList(path));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i]){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backTracing(nums, used, result, path);
            used[i] = false;
            path.removeLast();
        }
    }
}
// @lc code=end

