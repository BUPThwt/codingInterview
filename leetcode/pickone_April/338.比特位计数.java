/*
 * @lc app=leetcode.cn id=338 lang=java
 *
 * [338] 比特位计数
 */

// @lc code=start
class Solution {
    // public int[] countBits(int num) {
    //     int[] result = new int[num + 1];
    //     for(int i = 0; i <= num; i++){
    //         result[i] = Integer.bitCount(i);
    //     }
    //     return result;
    // }

    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for(int i = 1; i <= num; i++){
            if(i % 2 == 1){
                result[i] = result[i - 1] + 1;
            }else{
                result[i] = result[(i/2)];
            }
        }
        return result;
    }
}
// @lc code=end

