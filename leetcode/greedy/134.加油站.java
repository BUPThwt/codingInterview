import org.ietf.jgss.GSSContext;

/*
 * @lc app=leetcode.cn id=134 lang=java
 *
 * [134] 加油站
 */

// @lc code=start
class Solution {
    // public int canCompleteCircuit(int[] gas, int[] cost) {
    //     int totalSum = 0;
    //     int curSum = 0;
    //     int ans = 0;
    //     for(int i = 0; i < gas.length; i++){
    //         totalSum += gas[i] - cost[i];
    //         curSum += gas[i] - cost[i];
    //         if(curSum < 0){
    //             ans = i + 1;
    //             curSum = 0;
    //         }
    //     }
    //     if(totalSum < 0){
    //         return -1;
    //     }
    //     return ans;
    // }

    public int canCompleteCircuit(int[] gas, int[] cost){
        int curSum = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < gas.length; i++){
            curSum += gas[i] - cost[i];
            min = Math.min(min, curSum);
        }
        if(curSum < 0){
            return -1;
        }
        if(min >= 0){
            return 0;
        }
        for(int i = gas.length - 1; i > 0; i--){
            min += gas[i] - cost[i];
            if(min >= 0){
                return i;
            }
        }
        return -1;
    }
}
// @lc code=end

