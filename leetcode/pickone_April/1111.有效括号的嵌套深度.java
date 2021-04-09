/*
 * @lc app=leetcode.cn id=1111 lang=java
 *
 * [1111] 有效括号的嵌套深度
 */

// @lc code=start
class Solution {
    //尽量均匀的分配给A,B，也就是均匀的分配（
    public int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int[seq.length()];
        int depth = 0;
        for(int i = 0; i < seq.length(); i++){
            if('(' == seq.charAt(i)){
                depth ++;
                ans[i] = depth % 2;
            }else{
                ans[i] = depth % 2;
                depth--;
            }
        }
        return ans;
    }
}
// @lc code=end

