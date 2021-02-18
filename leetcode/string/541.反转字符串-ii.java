/*
 * @lc app=leetcode.cn id=541 lang=java
 *
 * [541] 反转字符串 II
 */

// @lc code=start
class Solution {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for(int i = 0; i < s.length(); i += 2 * k){
            if(i + k <= s.length()){
                reverse(chars, i, i + k);
            }
            if(i + k > s.length()){
                reverse(chars, i, s.length());
            }
        }
        return new String(chars);
    }

    private void reverse(char[] chars, int start, int end){
        int left = start;
        int right = end - 1;
        while(left < right){
           chars[left] ^= chars[right];
           chars[right] ^= chars[left];
           chars[left] ^= chars[right];
           left++;
           right--;
        }
    }
}
// @lc code=end

