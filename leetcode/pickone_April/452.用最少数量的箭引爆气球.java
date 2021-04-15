import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=452 lang=java
 *
 * [452] 用最少数量的箭引爆气球
 */

// @lc code=start
class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length < 2){
            return points.length;
        }
        // 比较函数要详细写，避免integer溢出
        Arrays.sort(points, (o1, o2) -> {
            if(o1[0] < o2[0]){
                return -1;
            }else if(o1[0] == o2[0]){
                return 0;
            }else{
                return 1;
            }
        });
        int end = points[0][1];
        int ans = 0;
        for(int i = 1; i < points.length; i++){
            if(points[i][0] <= end){
                end = Math.min(end, points[i][1]);
            }else{
                ans++;
                end = points[i][1];
            }
        }
        // 最后一个区间需要一支箭，也可以ans++放到前面，默认需要一支箭
        ans++;
        return ans;
    }
    
}
// @lc code=end

