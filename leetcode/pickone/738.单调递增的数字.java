/*
 * @lc app=leetcode.cn id=738 lang=java
 *
 * [738] 单调递增的数字
 */

// @lc code=start
class Solution {
    public int monotoneIncreasingDigits(int N) {
        if(N < 10){
            return N;
        }
        char[] chars = String.valueOf(N).toCharArray();
        int index = Integer.MAX_VALUE;
        for(int i = chars.length - 1; i > 0; i--){
            if(chars[i - 1] > chars[i]){
                chars[i - 1]--;
                index = i;
            }
        }
        if(index != Integer.MAX_VALUE){
            for(int i = index; i < chars.length; i++){
                chars[i] = '9';
            }
        }
        return Integer.parseInt(new String(chars));
    }
}
// @lc code=end

