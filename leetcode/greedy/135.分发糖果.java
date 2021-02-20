/*
 * @lc app=leetcode.cn id=135 lang=java
 *
 * [135] 分发糖果
 */

// @lc code=start
class Solution {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        for(int i = 0; i < candies.length; i++){
            candies[i] = 1;
        }
        for(int i = 1; i < ratings.length; i++){
            if(ratings[i] > ratings[i - 1]){
                candies[i] = candies[i - 1] + 1;
            }
        }
        for(int i = ratings.length - 2; i >= 0; i--){
            if(ratings[i] > ratings[i + 1]){
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        int sum = 0;
        for(int candy : candies){
            sum += candy;
        }
        return sum;
    }
}
// @lc code=end

