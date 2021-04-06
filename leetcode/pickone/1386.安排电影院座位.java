import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1386 lang=java
 *
 * [1386] 安排电影院座位
 */

// @lc code=start
class Solution {
    
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Arrays.sort(reservedSeats, (o1, o2) -> o1[0] - o2[0]);
        Map<Integer, int[]> map = new HashMap<>();
        int ans =  2 * n;
        for(int[] seat : reservedSeats){
            if(!map.containsKey(seat[0])){
                map.put(seat[0], new int[11]);
            }
            map.get(seat[0])[seat[1]] = 1;
        }
        for(int row : map.keySet()){
            ans -= 2;
            int[] line = map.get(row);
            int f = 0;
            if(line[2] == 0 && line[3] == 0 && line[4] == 0 && line[5] == 0){
                ans++;
                f = 1;
            }
            if(line[6] == 0 && line[7] == 0 && line[8] == 0 && line[9] == 0){
                ans++;
                f = 1;
            }
            if(line[4] == 0 && line[5] == 0 && line[6] == 0 && line[7] == 0 && f == 0){
                ans++;
            }
        }
        return ans;
        
    }

    // public int maxNumberOfFamilies(int n, int[][] reservedSeats){
    //     int ans = 2 * n;
    //     Map<Integer, HashSet<Integer>> map = new HashMap<>();
    //     for(int[] seat : reservedSeats){
    //         int row = seat[0];
    //         int col = seat[1];
    //         if(!map.containsKey(row)){
    //             map.put(row, new HashSet<>());
    //         }
    //         map.get(row).add(col);
    //     }
    //     for(int row : map.keySet()){
    //         int count = 0;
    //         HashSet<Integer> set = map.get(row);
    //         if(isOk(2, 5, set)){
    //             count++;
    //             if(isOk(6, 9, set)){
    //                 count++;
    //             }
    //         }else{
    //             if(isOk(4, 7, set)){
    //                 count++;
    //             }else if(isOk(6, 9, set)){
    //                 count++;
    //             }
    //         }
    //         ans -= 2- count;
    //     }
    //     return ans;

    // }

    // private boolean isOk(int l, int r, HashSet<Integer> set){
    //     for(int i = l; i <= r; i++){
    //         if(set.contains(i)){
    //             return false;
    //         }
    //     }
    //     return true;
    // }
}
// @lc code=end

