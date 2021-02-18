import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 翻转字符串里的单词
 */

// @lc code=start
// class Solution {
//     public String reverseWords(String s) {
//         List<String> strList = Arrays.asList(s.trim().split("\\s+"));
//         Collections.reverse(strList);
//         return String.join(" ", strList);
//     }
// }


class Solution{
    public String reverseWords(String s){
        int left = 0;
        int right = s.length() - 1;
        while(left < right && s.charAt(left) == ' '){
            left++;
        }
        while(left < right && s.charAt(right) == ' '){
            right--;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = left; i <= right; i++){
            if(s.charAt(i) != ' '){
                sb.append(s.charAt(i));
            }else if(i > left && s.charAt(i - 1) != ' '){
                sb.append(s.charAt(i));
            }
        }
        int len = sb.length();
        reverse(sb, 0, len - 1);
        int start = 0; int end = 0;
        while(end < len){
            while(end < len && sb.charAt(end) != ' '){
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
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }


}
// @lc code=end
