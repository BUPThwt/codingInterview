import jdk.jfr.Percentage;

/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
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
    TreeNode pre = null;
    public boolean isValidBST(TreeNode root) {
        return dfs(root);
    }

    private boolean dfs(TreeNode root){
        if(root == null){
            return true;
        }
        boolean left = dfs(root.left);
        if(pre != null){
            if(pre.val >= root.val){
                return false;
            }
        }
        pre = root;
        boolean right = dfs(root.right);
        return left && right;  
    }
}

// class Solution{
//     TreeNode pre = null;
//     public boolean isValidBST(TreeNode root){
//         if(root == null){
//             return true;
//         }
//         boolean left = isValidBST(root.left);
//         if(pre != null && pre.val >= root.val){
//             return false;
//         }
//         pre = root;
//         boolean right = isValidBST(root.right);
//         return left && right;
//     }

// }
// @lc code=end

