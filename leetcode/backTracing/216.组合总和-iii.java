import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * @lc app=leetcode.cn id=216 lang=java
 *
 * [216] 组合总和 III
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        backTracing(k, n, 1, result, path);
        return result;
    }

    private void backTracing(int k, int n, int startIndex, List<List<Integer>> result, Deque<Integer> path){
        if(n < 0){
            return;
        }
        if(path.size() == k){
            if(n == 0){
                result.add(new ArrayList(path));
            }
            return;
        }
        for(int i = startIndex; i <= 9 - (k - path.size()) + 1 && n >= i; i++){
            path.add(i);
            backTracing(k, n - i, i + 1, result, path);
            path.removeLast();
        }
    }
}
// @lc code=end

