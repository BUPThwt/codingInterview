import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/*
 * @lc app=leetcode.cn id=547 lang=java
 *
 * [547] 省份数量
 */

// @lc code=start
class Solution {
    public int findCircleNum(int[][] isConnected) {
       int length = isConnected.length;
       int count = 0;
       Queue<Integer> queue = new LinkedList<>();
       boolean[] visit = new boolean[length];
       for(int i = 0; i < length; i++){
           if(!visit[i]){
               queue.offer(i);
               while(!queue.isEmpty()){
                   int j = queue.poll();
                   visit[j] = true;
                   for(int k = 0; k < length; k++){
                       if(isConnected[j][k] == 1 && !visit[k]){
                           queue.offer(k);
                       }
                   }
               }
               count++;
           }
       }
       return count;
    }
}
// @lc code=end

