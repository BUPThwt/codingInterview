import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
       return height(root) != -1;
    }

    private int height(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = height(node.left);
        int right = height(node.right);
        if(left == -1 || right == -1){
            return -1;
        }
        return Math.abs(left - right) <= 1 ? 1 + Math.max(left, right) : -1; 
    }
}
// @lc code=end

