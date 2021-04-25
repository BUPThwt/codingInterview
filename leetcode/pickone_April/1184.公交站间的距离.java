/*
 * @lc app=leetcode.cn id=1184 lang=java
 *
 * [1184] 公交站间的距离
 */

// @lc code=start
class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if(start == destination){
            return 0;
        }
        int sum = 0;
        int dis = 0;
        if(start > destination){
            int temp = start;
            start = destination;
            destination = temp;
        }
        for(int i = 0; i < distance.length; i++){
            sum += distance[i];
            if(i >= start && i < destination){
                dis += distance[i];
            }
        }
        return Math.min(dis, sum - dis);

    }
}
// @lc code=end

