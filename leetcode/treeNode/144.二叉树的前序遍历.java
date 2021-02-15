
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
// class Solution {
//     public List<Integer> preorderTraversal(TreeNode root) {
//         List<Integer> result = new ArrayList<>();
//         preorderTraversal(root, result);
//         return result;
//     }

//     private void preorderTraversal(TreeNode root, List<Integer> result){
//         if(root == null){
//             return;
//         }
//         result.add(root.val);
//         preorderTraversal(root.left, result);
//         preorderTraversal(root.right, result);
//     }
// }



class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Stack<TreeNode> que = new Stack();
        que.add(root);
        while(!que.isEmpty()){
            TreeNode node = que.pop();
            result.add(node.val);
            if(node.right != null){
                que.add(node.right);
            }
            if(node.left != null){
                que.add(node.left);
            }
        }
        return result;
        
    }
}
// @lc code=end

