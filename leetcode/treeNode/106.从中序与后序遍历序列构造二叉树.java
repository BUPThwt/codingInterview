import javax.sql.PooledConnection;

/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0 || postorder.length == 0){
            return null;
        }
        return buildTree(inorder, 0, inorder.length, postorder, 0, postorder.length);

    }

    private TreeNode buildTree(int[] inorder, int inLeft, int inRight, int[] postorder, int postLeft, int postRight){
        if(inLeft == inRight){
            return null;
        }
        int rootVal = postorder[postRight - 1];
        TreeNode root = new TreeNode(rootVal);
        int midIndex;
        for(midIndex = inLeft; midIndex < inRight; midIndex++){
            if(inorder[midIndex] == rootVal){
                break;
            }
        }
        root.left = buildTree(inorder, inLeft, midIndex, postorder, postLeft, postLeft + midIndex - inLeft);
        root.right = buildTree(inorder, midIndex + 1, inRight, postorder, postLeft + (midIndex - inLeft), postRight - 1);
        return root;
    }
}
// @lc code=end

