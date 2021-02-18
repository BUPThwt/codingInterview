import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;


/*
 * @lc app=leetcode.cn id=225 lang=java
 *
 * [225] 用队列实现栈
 */

// @lc code=start
// class MyStack {

//     Deque<Integer> deque;

//     /** Initialize your data structure here. */
//     public MyStack() {
//         deque = new ArrayDeque<>();
//     }
    
//     /** Push element x onto stack. */
//     public void push(int x) {
//         deque.offer(x);
//     }
    
//     /** Removes the element on top of the stack and returns that element. */
//     public int pop() {
//         return deque.pollLast();
//     }
    
//     /** Get the top element. */
//     public int top() {
//         return deque.peekLast();
//     }
    
//     /** Returns whether the stack is empty. */
//     public boolean empty() {
//         return deque.isEmpty();
//     }
// }



class MyStack {

    Queue<Integer> queueIn;
    Queue<Integer> queueOut;

    /** Initialize your data structure here. */
    public MyStack() {
        queueIn = new LinkedList<>();
        queueOut = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queueIn.offer(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int size = queueIn.size();
        size--;
        while(size-- > 0){
            queueOut.offer(queueIn.poll());
        }
        int result = queueIn.poll();
        while(!queueOut.isEmpty()){
            queueIn.offer(queueOut.poll());
        }
        return result;
    }
    
    /** Get the top element. */
    public int top() {
        int result = pop();
        queueIn.offer(result);
        return result;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queueIn.isEmpty() && queueOut.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

