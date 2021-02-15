import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

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
// class Solution {
//     public List<Integer> postorderTraversal(TreeNode root) {
//         List<Integer> result = new ArrayList<>();
//         postorderTraversal(root, result);
//         return result;
//     }

//     private void postorderTraversal(TreeNode root, List<Integer> result){
//         if(root == null){
//             return;
//         }
//         postorderTraversal(root.left, result);
//         postorderTraversal(root.right, result);
//         result.add(root.val);
//     }
// }


class Solution{
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> que = new Stack<>();
        if(root == null){
            return result;
        }
        que.push(root);
        while(!que.isEmpty()){
            TreeNode node = que.pop();
            if(node != null){
                que.push(node);
                que.push(null);
                if(node.right != null){
                    que.push(node.right);
                }
                if(node.left != null){
                    que.push(node.left);
                }
                
            }else{
                node = que.pop();
                result.add(node.val);
            }
        }
        return result;

    }
}
// @lc code=end

