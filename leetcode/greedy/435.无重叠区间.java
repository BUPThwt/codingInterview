import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=435 lang=java
 *
 * [435] 无重叠区间
 */

// @lc code=start
class Solution {
    // public int eraseOverlapIntervals(int[][] intervals) {
    //     if(intervals.length <= 1){
    //         return 0;
    //     }
    //     Arrays.sort(intervals, (o1, o2) -> {
    //         if(o1[1] < o2[1]){
    //             return -1;
    //         }else if(o1[1] > o2[1]){
    //             return 1;
    //         }else {
    //             return 0;
    //         }
    //     });
    //     int count = 1;
    //     int end = intervals[0][1];
    //     for(int i = 1; i < intervals.length; i++){
    //         if(end <= intervals[i][0]){
    //             count++;
    //             end = intervals[i][1];
    //         }
    //     }
    //     return intervals.length - count;
    // }

    public int eraseOverlapIntervals(int[][] intervals){
        if(intervals.length <= 1){
            return 0;
        }
        Arrays.sort(intervals, (o1, o2) -> {
            if(o1[0] < o2[0]){
                return -1;
            }else if(o1[0] > o2[0]){
                return 1;
            }else {
                return 0;
            }
        });
        int count = 1;
        int start = intervals[intervals.length - 1][0];
        for(int i = intervals.length - 2; i >= 0; i--){
            if(intervals[i][1] <= start){
                count++;
                start = intervals[i][0];
            }
        }
        return intervals.length - count;

    }
}
// @lc code=end

