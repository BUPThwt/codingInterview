import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int[] ans = new int[k];
        // 小顶堆，保存最大的k个数
        // 重写比较函数，比较的是map的value，出现频率。
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return map.get(a) - map.get(b);
            }
        });
        for(int num : map.keySet()){
            if(queue.size() < k){
                queue.offer(num);
            }else{
                if(map.get(num) > map.get(queue.peek())){
                    queue.poll();
                    queue.offer(num);
                }
            }
        }
        int index = 0;
        while(!queue.isEmpty()){
            ans[index++] = queue.poll();
        }
        return ans;
    }
}
// @lc code=end

