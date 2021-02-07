import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=454 lang=java
 *
 * [454] 四数相加 II
 */

// @lc code=start
// class Solution {
//     public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
//         Map<Integer, Integer> map = new HashMap<>();
//         for(int a : A){
//             for(int b : B){
//                 map.put(a + b, map.getOrDefault(a + b, 0) + 1);
//             }
//         }
//         int count = 0;
//         for(int c : C){
//             for(int d : D){
//                 if(map.containsKey( 0 - c - d)){
//                     count += map.get(0 - c - d);
//                 }
//             }
//         }
//         return count;
//     }
// }





class Solution{
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D){
        Map<Integer, Integer> map = new HashMap<>();
        for(int a : A){
            for(int b : B){
                map.put(a + b, map.getOrDefault(a + b, 0) + 1); 
            }
        }
        int count = 0;
        for(int c : C){
            for(int d : D){
                int sum = 0 - c - d;
                count += map.getOrDefault(sum, 0);
            }
        }
        return count;
    }

}
// @lc code=end

