import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
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
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> result = new ArrayList<>();
//         inorderTraversal(root, result);
//         return result;
//     }

//     private void inorderTraversal(TreeNode root, List<Integer> result){
//         if(root == null){
//             return;
//         }
//         inorderTraversal(root.left, result);
//         result.add(root.val);
//         inorderTraversal(root.right, result);
//     }
// }

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null){
            return result;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node != null){
                if(node.right != null){
                    stack.push(node.right);
                }
                stack.push(node);
                stack.push(null);
                if(node.left != null){
                    stack.push(node.left);
                }
            }else{
                node = stack.pop();
                result.add(node.val);
            }
        }
        return result;
    }
}



// @lc code=end

