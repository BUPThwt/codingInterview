import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=945 lang=java
 *
 * [945] 使数组唯一的最小增量
 */

// @lc code=start
class Solution {
    public int minIncrementForUnique(int[] A) {
        int ans = 0;
        Arrays.sort(A);
        for(int i = 1; i < A.length; i++){
            if(A[i] <= A[i - 1]){
                int pre = A[i];
                A[i] = A[i - 1] + 1;
                ans += A[i] - pre;
            }
        }
        return ans;
    }
}
// @lc code=end

