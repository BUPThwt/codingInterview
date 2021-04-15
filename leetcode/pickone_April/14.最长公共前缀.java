/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        int minLen = Integer.MAX_VALUE;
        String minStr = "";
        for(String str : strs){
            if(str.length() < minLen){
                minLen = str.length();
                minStr = str;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < minStr.length(); i++){
            char c = minStr.charAt(i);
            boolean flag = true;
            for(String str : strs){
                if(str.charAt(i) != c){
                    flag = false;
                    break;
                }
            }
            if(flag){
                sb.append(c);
            }else{
                break;
            }
        }
        return sb.toString();
    }
}
// @lc code=end

