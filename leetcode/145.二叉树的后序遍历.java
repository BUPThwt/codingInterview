import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
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
    // List<Integer> result;
    // public List<Integer> postorderTraversal(TreeNode root) {
    //     result = new ArrayList<>();
    //     dfs(root);
    //     return result;
    // }

    // private void dfs(TreeNode node){
    //     if(node == null){
    //         return;
    //     }
    //     dfs(node.left);
    //     dfs(node.right);
    //     result.add(node.val);
    // }

    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            if(node.left != null){
                stack.push(node.left);
            }
            if(node.right != null){
                stack.push(node.right);
            }
        }
        Collections.reverse(result);
        return result;
    }
}
// @lc code=end

