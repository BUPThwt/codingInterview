import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.xml.namespace.QName;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {
    List<List<Integer>> result;
    List<Integer> path;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList();
        path = new LinkedList();
        Arrays.sort(candidates);
        backTracing(candidates, 0, target, path);
        return result;
    }

    private void backTracing(int[] candidates, int start, int target, List<Integer> path){
        if(target == 0){
            result.add(new ArrayList<>(path));
        }
        for(int i = start; i < candidates.length && target - candidates[i] >= 0; i++){
            path.add(candidates[i]);
            backTracing(candidates, i, target - candidates[i], path);
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end

