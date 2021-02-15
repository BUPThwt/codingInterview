import java.util.LinkedList;
import java.util.Queue;

import jdk.javadoc.internal.doclets.formats.html.resources.standard;

/*
 * @lc app=leetcode.cn id=222 lang=java
 *
 * [222] 完全二叉树的节点个数
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
//     public int countNodes(TreeNode root) {
//         int num = 0;
//         if(root == null){
//             return num;
//         }
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.offer(root);
//         while(!queue.isEmpty()){
//             int size = queue.size();
//             num += size;
//             for(int i = 0; i < size; i++){
//                 TreeNode node = queue.poll();
//                 if(node.left != null){
//                     queue.offer(node.left);
//                 }
//                 if(node.right != null){
//                     queue.offer(node.right);
//                 }
//             }
//         }
//         return num;
//     }
// }


// class Solution {
//     public int countNodes(TreeNode root) {
//        if(root == null){
//            return 0;
//        }
//        return 1 + countNodes(root.left) + countNodes(root.right);
//     }
// }

class Solution {
    public int countNodes(TreeNode root) {
       if(root == null){
           return 0;
       }
       int leftDepth = 0;
       int rightDepth = 0;
       TreeNode left = root.left;
       TreeNode right = root.right;
       while(left != null){
           left = left.left;
           leftDepth++;
       }
       while(right != null){
           right = right.right;
           rightDepth++;
       }
       if(leftDepth == rightDepth){
           return (2 << leftDepth) - 1;
       }
       return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
// @lc code=end

