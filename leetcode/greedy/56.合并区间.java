import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.graalvm.compiler.nodes.java.ArrayLengthNode;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length < 2){
            return intervals;
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
        List<int[]> result = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] <= end){
                end = Math.max(end, intervals[i][1]);
            }else{
                result.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        result.add(new int[]{start, end});
        return result.toArray(new int[result.size()][2]);
    }
}
// @lc code=end

