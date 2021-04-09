import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import org.graalvm.compiler.hotspot.stubs.CreateExceptionStub;

/*
 * @lc app=leetcode.cn id=440 lang=java
 *
 * [440] 字典序的第K小数字
 */

// @lc code=start
class Solution {

    //  超时
    // int ans = 0;
    // int size = 0;
    // public int findKthNumber(int n, int k) {
    //     size = k;
    //     for(int i = 1; i <=9; i++){
    //         dfs(n, i);
    //     }
    //     return ans;
    // }

    // private void dfs(int n, int num){
    //     if(num > n || size <= 0){
    //         return;
    //     }
    //     if(--size == 0){
    //         ans = num;
    //         return;
    //     }
    //     for(int i = 0; i < 10; i++){
    //         dfs(n, num * 10 + i);
    //     }
    // }


    public int findKthNumber(int n, int k){
        int cur = 1;
        int prefix = 1;
        while(cur < k){
            int temp = count(n, prefix);
            // 在当前prefix，则继续向下
            if(temp + cur > k){
                // 向下需要将prefix*10
                prefix *= 10;
                // 之前的prefix遍历过了 添加到cur计数中
                cur++;
            }else{
                // 不在当前前缀下，前缀直接+1向后
                prefix++;
                // cur计数加上跳过的temp
                cur += temp;
            }
        }
        return prefix;
    }

    private int count(int n, int prifix){
        int count = 0;
        // 当前前缀
        long cur = Long.valueOf(prifix);
        // 下一前缀
        long next = cur + 1;
        while(cur <= n){
            // n+1需要举例理解
            //下一前缀减前一前缀，计算中间的数
            count += Math.min(n + 1, next) - cur;
            // 如果说刚刚prefix是1，next是2，那么现在分别变成10和20
	        // 1为前缀的子节点增加10个，十叉树增加一层, 变成了两层
	        
	        // 如果说现在prefix是10，next是20，那么现在分别变成100和200，
	        // 1为前缀的子节点增加100个，十叉树又增加了一层，变成了三层
            cur *= 10;
            next *= 10;
        }
        return count;
    }
}
// @lc code=end

