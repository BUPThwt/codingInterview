/*
 * @lc app=leetcode.cn id=344 lang=java
 *
 * [344] 反转字符串
 */

// @lc code=start
class Solution {
    public void reverseString(char[] s) {
        int left = 0; 
        int right = s.length - 1;
        while(left < right){
            s[left] ^= s[right];
            s[right] ^= s[left];
            s[left] ^= s[right];
            left++;
            right--;
        }
    }
}
// @lc code=end

