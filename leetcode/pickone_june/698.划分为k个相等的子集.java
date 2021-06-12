/*
 * @lc app=leetcode.cn id=698 lang=java
 *
 * [698] 划分为k个相等的子集
 */

// @lc code=start
class Solution {
    int[] sums;
    int perLength;
    List<Integer> list;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        sums = new int[k];
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        perLength = sum / k;
        if(perLength * k != sum){
            return false;
        }
        list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(list, Collections.reverseOrder());
        return backTracing(0);
    }

    private boolean backTracing(int index){
        if(index == list.size()){
            for(int sum : sums){
                if(sum != perLength){
                    return false;
                }
            }
            return true;
        }
        int element = list.get(index);
        for(int i = 0; i < sums.length; i++){
            if(sums[i] + element <= perLength){
                sums[i] += element;
                if(backTracing(index + 1)){
                    return true;
                }
                sums[i] -= element;
            }
        }
        return false;
    }
}
// @lc code=end

