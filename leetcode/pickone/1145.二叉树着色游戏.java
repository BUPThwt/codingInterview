/*
 * @lc app=leetcode.cn id=1145 lang=java
 *
 * [1145] 二叉树着色游戏
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int left;
    int right;
    int num;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        num = x;
        int half = n / 2;
        dfs(root);
        if(left > half || right > half || left + right < half){
            return true;
        }else{
            return false;
        }
    }

    private int dfs(TreeNode root){
        int leftNum = 0;
        int rightNum = 0;
        if(root.left != null){
            leftNum = dfs(root.left);
        }
        if(root.right != null){
            rightNum = dfs(root.right);
        }
        if(root.val == num){
            left = leftNum;
            right = rightNum;
        }
        return leftNum + rightNum + 1;
    }
}
// @lc code=end

