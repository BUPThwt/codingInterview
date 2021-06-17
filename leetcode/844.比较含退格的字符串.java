import java.util.Stack;

/*
 * @lc app=leetcode.cn id=844 lang=java
 *
 * [844] 比较含退格的字符串
 */

// @lc code=start
class Solution {
    // public boolean backspaceCompare(String s, String t) {
    //     return build(s).equals(build(t));
    // }

    // private String build(String s){
    //     StringBuilder res = new StringBuilder();
    //     for(int i = 0; i < s.length(); i++){
    //         char c = s.charAt(i);
    //         if(c != '#'){
    //             res.append(c);
    //         }else{
    //             if(res.length() > 0){
    //                 res.deleteCharAt(res.length() - 1);
    //             }    
    //         }
    //     }
    //     return res.toString();
    // }

    public boolean backspaceCompare(String s, String t){
        int i = s.length() - 1;
        int j = t.length() - 1;
        int skipS = 0;
        int skipT = 0;
        while(i >= 0 || j >= 0){
            while(i >= 0){
                if(s.charAt(i) == '#'){
                    skipS++;
                    i--;
                }else if(skipS > 0){
                    skipS--;
                    i--;
                }else{
                    break;
                }
            }
            while(j >= 0){
                if(t.charAt(j) == '#'){
                    skipT++;
                    j--;
                }else if(skipT > 0){
                    skipT--;
                    j--;
                }else{
                    break;
                }
            }
            if(i >= 0 && j >= 0){
                if(s.charAt(i) != t.charAt(j)){
                    return false;
                }
            }else{
                if(i >= 0 || j >= 0){
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }
        
}
// @lc code=end

