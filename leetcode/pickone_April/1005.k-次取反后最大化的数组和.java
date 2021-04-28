/*
 * @lc app=leetcode.cn id=1005 lang=java
 *
 * [1005] K 次取反后最大化的数组和
 */

// @lc code=start
class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        int[] arr = new int[201];
        for(int a : A){
            arr[a + 100]++;
        }
        int i = 0;
        while(K > 0){
            while(arr[i] == 0){
                i++;
            }
            arr[i]--;
            arr[200 - i]++;
            if(i > 100){
                i = 200 - i;
            }
            K--;
        }
        int sum = 0;
        for(int j = i; j < arr.length; j++){
            sum += arr[j] * (j - 100);
        }
        return sum;
    }
}
// @lc code=end

