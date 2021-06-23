/*
 * @lc app=leetcode.cn id=150 lang=java
 *
 * [150] 逆波兰表达式求值
 */

// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for(int i = 0; i < tokens.length; i++){
            if(isNumber(tokens[i])){
                stack.push(Integer.valueOf(tokens[i]));
            }else{
                int num2 = stack.pop();
                int num1 = stack.pop();
                if("+".equals(tokens[i])){
                    stack.push(num1 + num2);
                }else if("-".equals(tokens[i])){
                    stack.push(num1 - num2);
                }else if("*".equals(tokens[i])){
                    stack.push(num1 * num2);
                }else if("/".equals(tokens[i])){
                    stack.push(num1 / num2);
                }
            }
        }
        return stack.pop();
    }

    private boolean isNumber(String s){
        if("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s)){
            return false;
        }
        return true;
    }
}
// @lc code=end

