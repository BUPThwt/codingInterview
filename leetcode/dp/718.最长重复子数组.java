/*
 * @lc app=leetcode.cn id=718 lang=java
 *
 * [718] 最长重复子数组
 */

// @lc code=start
class Solution {
    // public int findLength(int[] A, int[] B) {
    //     int result = 0;
    //     int[][] dp = new int[A.length + 1][B.length + 1];
    //     for(int i = 0; i < A.length; i++){
    //         for(int j = 0; j < B.length; j++){
    //             if(A[i] == B[j]){
    //                 dp[i + 1][j + 1] = dp[i][j] +1;
    //                 result = Math.max(result, dp[i + 1][j + 1]);
    //             }
    //         }
    //     }
    //     return result;
    // }


    public int findLength(int[] A, int[] B){
        int result = 0;
        // dp[i][j] 表示A、B的i-1, j-1结尾，最长相同长度
        int[][] dp = new int[A.length + 1][B.length + 1];
        for(int i = 1; i<= A.length; i++){
            for(int j = 1; j <= B.length; j++){
                if(A[i - 1] == B[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        return result;
    }
}
// @lc code=end

