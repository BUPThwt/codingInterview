import java.util.Stack;

/*
 * @lc app=leetcode.cn id=150 lang=java
 *
 * [150] 逆波兰表达式求值
 */

// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for(String s : tokens){
            if("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s)){
                int nums1 = Integer.valueOf(stack.pop());
                int nums2 = Integer.valueOf(stack.pop());
                if("+".equals(s)){
                    stack.push(String.valueOf(nums2 + nums1));
                }else if("-".equals(s)){
                    stack.push(String.valueOf(nums2 - nums1));
                }else if("*".equals(s)){
                    stack.push(String.valueOf(nums2 * nums1));
                }else if("/".equals(s)){
                    stack.push(String.valueOf(nums2 / nums1));
                }
            }else{
                stack.push(s);
            }
        }
        return Integer.valueOf(stack.pop());
    }
}
// @lc code=end

