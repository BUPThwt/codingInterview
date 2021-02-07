import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=202 lang=java
 *
 * [202] 快乐数
 */

// @lc code=start
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while(n != 1){
            int num = getNum(n);
            if(set.contains(num)){
                return false;
            }
            set.add(num);
            n = num;
        }
        return true;
    }

    public int getNum(int n){
        int result = 0;
        while(n > 0){
            result += (n % 10) * (n % 10);
            n /= 10;
        }
        return result;
    }
}
// @lc code=end

