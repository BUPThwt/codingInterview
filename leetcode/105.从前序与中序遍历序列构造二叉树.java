import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0){
            return null;
        }
        return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
        if(preStart == preEnd){
            return null;
        }
        int rootVal = preorder[preStart];
        int index = inStart;
        while(index < inEnd){
            if(inorder[index] == rootVal){
                break;
            }
            index++;
        }
        TreeNode node = new TreeNode(rootVal);
        node.left = buildTree(preorder, preStart + 1, preStart + 1 + index - inStart, inorder, inStart, index);
        node.right = buildTree(preorder, preStart + 1 + index - inStart, preEnd, inorder, index + 1, inEnd);
        return node;
    }
}
// @lc code=end

