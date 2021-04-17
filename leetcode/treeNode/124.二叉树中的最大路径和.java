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
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    // 返回node一边最大的值
    private int dfs(TreeNode node){
        if(node == null){
            return 0;
        }
        // 和0比较大小，表示可以取中间一段。
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));
        // 这边ans设置值，就是取当前节点为起始点的最大值。也就是可以不从根节点开始。
        ans = Math.max(ans, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
}
// @lc code=end

