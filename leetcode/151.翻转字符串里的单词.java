import java.util.Deque;

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
        while(left <= right && s.charAt(left) == ' '){
            left++;
        }
        while(left <= right && s.charAt(right) == ' '){
            right--;
        }
        Deque<String> queue = new ArrayDeque();
        StringBuilder word = new StringBuilder();
        while(left <= right){
            if(s.charAt(left) == ' ' && word.length() != 0){
                queue.addFirst(word.toString());
                word.setLength(0);
            }else if(s.charAt(left) != ' '){
                word.append(s.charAt(left));
            }
            left++;
        }
        if(word.length() > 0){
            queue.addFirst(word.toString());
        }
        return String.join(" ", queue);
    }
}
// @lc code=end

