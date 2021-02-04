import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
       List<List<Integer>> result = new ArrayList<>();
       Deque<Integer> path = new ArrayDeque<>();
       backTracing(nums, 0, result, path);
       return result; 
    }

    private void backTracing(int[] nums, int startIndex, List<List<Integer>> result, Deque<Integer> path){
        
        result.add(new ArrayList(path));
        
        for(int i = startIndex; i < nums.length; i++){
            path.add(nums[i]);
            backTracing(nums, i + 1, result, path);
            path.removeLast();
        }
    }
}
// @lc code=end

