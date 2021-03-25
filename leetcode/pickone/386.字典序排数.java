import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=386 lang=java
 *
 * [386] 字典序排数
 */

// @lc code=start
class Solution {

    // 想象成是一个树，第一层为1-9， 之后都是0-9
    // 进行深度遍历
    List<Integer> list;
    public List<Integer> lexicalOrder(int n) {
        list = new ArrayList<>();
        for(int i = 1; i < 10; i++){
            dfs(n, i);
        }
        return list;
    }

    private void dfs(int n, int num){
        if(num > n){
            return;
        }
        list.add(num);
        for(int i = 0; i < 10; i++){
            dfs(n, num * 10 + i);
        }
    }
}
// @lc code=end

