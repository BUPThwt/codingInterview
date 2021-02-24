
import java.util.Arrays;


/*
 * @lc app=leetcode.cn id=1005 lang=java
 *
 * [1005] K 次取反后最大化的数组和
 */

// @lc code=start
class Solution {

    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int i = 0;
        while (i < A.length && K > 0) {
            if (A[i] < 0) {
                A[i] *= -1;
                K--;
            } else {
                break;
            }
            i++;
        }
        Arrays.sort(A);
        while (K-- > 0) {
            A[0] *= -1;
        }
        int sum = 0;
        for (int j : A) {
            sum += j;
        }
        return sum;
    }

    // public int largestSumAfterKNegations(int[] A, int K) {
    //     Arrays.sort(A, (o1, o2) -> {
    //         if(Math.abs(o1) > Math.abs(o2)){
    //             return -1;
    //         }else if(Math.abs(o1) < Math.abs(o2)){
    //             return 1;
    //         }else{
    //             return 0;
    //         }
    //     });
    //     int i = 0;
    //     while (K-- > 0 && i < A.length) {
    //         if (A[i] < 0) {
    //             A[i] *= -1;
    //         }
    //         i++;
    //     }
    //     while (K-- > 0) {
    //         A[A.length - 1] *= -1;
    //     }
    //     int sum = 0;
    //     for (int a : A) {
    //         sum += a;
    //     }
    //     return sum;
    // }

}
// @lc code=end
