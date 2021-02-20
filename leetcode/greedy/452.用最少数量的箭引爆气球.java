import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=452 lang=java
 *
 * [452] 用最少数量的箭引爆气球
 */

// @lc code=start
class Solution {
    public int findMinArrowShots(int[][] points) {
        int ans = 1;
        if(points.length <= 1){
            return points.length;
        }
        Arrays.sort(points, (o1, o2) -> {
            if(o1[0] < o2[0]){
                return -1;
            }else if(o1[0] > o2[0]){
                return 1;
            }else {
                return 0;
            }
        });
        int end = points[0][1];
        for(int i = 1; i < points.length; i++){
            if(points[i][0] <= end){
                end = Math.min(end, points[i][1]);
            }else{
                ans++;
                end = points[i][1];
            }
        }
        return ans;

    }
}
// @lc code=end

