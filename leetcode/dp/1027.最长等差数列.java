import java.util.HashMap;
import java.util.Map;

import jdk.nashorn.internal.ir.IdentNode;

/*
 * @lc app=leetcode.cn id=1027 lang=java
 *
 * [1027] 最长等差数列
 */

// @lc code=start
class Solution {
    public int longestArithSeqLength(int[] A) {
        if(A.length < 3){
            return A.length;
        }
        // dp[i]中存的是各差值的最长子序列长度
        // 从小到大遍历，存储前面各差值的最长子序列
        // 如果差值存在，则+1保存，不存在，则设置初始值2
        int ans = 2;
        Map<Integer, Integer>[] dp = new HashMap[A.length];
        for(int i = 0; i < A.length; i++){
            dp[i] = new HashMap<Integer, Integer>();
            for(int j = 0; j < i; j++){
                int diss = A[i] - A[j];
                dp[i].put(diss, dp[j].getOrDefault(diss, 1) + 1);
                // if(dp[j].containsKey(diss)){
                //     dp[i].put(diss, dp[j].get(diss) + 1);
                // } else{
                //     dp[i].put(diss, 2);
                // }
                ans = Math.max(ans, dp[i].get(diss));
            }
        }
        return ans;
    }
}
// @lc code=end

