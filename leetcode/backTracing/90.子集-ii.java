
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;


/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        Arrays.sort(nums);
        backTracing(nums, 0, result, path);
        return result;
    }

    // private void backTracing(int[] nums, int startIndex, List<List<Integer>> result, Deque<Integer> path){
    //     result.add(new ArrayList(path));
    //     Set<Integer> set = new HashSet<>();
    //     for(int i = startIndex; i < nums.length; i++){
    //        if(set.contains(nums[i])){
    //            continue;
    //        }
    //        path.add(nums[i]);
    //        set.add(nums[i]);
    //        backTracing(nums, i + 1, result, path);
    //        path.removeLast();
    //     }
    // }

    private void backTracing(int[] nums, int startIndex, List<List<Integer>> result, Deque<Integer> path){
        result.add(new ArrayList(path));
        
        for(int i = startIndex; i < nums.length; i++){
           if(i > startIndex && nums[i] == nums[i - 1]){
               continue;
           }
           path.add(nums[i]);
           backTracing(nums, i + 1, result, path);
           path.removeLast();
        }
    }
}
// @lc code=end

