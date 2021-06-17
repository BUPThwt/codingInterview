import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=543 lang=java
 *
 * [543] 二叉树的直径
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
    int result = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return result;
    }

    // 节点个数
    private int dfs(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        result = Math.max(result, left + right);
        return Math.max(left, right) + 1;
    }
    
}
// @lc code=end

