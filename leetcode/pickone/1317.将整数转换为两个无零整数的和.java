/*
 * @lc app=leetcode.cn id=1317 lang=java
 *
 * [1317] 将整数转换为两个无零整数的和
 */

// @lc code=start
class Solution {
    public int[] getNoZeroIntegers(int n) {
        for(int i = 1; i < n; i++){
            if(isNoZeroInteger(i) && isNoZeroInteger(n - i)){
                return new int[]{i, n - i};
            }
        }
        return new int[]{};
    }

    private boolean isNoZeroInteger(int n){
        while(n > 0){
            if(n % 10 ==0){
                return false;
            }
            n /= 10;
        }
        return true;
    }
}
// @lc code=end

