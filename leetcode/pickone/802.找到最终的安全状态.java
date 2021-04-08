import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jdk.javadoc.internal.doclets.toolkit.util.DocFile;

/*
 * @lc app=leetcode.cn id=802 lang=java
 *
 * [802] 找到最终的安全状态
 */

// @lc code=start
class Solution {
    // 超时
    // public List<Integer> eventualSafeNodes(int[][] graph) {
    //     int length = graph.length;
    //     if(length == 0){
    //         return new ArrayList<>();
    //     }
    //     List<Integer> ans = new ArrayList<>();
    //     for(int i = 0; i < length; i++){
    //         Set<Integer> set = new HashSet<>();
    //         set.add(i);
    //         if(!isCircle(i, graph, set)){
    //             ans.add(i);
    //         }
    //     }
    //     return ans;
    // }

    // private boolean isCircle(int index, int[][] graph, Set<Integer> set){
    //     int[] next = graph[index];
    //     for(int i : next){
    //         if(set.contains(i)){
    //             return true;
    //         }
    //         set.add(i);
    //         if(isCircle(i, graph, set)){
    //             return true;
    //         }
    //         set.remove(i);
    //     }
    //     return false;
    // }

    // 三色标记法
    public List<Integer> eventualSafeNodes(int[][] graph){
        int length = graph.length;
        int[] color = new int[length];
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < length; i++){
            if(dfs(i, graph, color)){
                ans.add(i);
            }
        }
        return ans;
    }

    private boolean dfs(int index, int[][] graph, int[] color){
        // 访问到正在访问中的，表示成环了。
        if(color[index] == 1){
            return false;
        }
        // 访问到已经访问完的，安全的点
        if(color[index] == 2){
            return true;
        }
        color[index] = 1;
        for(int next : graph[index]){
            if(!dfs(next, graph, color)){
                return false;
            }
        }
        color[index] = 2;
        return true;
    }
}
// @lc code=end

