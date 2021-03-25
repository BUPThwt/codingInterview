import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1743 lang=java
 *
 * [1743] 从相邻元素对还原数组
 */

// @lc code=start
class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] pair : adjacentPairs){
            List<Integer> list1 = map.computeIfAbsent(pair[0], k -> new ArrayList<Integer>());
            list1.add(pair[1]);
            map.put(pair[0], list1);
            List<Integer> list2 = map.computeIfAbsent(pair[1], k -> new ArrayList<Integer>());
            list2.add(pair[0]);
            map.put(pair[1], list2);
        }
        int start = 0;
        for(int i : map.keySet()){
            if(map.get(i).size() == 1){
                start = i;
                break;
            }
        }
        int[] ans = new int[adjacentPairs.length + 1];
        int index = 0;
        ans[index++] = start;
        // 数组长度固定，while来确定循环范围
        while(index < ans.length){
            List<Integer> pair = map.get(start);
            // 首位情况，直接塞
            if(pair.size() == 1){
                ans[index++] = pair.get(0);
                start = pair.get(0);
            }else{
                // 非首位情况，会有两个值，要判断获取到的两个数，如果等于index-2就已经使用过了，避免顺序反转
                if(pair.get(0) == ans[index - 2]){
                    start = pair.get(1);
                }else{
                    start = pair.get(0);
                }
                ans[index++] = start;
            }
        } 
        return ans;
    }
}
// @lc code=end

