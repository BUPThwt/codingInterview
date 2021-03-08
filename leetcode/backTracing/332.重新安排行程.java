
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
        List<String> result = new LinkedList<>();
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for(List<String> pair : tickets){
            // PriorityQueue<String> queue = graph.computeIfAbsent(pair.get(0), k -> new PriorityQueue<>());
            PriorityQueue<String> queue = graph.getOrDefault(pair.get(0), new PriorityQueue<String>());
            queue.add(pair.get(1));
            graph.put(pair.get(0), queue);
        }
        backTracing(graph, "JFK", result);
        return result;
    }

    private void backTracing(Map<String, PriorityQueue<String>> graph, String src, List<String> result){
        PriorityQueue<String> nbr = graph.get(src);
        while(nbr != null &&  !nbr.isEmpty()){
            String dec = nbr.poll();
            backTracing(graph, dec, result);
        }
        result.add(0, src);
    }

  
}
// @lc code=end

