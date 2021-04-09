import java.util.HashMap;
import java.util.Map;


/*
 * @lc app=leetcode.cn id=1590 lang=java
 *
 * [1590] 使数组和能被 P 整除
 */

// @lc code=start
class Solution {
    public int minSubarray(int[] nums, int p) {
        long sum = 0;
        for(int i : nums){
            sum += i;
        }
        long left = sum % p;
        if(left == 0){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        Map<Long, Integer> map = new HashMap<>();
        map.put(0l, -1);
        long preSum = 0;
        for(int i = 0; i < nums.length; i++){
            preSum += nums[i];
            long mod = preSum % p;
            long aimMod = (mod - left + p) % p;
            if(map.containsKey(aimMod)){
                ans = Math.min(ans, i - map.get(aimMod));
            }
            map.put(mod, i);
        }
        return ans >= nums.length ? -1 : ans;
    }
}
// @lc code=end

