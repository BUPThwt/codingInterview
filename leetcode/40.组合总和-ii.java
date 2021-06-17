import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

import jdk.nashorn.internal.runtime.regexp.joni.ast.BackRefNode;

/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start
class Solution {
    List<List<Integer>> result;
    Deque<Integer> path;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList();
        path = new ArrayDeque<>();
        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];
        backTracing(candidates, target, 0, path, used);
        return result;
    }

    private void backTracing(int[] candidates, int target, int start, Deque<Integer> path, boolean[] used){
        if(target < 0){
            return;
        }
        if(target == 0){
            result.add(new ArrayList<>(path));
        }
        for(int i = start; i < candidates.length && target - candidates[i] >= 0; i++){
            if(i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]){
                continue;
            }
            path.offer(candidates[i]);
            used[i] = true;
            backTracing(candidates, target - candidates[i], i + 1, path, used);
            used[i] = false;
            path.removeLast();
        }
    }
}
// @lc code=end

