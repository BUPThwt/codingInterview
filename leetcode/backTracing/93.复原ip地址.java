import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原IP地址
 */

// @lc code=start
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if(s.length() < 4 || s.length() > 12){
            return result;
        }
        Deque<String> path = new ArrayDeque<>();
        backTracing(s, 0, 4, result, path);
        return result;
    }

    private void backTracing(String s, int startIndex, int left, List<String> result, Deque<String> path){
        if(left == 0 && startIndex == s.length()){
            result.add(String.join(".", path));
            return;
        }
        for(int i = startIndex; i < startIndex + 3; i++){
            if(i >= s.length()){
                return;
            }
            if(valid(s, startIndex, i + 1)){
                path.add(s.substring(startIndex, i+ 1));
                backTracing(s, i + 1, left - 1, result, path);
                path.removeLast();
            }
        }
    }

    private boolean valid(String s, int start, int end){
        String str = s.substring(start, end);
        if(str.length() > 1 && str.startsWith("0")){
            return false;
        }
        int num = 0;
        for(int i = start; i < end; i++){
            num = num * 10 + s.charAt(i) - '0';
        }
        return num >= 0 && num <= 255;

    }


}
// @lc code=end

