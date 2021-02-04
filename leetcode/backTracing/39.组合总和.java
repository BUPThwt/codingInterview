import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        Arrays.sort(candidates);
        backTracing(candidates, target, 0, result, path);
        return result;
    }

    private void backTracing(int[] candidates, int target, int startIndex, List<List<Integer>> result, Deque<Integer> path){
        if(target < 0){
            return;
        }
        if(target == 0){
            result.add(new ArrayList(path));
            return;
        }
        for(int i = startIndex; i < candidates.length && target - candidates[i] >= 0; i++){
            path.add(candidates[i]);
            backTracing(candidates, target - candidates[i], i, result, path);
            path.removeLast();
        }
    }
}
// @lc code=end

