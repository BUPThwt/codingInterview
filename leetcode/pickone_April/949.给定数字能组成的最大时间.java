/*
 * @lc app=leetcode.cn id=949 lang=java
 *
 * [949] 给定数字能组成的最大时间
 */

// @lc code=start
class Solution {
    public String largestTimeFromDigits(int[] arr) {
        // 暴力法
        int ans = -1;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                if(i != j){
                    for(int k = 0; k < arr.length; k++){
                        if(k != i && k != j){
                            int l = 6 - i - j - k;
                            int hours = arr[i] * 10 + arr[j];
                            int minutes = arr[k] * 10 + arr[l];
                            if(hours < 24 && minutes < 60){
                                ans = Math.max(ans, hours * 60 + minutes);
                            }
                        }
                    }
                }
            }
        }
        return ans == -1 ? "" : String.format("%02d:%02d", ans/60, ans%60);

    }
}
// @lc code=end

