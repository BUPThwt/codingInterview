import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=99 lang=java
 *
 * [99] 恢复二叉搜索树
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
    TreeNode x = null;
    TreeNode y = null;
    TreeNode pre = null;
    public void recoverTree(TreeNode root) {
        dfs(root);
        if(x != null && y != null){
            int temp = x.val;
            x.val = y.val;
            y.val = temp;
        }
    }

    private void dfs(TreeNode node){
        if(node == null){
            return;
        }
        dfs(node.left);
        if(pre == null){
            pre = node;
        }else{
            if(node.val < pre.val){
                y = node;
                if(x == null){
                    x = pre;
                }
            }
            pre = node;
        }
        dfs(node.right);
    }
}
// @lc code=end

