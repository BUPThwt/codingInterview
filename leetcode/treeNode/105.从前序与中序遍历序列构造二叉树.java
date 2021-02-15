import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

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
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0){
            return null;
        }
        return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode buildTree(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight){
        if(inLeft == inRight){
            return null;
        }
        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);
        int midIndex;
        for(midIndex = inLeft; midIndex < inRight; midIndex++){
            if(inorder[midIndex] == rootVal){
                break;
            }
        }
        root.left = buildTree(preorder, preLeft + 1, preLeft + 1 + midIndex - inLeft, inorder, inLeft, midIndex);
        root.right = buildTree(preorder, preLeft + 1 + midIndex - inLeft, preRight, inorder, midIndex + 1, inRight);
        return root;
    }
}
// @lc code=end

