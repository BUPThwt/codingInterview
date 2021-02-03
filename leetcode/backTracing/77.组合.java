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
        Deque<Integer> path = new ArrayDeque<>();
        backTracing(n, k, 1, result, path);
        return result;
    }
    
    private void backTracing(int n, int k, int startIndex, List<List<Integer>> result, Deque<Integer> path){
        if(k == path.size()){
            result.add(new ArrayList(path));
            return;
        }
        for(int i = startIndex; i <= n - (k - path.size()) + 1; i++){
            path.add(i);
            backTracing(n, k, i + 1, result, path);
            path.removeLast();
        }
    }
}
// @lc code=end

