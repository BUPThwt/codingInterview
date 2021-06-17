import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=179 lang=java
 *
 * [179] 最大数
 */

// @lc code=start
class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] words = new String[n];
        for(int i = 0; i < n; i++){
            words[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(words, (a, b) -> 
            (b+a).compareTo(a+b)
        );
        StringBuilder sb = new StringBuilder();
        if("0".equals(words[0])){
            return "0";
        }
        for(int i = 0; i < words.length; i++){
            sb.append(words[i]);
        }
        return sb.toString();
    }
}
// @lc code=end

