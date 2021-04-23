import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=698 lang=java
 *
 * [698] 划分为k个相等的子集
 */

// @lc code=start
class Solution {

    // 超时了
    // [2,2,2,2,2,2,2,2,2,2,2,2,2,3,3]
    // 8
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        int max = 0;
        // Arrays.sort(nums, (o1, o2) -> o2 - o1);
        for(int num : nums){
            sum += num;
            max = Math.max(num, max);
        }
        int target = sum / k;
        if(sum % k != 0 || target < max){
            return false;
        }
        srot(nums);
        boolean[] used = new boolean[nums.length];
        return backTracing(nums, k, target, 0, 0, used);
    }

    private boolean backTracing(int[] nums, int k, int target, int cur, int start, boolean[] used){
        if(k == 0){
            return true;
        }
        if(cur == target){
            return backTracing(nums, k - 1, target, 0, 0, used);
        }
        for(int i = start; i < nums.length; i++){
            if(!used[i] && nums[i] + cur <= target){
                used[i] = true;
                if(backTracing(nums, k, target, cur + nums[i], i + 1, used)){
                    return true;
                }
                used[i] = false;
            }
        }
        return false;
    }

    public void srot(int[] nums){
        for(int i = 0; i < nums.length; i++){
            int index = i;
            for(int j = i; j <nums.length; j++){
                if(nums[j] > nums[i]){
                    index = j;
                }
            }
            if(index != i){
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
            }
        }
    }
}
// @lc code=end

