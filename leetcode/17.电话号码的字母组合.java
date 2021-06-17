import java.util.List;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {
    String[] words;
    List<String> result;
    public List<String> letterCombinations(String digits) {
        result = new ArrayList();
        if(digits.length() == 0){
            return result;
        }
        words = new String[]{
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };
        backTracing(digits, 0, "");
        return result;
    }

    private void backTracing(String digits, int start, String path){
        if(start == digits.length()){
            result.add(new String(path));
            return;
        }
        String digit = words[digits.charAt(start) - '0'];
        for(int i = 0; i < digit.length(); i++){
            backTracing(digits, start + 1, path + String.valueOf(digit.charAt(i)));
        }
    }
}
// @lc code=end

