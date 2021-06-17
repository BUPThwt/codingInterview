import java.util.LinkedList;
import java.util.Queue;

import javax.management.relation.Role;
import javax.print.DocPrintJob;
import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=513 lang=java
 *
 * [513] 找树左下角的值
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
    // public int findBottomLeftValue(TreeNode root) {
    //     Queue<TreeNode> queue = new LinkedList();
    //     queue.offer(root);
    //     int result = root.val;
    //     while(!queue.isEmpty()){
    //         int size = queue.size();
    //         for(int i = 0; i < size; i++){
    //             TreeNode node = queue.poll();
    //             if(i == 0){
    //                 result = node.val;
    //             }
    //             if(node.left != null){
    //                 queue.offer(node.left);
    //             }
    //             if(node.right != null){
    //                 queue.offer(node.right);
    //             }
    //         }
    //     }
    //     return result;
    // }

    int result;
    int maxDepth = Integer.MIN_VALUE;
    public int findBottomLeftValue(TreeNode root){
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode node, int depth){
        if(node == null){
            return;
        }
        dfs(node.left, depth + 1);
        if(depth > maxDepth){
            maxDepth = depth;
            result = node.val;
        }
        dfs(node.right, depth + 1);
    }
        
}
// @lc code=end

