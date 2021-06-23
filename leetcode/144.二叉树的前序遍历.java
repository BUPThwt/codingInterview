import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
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
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     List<Integer> result = new ArrayList();
    //     if(root == null){
    //         return result;
    //     }
    //     Stack<TreeNode> stack = new Stack<>();
    //     stack.push(root);
    //     while(!stack.isEmpty()){
    //         TreeNode node = stack.pop();
    //         result.add(node.val);
    //         if(node.right != null){
    //             stack.push(node.right);
    //         }
    //         if(node.left != null){
    //             stack.push(node.left);
    //         }
    //     }
    //     return result;
    // }

    List<Integer> result;
    public List<Integer> preorderTraversal(TreeNode root){
        result = new ArrayList<>();
        dfs(root);
        return result;
    }

    private void dfs(TreeNode node){
        if(node == null){
            return;
        }
        result.add(node.val);
        dfs(node.left);
        dfs(node.right);
    }
}
// @lc code=end

