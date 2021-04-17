import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.Scrollable;


/*
 * @lc app=leetcode.cn id=1694 lang=java
 *
 * [1694] 重新格式化电话号码
 */

// @lc code=start
class Solution {
    public String reformatNumber(String number) {
        // 去除字符串中的’-‘和’ ‘
        StringBuilder newNumber = new StringBuilder();
        for(char c : number.toCharArray()){
            if(c != ' ' && c != '-'){
                newNumber.append(c);
            }
        }
        String newStr = newNumber.toString();
        StringBuilder sb = new StringBuilder();
        sb.append(newStr.charAt(0));
        for(int i = 1; i < newStr.length(); i++){
            // 每隔3个加分隔符
            if(i % 3 == 0){
                sb.append('-');
            }
            sb.append(newStr.charAt(i));
        }
        // 针对4个的情况，对倒数第二和倒数第三交换位置
        if(sb.charAt(sb.length() - 2) == '-'){
            return swap(sb.toString(), sb.length() - 3, sb.length() - 2);
        }
        return sb.toString();
        
    }

    private String swap(String s, int i, int j){
        char[] chars = s.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return String.valueOf(chars);
    }
}
// @lc code=end

