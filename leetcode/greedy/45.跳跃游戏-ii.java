/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        if(nums.length < 2){
            return 0;
        }
        int curCover = nums[0];
        int preMaxCover = nums[0];
        int result = 1;
        for(int i = 0; i <= curCover; i++){
            preMaxCover = Math.max(preMaxCover, nums[i] + i);
            if(curCover >= nums.length - 1){
                return result;
            }
            if(i == curCover){
                curCover = preMaxCover;
                result++;
            }
        }
        return result;
    }
}


// class Solution {
//     public int jump(int[] nums) {
//         int curCover = 0;
//         int preMaxCover = 0;
//         int result = 0;
//         for(int i = 0; i < nums.length - 1; i++){
//             preMaxCover = Math.max(preMaxCover, nums[i] + i);
//             if(i == curCover){
//                 curCover = preMaxCover;
//                 result++;
//             }
//         }
//         return result;
//     }
// }
// @lc code=end

