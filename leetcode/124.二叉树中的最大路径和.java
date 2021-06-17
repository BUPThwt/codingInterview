import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] 二叉树中的最大路径和
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
    int result;
    public int maxPathSum(TreeNode root) {
        result = Integer.MIN_VALUE;
        dfs(root);
        return result;
    }

    private int dfs(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));
        result = Math.max(result, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
}
// @lc code=end

