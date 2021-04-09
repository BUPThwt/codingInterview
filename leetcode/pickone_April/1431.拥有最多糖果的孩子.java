import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1431 lang=java
 *
 * [1431] 拥有最多糖果的孩子
 */

// @lc code=start
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for(int candy : candies){
            max = Math.max(candy, max);
        }
        List<Boolean> ans = new ArrayList<>();
        for(int i = 0; i < candies.length; i++){
            ans.add(candies[i] + extraCandies >= max ? true : false);
        }
        return ans;
    }
}
// @lc code=end

