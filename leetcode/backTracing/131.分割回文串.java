import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 */

// @lc code=start
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        Deque<String> path = new ArrayDeque<>();
        backTracing(s, 0, result, path);
        return result;
    }

    private void backTracing(String s, int startIndex, List<List<String>> result, Deque<String> path){
        if(startIndex == s.length()){
            result.add(new ArrayList(path));
            return;
        }
        for(int i = startIndex; i < s.length(); i++){
            if(isPalindrome(s, startIndex, i)){
                String str = s.substring(startIndex, i + 1);
                path.add(str);
                backTracing(s, i + 1, result, path);
                path.removeLast();
            }else{
                continue;
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right){
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
// @lc code=end

