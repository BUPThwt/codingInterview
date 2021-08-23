import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1029 lang=java
 *
 * [1029] 两地调度
 */

// @lc code=start
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        //按照去B地比去A地更省钱的方式排序
        Arrays.sort(costs, (o1, o2) -> {
            return o1[1] - o1[0] - (o2[1] - o2[0]);
        });
        int total = 0;
        // 前一半去B地，后一半去A地
        for(int i = 0; i < costs.length / 2; i++){
            total += costs[i][1] + costs[i + costs.length / 2][0];
        }
        return total;
    }
}
// @lc code=end

