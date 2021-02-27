/*
 * @lc app=leetcode.cn id=172 lang=java
 *
 * [172] 阶乘后的零
 */

// @lc code=start
class Solution {
    // public int trailingZeroes(int n) {
    //     if(n == 0){
    //         return 0;
    //     }
    //     int ans = 0;
    //     for(int i = 5; i <= n; i += 5){
    //         int num = i;
    //         while(num % 5 == 0){
    //             ans++;
    //             num /= 5;
    //         }
    //     }
    //     return ans;
    // }

    public int trailingZeroes(int n){
        int count = 0;
        while(n > 0){
            count += n / 5;
            n = n / 5;
        }
        return count;
    }
}
// @lc code=end

