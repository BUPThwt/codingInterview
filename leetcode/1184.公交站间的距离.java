/*
 * @lc app=leetcode.cn id=1184 lang=java
 *
 * [1184] 公交站间的距离
 */

// @lc code=start
class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int sum = 0;
        for(int dis : distance){
            sum += dis;
        }
        int half = 0;
        if(start < destination){
            for(int i = start; i < destination; i++){
                half += distance[i % distance.length];
            }
        }else{
            for(int i = destination; i < start; i++){
                half += distance[i % distance.length];
            }
        }
        
        return Math.min(half, sum - half);
    }
}
// @lc code=end

