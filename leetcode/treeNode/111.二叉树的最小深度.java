import java.time.chrono.MinguoChronology;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.naming.ldap.ManageReferralControl;

/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
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
//     public int minDepth(TreeNode root) {
//         return dfs(root, 0);
//     }

//     private int dfs(TreeNode node, int depth){
//         if(node == null){
//             return depth;
//         }
//         if(node.left == null && node.right == null){
//             return depth + 1;
//         }
//         if(node.left == null){
//             return dfs(node.right, depth + 1);
//         }
//         if(node.right == null){
//             return dfs(node.left, depth + 1);
//         }
//         int left = dfs(node.left, depth + 1);
//         int right = dfs(node.right, depth + 1);
//         return Math.min(left, right);
//     }
// }

// class Solution{
//     public int minDepth(TreeNode root){
//         if(root == null){
//             return 0;
//         }
//         if(root.left == null && root.right != null){
//             return 1 + minDepth(root.right);
//         }
//         if(root.left != null && root.right == null){
//             return 1 + minDepth(root.left);
//         }
//         return 1 + Math.min(minDepth(root.left), minDepth(root.right));
//     }
// }


class Solution{
    public int minDepth(TreeNode root){
        int minDepth = 0;
        if(root == null){
            return minDepth;
        }
        Queue<TreeNode> quque = new LinkedList();
        quque.offer(root);
        while(!quque.isEmpty()){
            minDepth++;
            int size = quque.size();
            for(int i = 0; i < size; i++){
                TreeNode node = quque.poll();
                if(node.left != null){
                    quque.offer(node.left);
                }
                if(node.right != null){
                    quque.offer(node.right);
                }
                if(node.left == null && node.right == null){
                    return minDepth;
                }
            }
        }
        return minDepth;
    }
}
// @lc code=end

