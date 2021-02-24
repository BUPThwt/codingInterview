/*
 * @lc app=leetcode.cn id=968 lang=java
 *
 * [968] 监控二叉树
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

    int result;
    public int minCameraCover(TreeNode root) {
        if(traversal(root) == 0){
            result++;
        }
        return result;
    }

    private int traversal(TreeNode root){
        if(root == null){
            return 2;
        }
        int left = traversal(root.left);
        int right = traversal(root.right);
        if(left == 2 && right == 2){
            return 0;
        }
        if(left == 0 || right == 0){
            result++;
            return 1;
        }
        return 2;
    }
}
// @lc code=end

