import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=406 lang=java
 *
 * [406] 根据身高重建队列
 */

// @lc code=start
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int[][] result = new int[people.length][];
        Arrays.sort(people, (p1, p2) -> {
            if(p1[0] == p2[0]){
                return p1[1] - p2[1];
            }
            return p2[0] - p1[0]; 
        });
        LinkedList<int[]> list = new LinkedList();
        for(int[] person : people){
            list.add(person[1], person);
        }
        int index = 0;
        for(int[] ans : list){
            result[index++] = ans;
        }
        return result;
    }

}
// @lc code=end

