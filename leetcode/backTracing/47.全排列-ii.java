import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;



/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
// class Solution {
//     public List<List<Integer>> permuteUnique(int[] nums) {
//         List<List<Integer>> result = new ArrayList<>();
//         Deque<Integer> path = new ArrayDeque<>();
//         boolean[] used = new boolean[nums.length];
//         backTracing(nums, used, result, path);
//         return result;
//     }

//     private void backTracing(int[] nums, boolean[] used, List<List<Integer>> result, Deque<Integer> path){
//         if(path.size() == nums.length){
//             result.add(new ArrayList(path));
//             return;
//         }
//         int[] layerUsed = new int[21];
//         for(int i = 0; i < nums.length; i++){
//             if(used[i] || layerUsed[nums[i] + 10] == 1){
//                 continue;
//             }
//             path.add(nums[i]);
//             layerUsed[nums[i] + 10] = 1;
//             used[i] = true;
//             backTracing(nums, used, result, path);
//             used[i] = false;
//             path.removeLast();
//         }


//     }
// }

class Solution{
    public List<List<Integer>> permuteUnique(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backTracing(nums, used, result, path);
        return result;
    }

    private void backTracing(int[] nums, boolean[] used, List<List<Integer>> result, Deque<Integer> path){
        if(nums.length == path.size()){
            result.add(new ArrayList(path));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){
                continue;
            }
            if(!used[i]){
                path.add(nums[i]);
                used[i] = true;
                backTracing(nums, used, result, path);
                used[i] = false;
                path.removeLast();
            }
        }
    }


}
// @lc code=end

