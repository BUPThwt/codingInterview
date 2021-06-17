import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> resultList = new ArrayList<>();
        Arrays.sort(intervals, (o1, o2) -> {
            if(o1[0] < o2[0]){
                return -1;
            }else if(o1[0] == o2[0]){
                return o1[1] - o2[1];
            }else{
                return 1;
            }
        });
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] > end){
                resultList.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }else{
                end = Math.max(end, intervals[i][1]);
            }
        }
        resultList.add(new int[]{start, end});
        int[][] result = new int[resultList.size()][2];
        for(int i = 0; i < resultList.size(); i++){
            result[i] = resultList.get(i);
        }
        return result;
    }
}
// @lc code=end

