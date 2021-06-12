/*
 * @lc app=leetcode.cn id=473 lang=java
 *
 * [473] 火柴拼正方形
 */

// @lc code=start
class Solution {
    int[] sums;
    List<Integer> list;
    int perLength;
    public boolean makesquare(int[] nums) {
        if(nums.length < 4){
            return false;
        }
        sums = new int[4];
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        perLength = sum / 4;
        if(perLength * 4 != sum){
            return false;
        }
        list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(list, Collections.reverseOrder());
        return backTracing(0);
    }

    private boolean backTracing(int index){
        if(index == list.size()){
            return sums[0] == sums[1] && sums[1] == sums[2] && sums[2] == sums[3];
        }
        int element = list.get(index);
        for(int i = 0; i < 4; i++){
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

