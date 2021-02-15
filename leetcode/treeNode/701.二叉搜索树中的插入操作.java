/*
 * @lc app=leetcode.cn id=701 lang=java
 *
 * [701] 二叉搜索树中的插入操作
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
// class Solution {
//     public TreeNode insertIntoBST(TreeNode root, int val) {
//         if(root == null){
//             TreeNode node = new TreeNode(val);
//             return node;
//         }
//         if(root.val > val){
//             root.left = insertIntoBST(root.left, val);
//         }
//         if(root.val < val){
//             root.right = insertIntoBST(root.right, val);
//         }
//         return root;
//     }
// }

class Solution{
    public TreeNode insertIntoBST(TreeNode root, int val){
        if(root == null){
            return new TreeNode(val);
        }
        TreeNode parent = root;
        TreeNode cur = root;
        while(cur != null){
            parent = cur;
            if(cur.val < val){
                cur = cur.right;
            }else if(cur.val > val){
                cur = cur.left;
            }
        }
        if(parent.val < val){
            parent.right = new TreeNode(val);
        }else if(parent.val > val){
            parent.left = new TreeNode(val);
        }
        return root;
    }
}
// @lc code=end

