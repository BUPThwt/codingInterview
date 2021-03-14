/*
 * @lc app=leetcode.cn id=1304 lang=java
 *
 * [1304] 和为零的N个唯一整数
 */

// @lc code=start
class Solution {
    public int[] sumZero(int n) {
        int[] result = new int[n];
        int index = 0;
        for(int i = 1; i <= n / 2; i++){
            result[index++] = i;
            result[index++] = -i;
        }
        return result;
    }
}
// @lc code=end

