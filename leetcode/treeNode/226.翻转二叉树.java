import java.util.LinkedList;
import java.util.Queue;

import javax.management.Query;

/*
 * @lc app=leetcode.cn id=226 lang=java
 *
 * [226] 翻转二叉树
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
// class Solution {
//     public TreeNode invertTree(TreeNode root) {
//         if(root == null){
//             return root;
//         }
//         TreeNode temp = root.left;
//         root.left = root.right;
//         root.right = temp;
//         invertTree(root.right);
//         invertTree(root.left);
//         return root;
//     }
// }


class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
        }
        return root;
    }
}
// @lc code=end

