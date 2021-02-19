import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode.cn id=1005 lang=java
 *
 * [1005] K 次取反后最大化的数组和
 */

// @lc code=start
class Solution {

    // public int largestSumAfterKNegations(int[] A, int K) {
    //     Arrays.sort(A);
    //     int index = 0;
    //     while(index < A.length && K > 0 && A[index] < 0){
    //         A[index++] *= -1;
    //         K--;
    //     }
    //     Arrays.sort(A);
    //     while(K-- > 0){
    //         A[0] *= -1;
    //     }
    //     int ans = 0;
    //     for(int i : A){
    //         ans += i;
    //     }
    //     return ans;
    // }

}
// @lc code=end

