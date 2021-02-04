import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * @lc app=leetcode.cn id=491 lang=java
 *
 * [491] 递增子序列
 */

// @lc code=start
class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        backTracing(nums, 0, result, path);
        return result;
    }

    private void backTracing(int[] nums, int startIndex, List<List<Integer>> result, Deque<Integer> path){
        if(path.size() >= 2){
            result.add(new ArrayList<>(path));
        }
        int[] used = new int[201];
        for(int i = startIndex; i < nums.length; i++){
            if((!path.isEmpty() && path.getLast() > nums[i]) || used[nums[i] + 100] == 1){
                continue;
            }
            path.add(nums[i]);
            used[nums[i] + 100] = 1;
            backTracing(nums, i + 1, result, path);
            path.removeLast();
        }

    }
}
// @lc code=end

