import java.util.Arrays;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=406 lang=java
 *
 * [406] 根据身高重建队列
 */

// @lc code=start
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // 按照身高降序，身高相同情况下，按照第1位升序
        Arrays.sort(people, (o1, o2) -> {
            if(o1[0] == o2[0]){
                return o1[1] - o2[1];
            }else{
                return o2[0] - o1[0];
            }
        });
        LinkedList<int[]> list = new LinkedList<>();
        for(int[] i : people){
            list.add(i[1], i);
        }
        return list.toArray(new int[list.size()][2]);
    }
}
// @lc code=end

