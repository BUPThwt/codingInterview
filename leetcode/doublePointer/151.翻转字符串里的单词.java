

/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 翻转字符串里的单词
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(s.charAt(left) == ' '){
            left++;
        }
        while(s.charAt(right) == ' '){
            right--;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = left; i <= right; i++){
            char c = s.charAt(i);
            if(c != ' '){
                sb.append(c);
            }else if(s.charAt(i - 1) != ' '){
                sb.append(c);
            }
        }
        int length = sb.length();
        reverse(sb, 0, length - 1);
        int start = 0;
        int end = 0;
        while(end < length){
            while(end < length && sb.charAt(end) != ' '){
                end++;
            }
            reverse(sb, start, end - 1);
            start = end + 1;
            end++;
        }
        return sb.toString();
    }

    private void reverse(StringBuilder sb, int start, int end){
        while(start < end){
            char c = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, c);
            start++;
            end--;
        }
    }
}
// @lc code=end

