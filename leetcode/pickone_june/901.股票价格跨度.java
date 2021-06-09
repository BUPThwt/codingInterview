import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=901 lang=java
 *
 * [901] 股票价格跨度
 */

// @lc code=start
class StockSpanner {

    Stack<Integer> stack;
    List<Integer> list;
    public StockSpanner() {
        stack = new Stack<>();
        list = new ArrayList<>();
    }
    
    public int next(int price) {
        int ans = 1;
        list.add(price);
        if(stack.isEmpty() || price < list.get(stack.peek())){
            ans = 1;
        }else{
            while(!stack.isEmpty() && price >= list.get(stack.peek())){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans = list.size();
            }else{
                ans = list.size() - 1 - stack.peek();
            }
        }
        stack.push(list.size() - 1);
        return ans;

    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
// @lc code=end

