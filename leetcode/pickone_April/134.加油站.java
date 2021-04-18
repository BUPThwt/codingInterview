/*
 * @lc app=leetcode.cn id=134 lang=java
 *
 * [134] 加油站
 */

// @lc code=start
class Solution {
    // public int canCompleteCircuit(int[] gas, int[] cost) {
    //     int maxCost = 0;
    //     int sum = 0;
    //     for(int i = 0; i < gas.length; i++){
    //         sum += gas[i] - cost[i];
    //         maxCost = Math.min(maxCost, sum);
    //     }
    //     if(sum < 0){
    //         return -1;
    //     }
    //     if(maxCost >= 0){
    //         return 0;
    //     }
    //     for(int i = gas.length - 1; i > 0; i--){
    //         maxCost += gas[i] - cost[i];
    //         if(maxCost >= 0){
    //             return i;
    //         }
    //     }
    //     return -1;
    // }

    // 贪心算法   每一步都选择curSum不小于0的。
    public int canCompleteCircuit(int[] gas, int[] cost){
        int start = 0;
        int sum = 0;
        int curSum = 0;
        for(int i = 0; i < cost.length; i++){
            sum += gas[i] - cost[i];
            curSum += gas[i] - cost[i];
            if(curSum < 0){
                start = i + 1;
                curSum = 0;
            }
        }
        if(sum < 0){
            return -1;
        }
        return start;
    }
}
// @lc code=end

