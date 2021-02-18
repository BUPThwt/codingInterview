import java.util.Stack;

/*
 * @lc app=leetcode.cn id=1047 lang=java
 *
 * [1047] 删除字符串中的所有相邻重复项
 */

// @lc code=start
class Solution {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for(char c : S.toCharArray()){
            if(stack.isEmpty() || stack.peek() != c){
                stack.push(c);
            }else{
                stack.pop(); 
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(String.valueOf(stack.pop()));
        }
        return sb.reverse().toString();
    }
}
// @lc code=end

