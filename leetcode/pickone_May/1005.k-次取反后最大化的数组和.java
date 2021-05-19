import java.util.Arrays;

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
        for(int j = 0; j < arr.length; j++){
            while(arr[j] != 0){
                sum += j - 100;
                arr[j]--;
            }
        }
        return sum;
    }
}
// @lc code=end

