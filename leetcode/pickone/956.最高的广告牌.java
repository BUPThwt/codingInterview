import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=956 lang=java
 *
 * [956] 最高的广告牌
 */

// @lc code=start
class Solution {

    // [102,101,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100]
    // 超时
    // int ans = 0;
    // public int tallestBillboard(int[] rods) {
    //     if(rods.length < 2){
    //         return ans;
    //     }
    //     int remain = 0;
    //     for(int rod : rods){
    //         remain += rod;
    //     }
    //     Arrays.sort(rods);
    //     billboardHelper(rods, rods.length - 1, remain, 0, 0);
    //     return ans;
    // }

    // private void billboardHelper(int[] rods, int index, int remain, int left, int right){
    //     if(left == right && left > ans){
    //         ans = left;
    //     }
    //     if(Math.abs(left - right) > remain || left + right + remain < 2 * ans || index < 0){
    //         return;
    //     }
    //     remain -= rods[index];
    //     billboardHelper(rods, index - 1, remain, left + rods[index], right);
    //     billboardHelper(rods, index - 1, remain, left, right + rods[index]);
    //     billboardHelper(rods, index - 1, remain, left, right);
    // }


    public int tallestBillboard(int[] rods){
        // 高度差为key时，最大的高度
        // 每一个数都可以加或者减或者不加  对每个数与前面的结果进行计算。
        // 维护一组数为正，一组数为负，代表两边的高度。
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> copy = new HashMap<>();
        map.put(0, 0);
        for(int i : rods){
            copy.clear();
            copy.putAll(map);
            // map里的key是差值，key是正数的最大值。
            for(int key : copy.keySet()){
                // i添加到正数
                map.put(key + i, Math.max(map.getOrDefault(key + i, 0),
                copy.get(key) + i));
                // i添加到负数
                map.put(key - i, Math.max(map.getOrDefault(key - i, 0), 
                copy.get(key)));
            }
        }
        return map.get(0);
    }
}
// @lc code=end

