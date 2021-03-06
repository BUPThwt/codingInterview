import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=332 lang=java
 *
 * [332] 重新安排行程
 */

// @lc code=start
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> result = new LinkedList();
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for(List<String> pair : tickets){
            PriorityQueue queue = graph.computeIfAbsent(pair.get(0), k -> new PriorityQueue<>());
            queue.add(pair.get(1));
            graph.put(pair.get(0), queue);
        }
        backTracing(graph, "JFK", result);
        return result;
    }

    private void backTracing(Map<String, PriorityQueue<String>> graph, String src, List<String> result){
        PriorityQueue<String> nbr =  graph.get(src);
        while(nbr != null && !nbr.isEmpty()){
            String destination = nbr.poll();
            backTracing(graph, destination, result);
        }
        result.add(0, src);
    }

}
// @lc code=end

