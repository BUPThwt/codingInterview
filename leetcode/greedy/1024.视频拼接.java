import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1024 lang=java
 *
 * [1024] 视频拼接
 */

// @lc code=start
class Solution {
    public int videoStitching(int[][] clips, int T) {
        if(T == 0){
            return 0;
        }
        // 排序，按照
        Arrays.sort(clips, (a, b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        int i = 0, n = clips.length;
        int curEnd = 0, nextEnd = 0;
        int resp = 0;
        // 避免中间断了
        while(i < n && clips[i][0] <= curEnd){
            // 为了寻找起点小于curEnd中，终点最大的。
            while(i < n && clips[i][0] <= curEnd){
                nextEnd = Math.max(nextEnd, clips[i][1]);
                i++;
            }
            resp++;
            curEnd = nextEnd;
            if(curEnd >= T){
                return resp;
            }
        }
        return -1;
    }
}
// @lc code=end

