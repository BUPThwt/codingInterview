import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        Deque<Integer> path = new ArrayDeque<>();
        backTracing(nums, used, path);
        return result;
    }

    private void backTracing(int[] nums, boolean[] used, Deque<Integer> path){
        if(path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i]){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backTracing(nums, used, path);
            used[i] = false;
            path.removeLast();
        }
    }
}
// @lc code=end

