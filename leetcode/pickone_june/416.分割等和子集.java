/*
 * @lc app=leetcode.cn id=416 lang=java
 *
 * [416] 分割等和子集
 */

// @lc code=start
class Solution {
    // Time Limit Exceeded
    // int[] sums;
    // int perLength;
    // List<Integer> list;
    // public boolean canPartition(int[] nums) {
    //     if(nums.length < 2){
    //         return false;
    //     }
    //     sums = new int[2];
    //     int sum = 0;
    //     for(int num : nums){
    //         sum += num;
    //     }
    //     perLength = sum / 2;
    //     if(perLength * 2 != sum){
    //         return false;
    //     }
    //     list = Arrays.stream(nums).boxed().collect(Collectors.toList());
    //     Collections.sort(list, Collections.reverseOrder());
    //     return backTracing(0);
    // }

    // private boolean backTracing(int index){
    //     if(index == list.size()){
    //         for(int i : sums){
    //             if(i != perLength){
    //                 return false;
    //             }
    //         }
    //         return true;
    //     }
    //     int element = list.get(index);
    //     for(int i = 0; i < sums.length; i++){
    //         if(sums[i] + element <= perLength){
    //             sums[i] += element;
    //             if(backTracing(index + 1)){
    //                 return true;
    //             }
    //             sums[i] -= element;
    //         }
    //     }
    //     return false;
    // }

    public boolean canPartition(int[] nums) {
        int sum  = 0;
        for(int num : nums){
            sum += num;
        }
        int target = sum / 2;
        if(target * 2 != sum){
            return false;
        }
        int[] dp = new int[target + 1];
        for(int i = 0; i < nums.length; i++){
            for(int j = target; j >= nums[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }   
        return dp[target] == target;
     }
}
// @lc code=end

