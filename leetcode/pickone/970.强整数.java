import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=970 lang=java
 *
 * [970] 强整数
 */

// @lc code=start
class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();
        // 小于等于20，如果x,y中有一个是1就会一直循环下去
        for(int i = 0; i <= 20 &&Math.pow(x, i) < bound; i++){
            for(int j = 0; j <= 20 && Math.pow(y, j) < bound; j++){
                int num = (int)Math.pow(x, i) + (int)Math.pow(y, j);
                if(num <= bound){
                    set.add(num);
                }else{
                    break;
                }
            }
        }
        return new ArrayList<>(set);
    }
}
// @lc code=end

