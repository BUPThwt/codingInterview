import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1200 lang=java
 *
 * [1200] 最小绝对差
 */

// @lc code=start
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        int minAbs = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for(int i = 1; i < arr.length; i++){
            minAbs = Math.min(arr[i] - arr[i - 1], minAbs);
        }
        for(int i = 1; i < arr.length; i++){
            if(minAbs == arr[i] - arr[i - 1]){
                result.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }
        return result;
    }
}
// @lc code=end

