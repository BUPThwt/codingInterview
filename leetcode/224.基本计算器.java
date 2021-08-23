/*
 * @lc app=leetcode.cn id=224 lang=java
 *
 * [224] 基本计算器
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        int res = 0;
        int num = 0;
        int sign = 1;
        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack();
        for(int i = 0; i < chars.length; i++){
          char c = chars[i];
          if(c == ' '){
            continue;
          }else if('0' <= c && c <= '9'){
            num = num * 10 + c - '0';
            if(i < chars.length - 1 && chars[i + 1] >= '0' && chars[i + 1]<= '9'){
              continue;
            }
          }else if(c == '+' || c == '-'){
            num = 0;
            if(c == '+'){
              sign = 1;
            }else if(c == '-'){
              sign = -1;
            }
          }else if(c == '('){
            stack.push(res);
            stack.push(sign);
            res = 0;
            sign = 1;
          }else if(c == ')'){
            sign = stack.pop();
            num = res;
            res = stack.pop();
          }
          res += num * sign;
        }
        return res;
      }
}
// @lc code=end

