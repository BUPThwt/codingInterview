/*
 * @lc app=leetcode.cn id=319 lang=java
 *
 * [319] 灯泡开关
 */

// @lc code=start
class Solution {
    public int bulbSwitch(int n) {
        // 要经过n轮操作
        // 一个数，经过奇数次开关，最后是开着的
        // 因为一个平方数，它的因子是奇数的，所以他是经历奇数次开关的。
        return (int)Math.sqrt(n);
    }
}
// @lc code=end

