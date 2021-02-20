import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=738 lang=java
 *
 * [738] 单调递增的数字
 */

// @lc code=start
class Solution {
    public int monotoneIncreasingDigits(int N) {
        char[] s = String.valueOf(N).toCharArray();
        int index = s.length;
        for(int i = s.length - 1; i > 0; i--){
            if(Integer.valueOf(s[i]) < Integer.valueOf(s[i - 1])){
                index = i;
                s[i - 1] -= 1;
            }
        }  
        for(int i = index; i < s.length; i++){
            s[i] = '9';
        }
        return Integer.parseInt(new String(s));
    }
}
// @lc code=end

