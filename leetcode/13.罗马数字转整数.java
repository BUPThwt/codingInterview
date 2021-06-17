import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=13 lang=java
 *
 * [13] 罗马数字转整数
 */

// @lc code=start
class Solution {
    
    public int romanToInt(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for(int i = 1; i < s.length(); i++){
            int cur = getValue(s.charAt(i));
            if(preNum < cur){
                sum -= preNum;
            }else{
                sum += preNum;
            }
            preNum = cur;
        }
        sum += preNum;
        return sum;
    }

    private int getValue(char c){
        switch(c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
// @lc code=end

