import java.util.Stack;

/*
 * @lc app=leetcode.cn id=232 lang=java
 *
 * [232] 用栈实现队列
 */

// @lc code=start
class MyQueue {
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    /** Initialize your data structure here. */
    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stackIn.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        merge();
        return stackOut.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        merge();
        return stackOut.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    private void merge(){
        if(stackOut.isEmpty()){
            while(!stackIn.isEmpty()){
                stackOut.push(stackIn.pop());
            }
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

