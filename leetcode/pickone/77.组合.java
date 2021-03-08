import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backTracing(k, 1, n, new ArrayDeque<Integer>(), result);
        return result;
    }

    private void backTracing(int k, int start, int n, Deque<Integer> ans, List<List<Integer>> result){
        if(ans.size() == k){
            result.add(new ArrayList(ans));
            return;
        }
        for(int i = start; i <= n; i++){
            ans.add(i);
            backTracing(k, i + 1, n, ans, result);
            ans.removeLast();
        }
    }
}
// @lc code=end

