import java.util.Stack;

/*
 * @lc app=leetcode.cn id=402 lang=java
 *
 * [402] 移掉K位数字
 */

// @lc code=start
class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < num.length(); i++){
            int n = Integer.valueOf(String.valueOf(num.charAt(i)));
            while(!stack.isEmpty() && n < stack.peek() && k > 0){
               stack.pop();
               k--;
            }
            if(stack.isEmpty() && n == 0){
                continue;
            }
            stack.push(n);
        }
        while(k > 0 && !stack.isEmpty()){
            stack.pop();
            k--;
        }
        if(stack.isEmpty()){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
// @lc code=end

