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
        if(intervals.length < 2){
            return intervals;
        }
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> ans = new ArrayList<>();
        int[] pre = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] <= pre[1]){
                // 此处要取右边界较大的值
                pre[1] = Math.max(intervals[i][1], pre[1]);
            }else{
                ans.add(pre);
                pre = intervals[i];
            }
        }
        // 最后要添加最后一个合并的区间
        ans.add(pre);
        return ans.toArray(new int[ans.size()][]);
    }
}
// @lc code=end

