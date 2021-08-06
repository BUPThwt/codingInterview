package graph;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


/*
 * @lc app=leetcode.cn id=210 lang=java
 *
 * [210] 课程表 II
 */

// @lc code=start
class Solution {
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses <= 0){
            return new int[0];
        }
        int[] inDegree = new int[numCourses];
        Set<Integer>[] adj = new HashSet[numCourses];
        for(int i = 0; i < numCourses; i++){
            adj[i] = new HashSet<>();
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int[] prerequisity : prerequisites){
            adj[prerequisity[1]].add(prerequisity[0]);
            inDegree[prerequisity[0]]++;
        }
        int[] res = new int[numCourses];
        int count = 0;
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int head = queue.poll();
            res[count++] = head;
            Set<Integer> successors = adj[head];
            for(int successor : successors){
                inDegree[successor]--;
                if(inDegree[successor] == 0){
                    queue.offer(successor);
                }
            }
        }
        if(count != numCourses){
            return new int[0];
        }
        return res;
    }
}
// @lc code=end

