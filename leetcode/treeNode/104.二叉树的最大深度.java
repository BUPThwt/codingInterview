import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.lang.model.element.QualifiedNameable;

/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
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
//     public int maxDepth(TreeNode root) {
//         return dfs(root, 0);
//     }

//     private int dfs(TreeNode node, int depth){
//         if(node == null){
//             return depth;
//         }
//         return Math.max(dfs(node.left, depth + 1), dfs(node.right, depth + 1));
//     }
// }


class Solution{
    public int maxDepth(TreeNode root){
        int maxDepth = 0;
        if(root == null){
            return maxDepth;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            maxDepth++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return maxDepth;
    }
}
// @lc code=end

