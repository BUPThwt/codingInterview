import java.util.concurrent.atomic.LongAccumulator;

/*
 * @lc app=leetcode.cn id=633 lang=java
 *
 * [633] 平方数之和
 */

// @lc code=start
class Solution {
    public boolean judgeSquareSum(int c) {
        long low = 0;
        long high = (long)Math.sqrt(c);
        while(low <= high){
            long sum = low * low + high * high;
            if(sum == c){
                return true;
            }else if(sum < c){
                low++;
            }else if(sum > c){
                high--;
            }
        }
        return false;
    }
}
// @lc code=end

