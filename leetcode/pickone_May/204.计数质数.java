/*
 * @lc app=leetcode.cn id=204 lang=java
 *
 * [204] 计数质数
 */

// @lc code=start
class Solution {
    public int countPrimes(int n) {
        // 厄拉多塞 筛法
        int count = 0;
        boolean[] flag = new boolean[n];
        for(int i = 2; i < n; i++){
            if(!flag[i]){
                count++;
                for(int j = i + i; j < n; j += i){
                    flag[j] = true;
                }
            }
        }
        return count;
    }
}
// @lc code=end

