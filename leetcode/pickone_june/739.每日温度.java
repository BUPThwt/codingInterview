import java.util.Stack;

/*
 * @lc app=leetcode.cn id=739 lang=java
 *
 * [739] 每日温度
 */

// @lc code=start
class Solution {
    // public int[] dailyTemperatures(int[] temperatures) {
    //     Stack<Integer> stack = new Stack();
    //     int[] result = new int[temperatures.length];
    //     stack.push(0);
    //     for(int i = 1; i < temperatures.length; i++){
    //         if(temperatures[i] < temperatures[stack.peek()]){
    //             stack.push(i);
    //         }else if (temperatures[i] == temperatures[stack.peek()]){
    //             stack.push(i);
    //         }else if(temperatures[i] > temperatures[stack.peek()]){
    //             while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
    //                 result[stack.peek()] = i - stack.peek(); 
    //                 stack.pop();
    //             }
    //             stack.push(i);
    //         }
    //     }
    //     return result;
    // }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack();
        int[] result = new int[temperatures.length];
        stack.push(0);
        for(int i = 1; i < temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                result[stack.peek()] = i - stack.peek(); 
                stack.pop();
            }
            stack.push(i);
        }
        return result;
    }
}
// @lc code=end

