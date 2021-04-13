import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode.cn id=1333 lang=java
 *
 * [1333] 餐厅过滤器
 */

// @lc code=start
class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<int[]> restaurantFirst = new ArrayList<>();
        for(int[] restaurant : restaurants){
            if(veganFriendly == 1 && restaurant[2] != 1){
                continue;
            }
            if(restaurant[3] > maxPrice || restaurant[4] > maxDistance){
                continue;
            }
            restaurantFirst.add(restaurant);
        }
        List<Integer> ans = new ArrayList<>();
        // List<int[]> ansFirst = restaurantFirst.stream().sorted((o1, o2) -> {
        //     if(o1[1] == o2[1]){
        //         return o2[0] - o1[0];
        //     }else{
        //         return o2[1] - o1[1];
        //     }
        // }).collect(Collectors.toList());
        ans = restaurantFirst.stream().sorted((o1, o2) -> {
            if(o1[1] == o2[1]){
                return o2[0] - o1[0];
            }else{
                return o2[1] - o1[1];
            }
        }).mapToInt(v -> v[0]).boxed().collect(Collectors.toList());
        // for(int[] i : ansFirst){
        //     ans.add(i[0]);
        // }
        return ans;
    }
}
// @lc code=end

