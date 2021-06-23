/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 */

// @lc code=start
class Solution {
    // public int mySqrt(int x) {
    //     if(x == 0 || x == 1){
    //         return x;
    //     }
    //     int i = 1;
    //     while(i <= x / i){
    //         i++;
    //     }
    //     return i - 1;

    // }

    public int mySqrt(int x){
        if(x == 0 || x == 1){
            return x;
        }
        int low = 1; 
        int high = x / 2;
        while(low < high){
            int mid = low + (high - low + 1) / 2;
            if(mid > x / mid){
                high = mid - 1;
            }else{
                low = mid;
            }
        }
        return low;
    }

}
// @lc code=end

