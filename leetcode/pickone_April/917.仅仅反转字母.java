import jdk.nashorn.api.tree.WhileLoopTree;

/*
 * @lc app=leetcode.cn id=917 lang=java
 *
 * [917] 仅仅反转字母
 */

// @lc code=start
class Solution {
    public String reverseOnlyLetters(String S) {
        int left = 0;
        int right = S.length() - 1;
        char[] chars = S.toCharArray();
        while(left < right){
            while(left < S.length() && !Character.isLetter(chars[left])){
                left++;
            }
            while(right >=0  && !Character.isLetter(chars[right])){
                right--;
            }
            if(left < right){
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
            
        }
        return String.valueOf(chars);
    }
}
// @lc code=end

