import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[candidates.length];
        backTracing(candidates, target, 0, used, result, path);
        return result;
    }

    private void backTracing(int[] candidates, int target, int startIndex, boolean[] used, List<List<Integer>> result, Deque<Integer> path){
        if(target < 0){
            return;
        }
        if(target == 0){
            result.add(new ArrayList(path));
            return;
        }
        for(int i = startIndex; i < candidates.length && target >= candidates[i]; i++){
            if(i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]){
                continue;
            }
            path.add(candidates[i]);
            used[i] = true;
            backTracing(candidates, target - candidates[i], i + 1, used, result, path);
            used[i] = false;
            path.removeLast();
        }
    }
}
// @lc code=end

