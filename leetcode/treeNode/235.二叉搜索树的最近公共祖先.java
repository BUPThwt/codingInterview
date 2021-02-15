

/*
 * @lc app=leetcode.cn id=235 lang=java
 *
 * [235] 二叉搜索树的最近公共祖先
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return root;
        }
        if(root.val < p.val && root.val < q.val){
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if(right != null){
                return right;
            }
        }
        if(root.val > p.val && root.val > q.val){
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            if(left != null){
                return left;
            }
        }
        return root;
    }
}
// @lc code=end

