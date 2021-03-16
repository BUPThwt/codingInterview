import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1542 lang=java
 *
 * [1542] 找出最长的超赞子字符串
 */

// @lc code=start
class Solution {
    public int longestAwesome(String s) {
        int[] pre = new int[1 << 11];
        int ans = 0;
        int n = s.length();
        int status = 0;
        Arrays.fill(pre, -2);
        pre[status] = -1;
        for(int i = 0; i < n; i++){
            status ^= 1 << (s.charAt(i) - '0');
            if(pre[status] != -2){
                ans = Math.max(ans, i - pre[status]);
            }else{
                pre[status] = i;
            }
            for(int j = 0; j < 10; j++){
                int status1 = status ^ (1 << j);
                if(pre[status1] != -2){
                    ans = Math.max(ans, i - pre[status1]);
                }
            }
        }
        return ans;
    }

}
// @lc code=end

