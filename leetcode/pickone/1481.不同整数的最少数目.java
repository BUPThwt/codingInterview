import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1481 lang=java
 *
 * [1481] 不同整数的最少数目
 */

// @lc code=start
class Solution {
    // public int findLeastNumOfUniqueInts(int[] arr, int k) {
    //     Map<Integer, Integer> map = new HashMap<>();
    //     for(int i : arr){
    //         map.put(i, map.getOrDefault(i, 0) + 1);
    //     }
    //     List<Integer> list = new ArrayList<>();
    //     for(int i : map.keySet()){
    //         list.add(map.get(i));
    //     }
    //     Collections.sort(list);
    //     int ans  = list.size();
    //     for(int i = 0; i < list.size(); i++){
    //         k -= list.get(i);
    //         if(k >= 0){
    //             ans--;
    //         }else{
    //             break;
    //         }
    //     }
    //     return ans;
    // }


    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : arr){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int[] list = new int[map.size()];
        int inde = 0;
        for(int i : map.keySet()){
            list[inde++] = map.get(i);
        }
        Arrays.sort(list);
        int ans  = list.length;
        for(int i = 0; i < list.length; i++){
            k -= list[i];
            if(k >= 0){
                ans--;
            }else{
                break;
            }
        }
        return ans;
    }
}
// @lc code=end

