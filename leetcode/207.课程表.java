import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=207 lang=java
 *
 * [207] 课程表
 */

// @lc code=start
class Solution {
    // public boolean canFinish(int numCourses, int[][] prerequisites) {
    //     if(numCourses <= 1){
    //         return true;
    //     }
    //     //0未访问， 1访问中， 2已访问
    //     int[] status = new int[numCourses];
    //     Set<Integer>[] nabors = new HashSet[numCourses];
    //     for(int i = 0; i < numCourses; i++){
    //         nabors[i] = new HashSet<>();
    //     }
    //     for(int[] prerequisite : prerequisites){
    //         nabors[prerequisite[1]].add(prerequisite[0]);
    //     }
    //     for(int i = 0; i < numCourses; i++){
    //         if(!dfs(status, i, nabors)){
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    // private boolean dfs(int[] status, int index, Set<Integer>[] nabors){
    //     if(status[index] == 2){
    //         return true;
    //     }
    //     if(status[index] == 1){
    //         return false;
    //     }
    //     status[index] = 1;
    //     for(int nabor : nabors[index]){
    //         if(!dfs(status, nabor, nabors)){
    //             return false;
    //         }
    //     }
    //     status[index] = 2;
    //     return true;
    // }


    public boolean canFinish(int numCourses, int[][] prerequisites){
        if(numCourses <= 1){
          return true;
        }
        List<List<Integer>> adj = new ArrayList();
        //0 未访问， 1访问中， 2已访问
        int[] flag = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
          adj.add(new ArrayList());
        }
        for(int[] pre : prerequisites){
          adj.get(pre[1]).add(pre[0]);
        }
        for(int i = 0; i < numCourses; i++){
          if(!dfs(flag, adj, i)){
            return false;
          }
        }
        return true;
      }
      
      private boolean dfs(int[] flag, List<List<Integer>> adj, int index){
        if(flag[index] == 1){
          return false;
        }
        if(flag[index] == 2){
          return true;
        }
        flag[index] = 1;
        for(int i : adj.get(index)){
          if(!dfs(flag, adj, i)){
            return false;
          }
        }
        flag[index] = 2;
        return true;
      }
}
// @lc code=end

