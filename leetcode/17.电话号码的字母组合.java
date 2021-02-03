import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import jdk.jshell.Diag;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {

    String[] map = new String[]{
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };  
  
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if("".equals(digits)){
            return result;
        }
        char[] path = new char[digits.length()];
        backTracing(digits, 0, result, path);
        return result;
    }

    private void backTracing(String digits, int startIndex, List<String> result, char[] path){
        if(digits.length()  == startIndex){
            result.add(new String(path));
            return;
        }
        String str = map[digits.charAt(startIndex) - '0'];
        for(int i = 0; i < str.length(); i++){
            path[startIndex] = str.charAt(i);
            backTracing(digits, startIndex + 1, result, path);
        }
        
    }
}
// @lc code=end

