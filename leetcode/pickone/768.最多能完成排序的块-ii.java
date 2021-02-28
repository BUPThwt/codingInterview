import java.util.Stack;

/*
 * @lc app=leetcode.cn id=768 lang=java
 *
 * [768] 最多能完成排序的块 II
 */

// @lc code=start
class Solution {
    public int maxChunksToSorted(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for(int num : arr){
            if(!stack.isEmpty() && num < stack.peek()){
                int head = stack.pop();
                while(!stack.isEmpty() && num < stack.peek()){
                    stack.pop();
                }
                stack.push(head);
            }else{
                stack.push(num);
            }
        }
        return stack.size();
    }
}
// @lc code=end

