/*
 * @lc app=leetcode.cn id=977 lang=java
 *
 * [977] 有序数组的平方
 */

// @lc code=start
class Solution {
    public int[] sortedSquares(int[] A) {
        if(A.length == 0){
            return new int[]{};
        }
        int length = A.length;
        int[] result = new int[A.length];
        for(int i = 0, j = A.length - 1; i <= j;){
            if(A[i] * A[i] > A[j] * A[j]){
                result[--length] = A[i] * A[i];
                i++;
            }else{
                result[--length] = A[j] * A[j];
                j--;
            }
        }
        return result;
    }
}
// @lc code=end

